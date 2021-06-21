package shop.saarth.plant.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "user_details")
public class User {

    @Id
    @GeneratedValue
    private UUID userId;

    private String userName;
    private String address;
    private String otp;
    private String name;

    public User() {

    }
    public User(UUID userId, String userName, String otp, String address, String name) {
        this.userId = userId;
        this.userName = userName;
        this.otp = otp;
        this.address = address;
        this.name = name;
    }
    public User(String userName, String otp, String address, String name) {
        this.userName = userName;
        this.otp = otp;
        this.address = address;
        this.name = name;
    }

    public UUID getUserId() { return userId; }
    public void setUserId(UUID userId) { this.userId = userId; }

    public String getUserName() { return userName; }
    public void setUserName(String name) { this.userName = name; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }

    public String getAddress() { return address; }
    public void setAddress(String address ) {this.address = address; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId)
                && Objects.equals(userName, user.userName)
                && Objects.equals(address, user.address)
                && Objects.equals(otp, user.otp)
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, address, otp, name);
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", address='" + address + '\'' +
                ", otp='" + otp + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
