package shop.saarth.plant.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product_details")
public class ProductDetails {

    @Id
    @GeneratedValue
    private UUID id;
    
    private String name;
    private String image;
    private String storeName;
    private String type;
    private String subType;
    private float gst;
    private float maxPrice;
    private float price;
    private boolean stock;

    public ProductDetails(){
    }

    public ProductDetails(UUID id,
                          String name,
                          String image,
                          String storeName,
                          String type,
                          String subType,
                          float gst,
                          float maxPrice,
                          float price,
                          boolean stock) {
        this.id = id;
        this.name = name;
        this.name = storeName;
        this.image = image;
        this.type = type;
        this.type = subType;
        this.gst = gst;
        this.maxPrice = maxPrice;
        this.price = price;
        this.stock = stock;
    }

    public ProductDetails(String name,
                          String image,
                          String storeName,
                          String type,
                          String subType,
                          float gst,
                          float maxPrice,
                          float price,
                          boolean stock) {
        this.name = name;
        this.image = image;
        this.storeName = storeName;
        this.type = type;
        this.gst = gst;
        this.subType = subType;
        this.maxPrice = maxPrice;
        this.price = price;
        this.stock = stock;
    }

    public UUID getID() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getSubType() { return subType; }
    public void setSubType(String subType) { this.subType = subType; }

    public float getMaxPrice() { return maxPrice; }
    public void setMaxPrice(float maxPrice) { this.maxPrice = maxPrice; }

    public float getPrice() { return price; }
    public void setPrice(float price) { this.price = price; }

    public float getGst() { return gst; }
    public void setGst(float gst) { this.gst = gst; }

    public boolean getStock() { return stock; }
    public void setStock(boolean stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "ProductDetails{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", storeName='" + storeName + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                ", gst=" + gst +
                ", maxPrice=" + maxPrice +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}
