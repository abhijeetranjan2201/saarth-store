package shop.saarth.plant.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository user) {
        return args -> {
            User tester = new User(
                    "9472966074",
                    "555662",
                    "Test",
                    "Test"
            );
            user.saveAll(List.of(tester));
        };
    }
}
