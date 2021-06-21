package shop.saarth.plant.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/api/user")
    public List<User> getUser() {
        return userService.listUser();
    }

    @PostMapping(path = "/api/add/user")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping(path = "/api/authentication")
    public String verify(@RequestBody AuthRequest authRequest) throws Exception {
        return userService.generateToken(authRequest);
    }

    @GetMapping(path = "/api/login")
    public void loginUser(@RequestParam(required = false) String userName) {
        userService.login(userName);
    }

    @PutMapping(path = "/api/user/update/{userId}/name/")
    public void updateName(
            @PathVariable("userID") UUID userId,
            @RequestParam(required = false) String name) {
        userService.updateName(userId, name);
    }

    @PutMapping(path = "/api/user/update/{userId}/address/")
    public void updateAddress(
            @PathVariable("userId") UUID userId,
            @RequestParam(required = false) String address) {
        userService.updateAddress(userId, address);
    }
}
