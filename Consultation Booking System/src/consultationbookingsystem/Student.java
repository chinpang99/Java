package consultationbookingsystem;

import java.util.ArrayList;

public class Student extends User{
    private String degree;
    private ArrayList<Consultation> stucons;

    public Student(String userid, String name, String password, String email, String image, String phonenum, String degree) {
        super(userid, name, password, email, image, phonenum);
        this.degree = degree;
        stucons = new ArrayList<Consultation>();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }
    
    public void book(Consultation c){
        c.setStudent(this);
        stucons.add(c);
    }

    public ArrayList<Consultation> getCons() {
        return stucons;
    }
    
    public void editProfile(String name, String email, String phonenum, String degree){
        this.setName(name);
        this.setEmail(email);
        this.setPhonenum(phonenum);
        this.degree = degree;
    }
}
