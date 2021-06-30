package shop.saarth.plant.seller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "seller_details")
public class SellerDetails {

    @Id
    @GeneratedValue
    private UUID sellerId;

    private String sellerName;
    private String sellerShopName;
    private String sellerEmail;
    private String password;

    public UUID getSellerId() {
        return sellerId;
    }

    public void setSellerId(UUID sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerShopName() {
        return sellerShopName;
    }

    public void setSellerShopName(String sellerShopName) {
        this.sellerShopName = sellerShopName;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellerDetails that = (SellerDetails) o;
        return Objects.equals(sellerId, that.sellerId)
                && Objects.equals(sellerName, that.sellerName)
                && Objects.equals(sellerShopName, that.sellerShopName)
                && Objects.equals(sellerEmail, that.sellerEmail)
                && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sellerId, sellerName, sellerShopName, sellerEmail, password);
    }
}
