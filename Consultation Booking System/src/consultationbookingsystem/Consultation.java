package consultationbookingsystem;
public class Consultation {
    private Student s;
    private Lecturer l;
    private String venue,day,time;

    public Consultation(Lecturer l, String venue, String day, String time) {
        this.l = l;
        this.venue = venue;
        this.day = day;
        this.time = time;
    }
    
    public void setStudent(Student s){
        this.s = s;
    }

    public Student getS() {
        return s;
    }

    public Lecturer getL() {
        return l;
    }

    public String getVenue() {
        return venue;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }
    
    public void setVenue(String venue) {
        this.venue = venue;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
