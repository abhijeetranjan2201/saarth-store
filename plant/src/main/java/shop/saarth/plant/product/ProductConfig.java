package shop.saarth.plant.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository product) {
        return args -> {
            ProductDetails eatable = new ProductDetails(
                    "Test Eatable",
                    null,
                    "Test Saarth-Store",
                    "Test Grocery",
                    "Test Daily Essential",
                    12,
                    150,
                    200,
                    false
            );
            product.saveAll(List.of(eatable));
        };
    }
}
