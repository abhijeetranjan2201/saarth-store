package shop.saarth.plant.user;

public class AuthRequest {
    private String userName;
    private String otp;

    public AuthRequest() { }
    public AuthRequest(String userName, String otp) {
        this.userName = userName;
        this.otp = otp;
    }
    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getOtp() { return otp; }
    public void setOtp(String otp) { this.otp = otp; }
}
