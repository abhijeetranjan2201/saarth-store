package shop.saarth.plant.basket;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "basket")
public class Basket {

    @Id
    @GeneratedValue
    private Integer basketId;


}
