package shop.saarth.plant.basket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.saarth.plant.product.ProductRepository;

@Service
public class BasketServices {

    @Autowired
    private final BasketRepository basketRepository;
    private final ProductRepository productRepository;

    public BasketServices (BasketRepository basketRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.productRepository = productRepository;
    }

}
