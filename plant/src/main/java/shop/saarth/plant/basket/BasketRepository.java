package shop.saarth.plant.basket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.saarth.plant.user.User;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<Basket, Integer> {

    public List<Basket> findByUser(User user);
}
