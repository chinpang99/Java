package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class guiLogin implements ActionListener{
    private JFrame x;
    private ArrayList<Student> std;
    private ArrayList<Lecturer> lec;
    private ArrayList<Consultation> cons;
    private JLabel title, lblUserid, lblPwd;
    private JTextField txtUserid;
    private JPasswordField txtPwd;
    private JCheckBox chkShow;
    private JButton btnLogin, btnRegister, btnClose;
    private SguiDashboard studentdashboard;
    private SguiRegister registerpage;
    private LguiDashboard lecturerdashboard;// Pang
    int pX,pY;
    
    public void setSguiDashboard(SguiDashboard a){
        studentdashboard = a;
    }
    
    public void setSguiRegister(SguiRegister a){
        registerpage = a;
    }
    
    public void setLguiDashboard(LguiDashboard b){ //Pang
        lecturerdashboard = b;
    }
    
    public JFrame getLoginPage(){
        return x;
    }
    
    public guiLogin(ArrayList<Student> s, ArrayList<Lecturer> l, ArrayList<Consultation> c){
        std = s;
        lec = l;
        cons = c;
        
        x = new JFrame("Login");
        x.setSize(350, 450);
        x.setResizable(false);
        x.setDefaultCloseOperation(x.EXIT_ON_CLOSE);
        x.setUndecorated(true);
        x.setLocationRelativeTo(null);
        x.setLayout(null);
        x.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                pX=me.getX();
                pY=me.getY();
            }
        });
        
        x.addMouseMotionListener(new MouseAdapter(){
            public void mouseDragged(MouseEvent me)
            {
                x.setLocation(x.getLocation().x+me.getX()-pX,x.getLocation().y+me.getY()-pY);
            }
        });
        
        title= new JLabel("Consultation Booking System");
        title.setFont(new Font("Calibri", Font.PLAIN, 20));
        lblUserid= new JLabel("User ID :");
        lblPwd= new JLabel("Password :");
        txtUserid= new JTextField();
        txtPwd= new JPasswordField();
        btnLogin = new JButton("Login");
        btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnLogin.addActionListener(this);
        btnRegister = new JButton("Register");
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRegister.addActionListener(this);
        btnClose = new JButton("X");
        btnClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnClose.addActionListener(this);  
        chkShow = new JCheckBox();
        chkShow.addActionListener(this);
        
        title.setBounds(50,50,400,100);
        lblUserid.setBounds(70, 180, 100, 30);
        lblPwd.setBounds(70,230,100,30);
        txtUserid.setBounds(175,180,100,30);
        txtPwd.setBounds(175,230,100,30);
        chkShow.setBounds(280,235,20,20);
        btnLogin.setBounds(125,320,100,35);
        btnRegister.setBounds(130,380,90,30);
        btnClose.setBounds(300,0,50,50);
        
        x.add(title);
        x.add(lblUserid);
        x.add(lblPwd);
        x.add(txtUserid);
        x.add(txtPwd);
        x.add(chkShow);
        x.add(btnLogin);
        x.add(btnRegister);
        x.add(btnClose);
        x.getRootPane().setDefaultButton(btnLogin);
        
        x.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnLogin){
            User current = null;
            while(true){
                String userid = txtUserid.getText();
                String password = txtPwd.getText();
                
                for(int i=0; i<std.size(); i++){
                    User ac = std.get(i);
                    if(ac.getUserid().equals(userid) && ac.getPassword().equals(password)){
                        current = ac;
                        break;
                    }
                }  
                
                for(int i=0; i<lec.size(); i++){
                    User ac = lec.get(i);
                    if(ac.getUserid().equals(userid) && ac.getPassword().equals(password)){
                        current = ac;
                        break;
                    }
                }
                
                if(current!=null){
                    break;
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect User ID or Password!");
                    txtPwd.setText("");
                    txtUserid.requestFocus();
                    txtUserid.selectAll();
                    break;
                }
            }
            
            if(current!=null){
                if(current instanceof Student){
                    x.setVisible(false);
                    txtPwd.setText("");
                    txtUserid.requestFocus();
                    txtUserid.selectAll();
                    Student curr = (Student)current;
                    studentdashboard.setUser(curr);
                    studentdashboard.getStudentDashboard().setVisible(true);
                }else if(current instanceof Lecturer){
                    x.setVisible(false);
                    txtPwd.setText("");
                    txtUserid.requestFocus();
                    txtUserid.selectAll();
                    Lecturer curr = (Lecturer)current;
                    lecturerdashboard.setUser(curr);
                    lecturerdashboard.setVisible(true);
                    lecturerdashboard.setBoolean(true); 
                    lecturerdashboard.lblText.setText(current.getName());
                    
                }
               
            }
            
            
        }else if(e.getSource()==chkShow){
            if (chkShow.isSelected()) {
                txtPwd.setEchoChar((char)0);
            } else {
            txtPwd.setEchoChar('•');
            }
            
        }else if(e.getSource()==btnRegister){
            x.setVisible(false);
            registerpage.setUserID();
            registerpage.getRegisterPage().setVisible(true);
            
        }else if(e.getSource()==btnClose){
            try{
                PrintWriter pstudent = new PrintWriter("student.txt");
                for(int i=0; i<std.size(); i++){
                    Student a = std.get(i);
                    pstudent.println(a.getUserid());
                    pstudent.println(a.getName());
                    pstudent.println(a.getPassword());
                    pstudent.println(a.getEmail());
                    pstudent.println(a.getImage());
                    pstudent.println(a.getPhonenum());
                    pstudent.println(a.getDegree()+"\n");
                }
                pstudent.close();
                
                PrintWriter plecturer = new PrintWriter("lecturer.txt");
                for(int i=0; i<lec.size(); i++){
                    Lecturer a = lec.get(i);
                    plecturer.println(a.getUserid());
                    plecturer.println(a.getName());
                    plecturer.println(a.getPassword());
                    plecturer.println(a.getEmail());
                    plecturer.println(a.getImage());
                    plecturer.println(a.getPhonenum());
                    plecturer.println(a.getSchool()+"\n");
                }
                plecturer.close();
                
                PrintWriter pcons = new PrintWriter("consultation.txt");
                for(int i=0; i<cons.size(); i++){
                    Consultation a = cons.get(i);
                    pcons.println(a.getL().getUserid());
                    pcons.println(a.getVenue());
                    pcons.println(a.getDay());
                    pcons.println(a.getTime());
                    if(a.getS()==null){
                        pcons.println("null"+"\n");
                    }else{
                        pcons.println(a.getS().getUserid()+"\n");
                    }
                }
                pcons.close();
            }catch(Exception Ex){
                
            }
            System.exit(0);
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
