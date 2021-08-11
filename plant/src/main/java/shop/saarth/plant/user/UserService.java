package shop.saarth.plant.user;

import com.amazonaws.services.sns.model.MessageAttributeValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.saarth.plant.message.Message;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;
    private final Message message;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService (UserRepository userRepository,
                        Message message,
                        JwtUtil jwtUtil,
                        AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.message = message;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    public List<User> listUser(){
        return userRepository.findAll();
    }

    @Transactional
    public void addUser(User user) {
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();

        smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue("ESAART")
                .withDataType("String"));

        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                        .withStringValue("Transactional")
                        .withDataType("String"));

        Random rn = new Random();
        int num = rn.nextInt(999999);
        String pass = String.format("%06d", num);
        userRepository.save(user);

        String otp = "Welcome to SAARTH. Your OTP is " + pass + " Be it hunger to everything rare! " +
                "Build for Convenience";
        String number = "+91 "+user.getUserName();
        UUID id = user.getUserId();
        System.out.println(id);
        otpSetter(id, pass);
        message.sendSMSMessage( otp, number, smsAttributes);
    }

    private void otpSetter(UUID id, String pass) {
        User client = userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("User does not exist"));
        client.setOtp(pass);
    }
    
    @ResponseBody
    @Transactional
    public void login(String username) {
        Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();

        smsAttributes.put("AWS.SNS.SMS.SenderID", new MessageAttributeValue()
                .withStringValue("ESAART")
                .withDataType("String"));

        smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                .withStringValue("Transactional")
                .withDataType("String"));

        Random rn = new Random();
        int num = rn.nextInt(999999);
        String pass = String.format("%06d", num);

        String otp = "Welcome to SAARTH. Your OTP is " + pass + " Be it hunger to everything rare! " +
                "Build for Convenience";

        User user = userRepository.findByUserName(username);
        user.setOtp(pass);
        message.sendSMSMessage( otp, "+91 " + username, smsAttributes);
    }    

    public String generateToken(AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getOtp())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

    @Transactional
    public void updateName(UUID userId, String name) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with " + userId + " does not exist"));

        user.setName(name);
    }

    @Transactional
    public void updateAddress(UUID userId, String address) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException("User with " + userId + " does not exist"));

        user.setAddress(address);
    }

}
