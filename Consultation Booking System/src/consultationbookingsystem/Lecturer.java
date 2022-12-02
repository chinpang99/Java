package consultationbookingsystem;

import java.util.ArrayList;

public class Lecturer extends User{
    private String school;
    private ArrayList<Consultation> cons;
    
    public Lecturer(String userid, String name, String password, String email, String image, String phonenum, String school) {
        super(userid, name, password, email, image, phonenum);
        this.school = school;
        cons = new ArrayList<Consultation>();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    
    public void createConsultation(String venue, String day, String time){
        cons.add(new Consultation(this, venue, day, time));
    }

    public ArrayList<Consultation> getCons() {
        return cons;
    }
    
    public void addCons(Consultation c){
        cons.add(c);
    }
    
    public void editProfile(String userid, String password, String name, String email, String image, String phonenum, String school){
        this.setUserid(userid);
        this.setPassword(password);
        this.setName(name);
        this.setEmail(email);
        this.setImage(image);
        this.setPhonenum(phonenum);
        this.school = school;
    }
}
