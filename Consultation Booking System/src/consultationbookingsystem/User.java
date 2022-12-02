package consultationbookingsystem;

import java.util.ArrayList;

public abstract class User {
    private String userid;
    private String name;
    private String password;
    private String email;
    private String image;
    private String phonenum;
    
    public User() {
    }

    public User(String userid, String name, String password, String email, String image, String phonenum) {
        this.userid = userid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.image = image;
        this.phonenum = phonenum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhonenum() {
        return phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.phonenum = phonenum;
    }
    
    @Override //Pang
    public String toString() {
        return "User{" + "userid=" + userid + ", name=" + name + ", password=" + password + ", email=" + email + ", image=" + image + ", phonenum=" + phonenum + '}';
    }
    
    public abstract ArrayList<Consultation> getCons();
}
