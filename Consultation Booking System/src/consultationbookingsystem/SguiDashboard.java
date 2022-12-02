package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class SguiDashboard implements ActionListener{
    private Student current;
    private JFrame x;
    private JLabel lblTitle,lbl1, lblName, lblRole;
    private JPanel top, sidenav;
    private JButton btnProfile, btnBook, btnMyBook;
    private JButton btnLogout;
    private guiLogin loginpage;
    int pX,pY;
    private ArrayList<Student> std;
    private ArrayList<Lecturer> lec;
    private ArrayList<Consultation> cons;
    private SguiMyProfile myprofile;
    private SguiBookConsultation bookconsultation;
    protected SguiMyBookings mybookings;
    
    public void setName(String a){
        lblName.setText(a);
    }
    
    public void setSguiMyProfile(SguiMyProfile a){
        myprofile = a;
    }
    
    public void setSguiBookConsultation(SguiBookConsultation a){
        bookconsultation = a;
    }
    
    public void setSguiMyBookings(SguiMyBookings a){
        mybookings = a;
    }
    
    public JFrame getStudentDashboard(){
        return x;
    }
    
    public void setUser(Student x){
        current = x;
        lblName.setText(current.getName());
        myprofile.setVisible(false);
        myprofile.setCurrentUser(current);
        bookconsultation.setVisible(false);
        bookconsultation.setCurrent(current);
        mybookings.setVisible(false);
        mybookings.setCurrentUser(current);
    }
    
    //SguiMyProfile myprofile = new SguiMyProfile();
    //SguiBookConsultation bookconsultation = new SguiBookConsultation();
    //SguiMyBookings mybookings = new SguiMyBookings();
    
    public SguiDashboard(guiLogin a){
        loginpage = a;
        loginpage.setSguiDashboard(this);
        
        std = loginpage.getStd();
        lec = loginpage.getLec();
        cons = loginpage.getCons();
        
        x = new JFrame("Student Dashboard");
        x.setSize(1000, 600);
        x.setResizable(false);
        x.setDefaultCloseOperation(x.EXIT_ON_CLOSE);
        x.setLocationRelativeTo(null);
        x.setUndecorated(true);
        
        top = new JPanel();
        sidenav = new JPanel();
        
        top.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                pX=me.getX();
                pY=me.getY();
            }
        });
        
        top.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me)
            {
                x.setLocation(x.getLocation().x+me.getX()-pX,x.getLocation().y+me.getY()-pY);
            }
        });
        
        lblTitle = new JLabel("Consultation Booking System");
        lblTitle.setFont(new Font("Calibri", Font.BOLD, 32));
        lbl1 = new JLabel("Name : ");
        lblName = new JLabel();
        //lblName.setText(current.getName());
        lblRole = new JLabel("Role :      Student");
        btnLogout = new JButton("Logout");
        
        lblTitle.setBounds(30,30,400,50);
        lbl1.setBounds(700,25,70,30);
        lblName.setBounds(750,25,100,30);
        lblRole.setBounds(700,50,170,30);
        btnLogout.setBounds(880,37,90,30);
        btnLogout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnProfile = new JButton("My Profile");
        btnBook = new JButton("Book Consultation");
        btnMyBook = new JButton("My Bookings");
        btnProfile.addActionListener(this);
        btnBook.addActionListener(this);
        btnMyBook.addActionListener(this);
        btnLogout.addActionListener(this);
        
        top.setLayout(null);
        top.setPreferredSize(new Dimension(1000, 100));
        top.setBackground(Color.LIGHT_GRAY);
        sidenav.setLayout(new GridLayout(3,1));
        sidenav.setPreferredSize(new Dimension(150, 500));
        
        top.add(lblTitle);
        top.add(lbl1);
        top.add(lblName);
        top.add(lblRole);
        top.add(btnLogout);
        
        sidenav.add(btnProfile);
        sidenav.add(btnBook);
        sidenav.add(btnMyBook);
        
        x.add(top,BorderLayout.NORTH);
        x.add(sidenav,BorderLayout.WEST);

    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnProfile){
            x.add(myprofile, BorderLayout.CENTER);
            myprofile.setVisible(true);
            myprofile.editprofile.setVisible(false);
            myprofile.changepassword.setVisible(false);
            bookconsultation.setVisible(false);
            bookconsultation.lechours.setVisible(false);
            mybookings.setVisible(false);
        }else if(e.getSource()==btnBook){
            x.add(bookconsultation, BorderLayout.CENTER);
            bookconsultation.setVisible(true);
            myprofile.setVisible(false);
            myprofile.editprofile.setVisible(false);
            myprofile.changepassword.setVisible(false);
            bookconsultation.lechours.setVisible(false);
            mybookings.setVisible(false);
        }else if(e.getSource()==btnMyBook){
            x.add(mybookings, BorderLayout.CENTER);
            mybookings.setVisible(true);
            mybookings.setCurrentUser(current);
            myprofile.setVisible(false);
            myprofile.editprofile.setVisible(false);
            myprofile.changepassword.setVisible(false);
            bookconsultation.setVisible(false);
            bookconsultation.lechours.setVisible(false);
        }else if (e.getSource()==btnLogout){
            myprofile.setVisible(false);
            myprofile.editprofile.setVisible(false);
            myprofile.changepassword.setVisible(false);
            mybookings.setVisible(false);
            bookconsultation.setVisible(false);
            bookconsultation.lechours.setVisible(false);
            x.setVisible(false);
            loginpage.getLoginPage().setVisible(true);
            
        }
    }
    
    public ArrayList<Student> getStd() {
        return std;
    }

    public ArrayList<Lecturer> getLec() {
        return lec;
    }

    public ArrayList<Consultation> getCons() {
        return cons;
    }
    
}
