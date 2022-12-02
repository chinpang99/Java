package consultationbookingsystem;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsultationBookingSystem {
    public static void main(String[] args) {
        ArrayList<Student> std;
        ArrayList<Lecturer> lec;
        ArrayList<Consultation> cons;
        try{
            Scanner sc1 = new Scanner(new File("student.txt"));
            std = new ArrayList<Student>();
            while(sc1.hasNext()){
                String a = sc1.nextLine();
                String b = sc1.nextLine();
                String c = sc1.nextLine();
                String d = sc1.nextLine();
                String e = sc1.nextLine();
                String f = sc1.nextLine();
                String g = sc1.nextLine();
                sc1.nextLine();
                
                Student x = new Student(a,b,c,d,e,f,g);
                std.add(x);
            }
            
            Scanner sc2 = new Scanner(new File("lecturer.txt"));
            lec = new ArrayList<Lecturer>();
            while(sc2.hasNext()){
                String a = sc2.nextLine();
                String b = sc2.nextLine();
                String c = sc2.nextLine();
                String d = sc2.nextLine();
                String e = sc2.nextLine();
                String f = sc2.nextLine();
                String g = sc2.nextLine();
                sc2.nextLine();
                
                Lecturer x = new Lecturer(a,b,c,d,e,f,g);
                lec.add(x);
            }
            
            Scanner sc3 =new Scanner(new File("consultation.txt"));
            cons = new ArrayList<Consultation>();
            while(sc3.hasNext()){
                String lect1 = sc3.nextLine();
                Lecturer lect = null;
                for(int i=0; i<lec.size(); i++){
                    Lecturer x = lec.get(i);
                    if(lect1.equals(x.getUserid())){
                        lect = x;
                        break;
                    }
                }
                String venue = sc3.nextLine();
                String day = sc3.nextLine();
                String time = sc3.nextLine();
                String stud1 = sc3.nextLine();
                Student stud = null;
                sc3.nextLine();
                
                Consultation a = new Consultation(lect, venue, day, time);
                for(int i=0; i<std.size(); i++){
                    Student y = std.get(i);
                    if(stud1.equals(y.getUserid())){
                        stud = y;
                        a.setStudent(stud);
                        break;
                    }
                } 
                
                cons.add(a);
                
                for(int i=0; i<lec.size(); i++){
                    Lecturer x = lec.get(i);
                    if(lect1.equals(x.getUserid())){
                        x.getCons().add(a);
                        break;
                    }
                }
                for(int i=0; i<std.size(); i++){
                    Student y = std.get(i);
                    if(stud1.equals(y.getUserid())){
                        y.getCons().add(a);
                        break;
                    }
                }
            }
                                
        }catch(Exception e){
            std = new ArrayList<Student>();
            lec = new ArrayList<Lecturer>();
            cons = new ArrayList<Consultation>();
        }
        
        guiLogin a = new guiLogin(std, lec, cons);
        SguiRegister r = new SguiRegister(a);
        SguiDashboard b = new SguiDashboard(a);
        SguiMyProfile b1 = new SguiMyProfile(b);
        SguiEditProfile b1a = new SguiEditProfile(b1);
        SguiChangePassword b1b = new SguiChangePassword(b1);
        SguiBookConsultation b2 = new SguiBookConsultation(b);
        SguiLecHours b2a = new SguiLecHours(b2);
        SguiMyBookings b3 = new SguiMyBookings(b);
        
        LguiDashboard c = new LguiDashboard(a);
        LguiManageProfile ca1 = new LguiManageProfile(c);
        LguiChangePassword ca2 = new LguiChangePassword(ca1);
        LguiCreateConsultation cb1 = new LguiCreateConsultation(c);
        LguiCreateConsultationn cb2 = new LguiCreateConsultationn(cb1);
        LguiCalendar cc1 = new LguiCalendar(c);
        LguiAppointment cc2 = new LguiAppointment(cc1);
        LguiEditConsultation cc3 = new LguiEditConsultation(cc2);
        LguiEditConsultation_Venue cc4 = new LguiEditConsultation_Venue(cc3);
        LguiMyConsultationVenue cd1 = new LguiMyConsultationVenue(c);
    } 
}
