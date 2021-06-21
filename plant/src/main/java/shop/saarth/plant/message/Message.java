package shop.saarth.plant.message;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class Message {

    private final AmazonSNS sns;

    @Autowired
    public Message (AmazonSNS sns) {
        this.sns = sns;
    }

    public void sendSMSMessage(String message, String phoneNumber,
                               Map<String, MessageAttributeValue> smsAttributes) {

        sns.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));
    }
}
