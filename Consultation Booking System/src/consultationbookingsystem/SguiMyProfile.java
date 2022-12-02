package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
public class SguiMyProfile extends JPanel implements ActionListener{
    private Student current;
    private JLabel lbl1;
    private JLabel lblProfile, lblID, lblName, lblEmail,lblPhonenum,lblDegree;
    private JLabel lbl2,lbl3,lbl4,lbl5,lbl6;
    private ImageIcon imgProfile;
    private JButton btnEditProfile, btnChgPwd;
    protected SguiDashboard studentdashboard;
    protected SguiEditProfile editprofile;
    protected SguiChangePassword changepassword;
    
    public void setSguiEditProfile(SguiEditProfile a){
        editprofile = a;
    }
    
    public void setSguiChangePassword(SguiChangePassword a){
        changepassword = a;
    }
    
    public void setCurrentUser(Student x){
        current = x;
        lblID.setText(current.getUserid());
        lblName.setText(current.getName());
        lblEmail.setText(current.getEmail());
        lblPhonenum.setText(current.getPhonenum());
        lblDegree.setText(current.getDegree());
        imgProfile.setImage(new ImageIcon("image/"+current.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
    }
    
    public SguiMyProfile(SguiDashboard a){
        studentdashboard = a;
        studentdashboard.setSguiMyProfile(this);
        
        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(850, 500));
        
        lbl1 = new JLabel("My Profile");
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 26));
        lbl1.setBounds(30,30,400,60);
        
        imgProfile = new ImageIcon();
        lblProfile = new JLabel(imgProfile);
        lblProfile.setBounds(50,150,150,150);
        
        lbl2 = new JLabel("User ID :");
        lbl2.setBounds(250,150,100,30);
        lbl3 = new JLabel("Name :");
        lbl3.setBounds(250,190,100,30);
        lbl4 = new JLabel("Email :");
        lbl4.setBounds(250,230,100,30);
        lbl5 = new JLabel("Phone Number :");
        lbl5.setBounds(250,270,120,30);
        lbl6 = new JLabel("Degree :");
        lbl6.setBounds(250,310,100,30);
        
        lblID = new JLabel();
        lblID.setBounds(370,150,150,30);
        
        lblName = new JLabel();
        lblName.setBounds(370,190,150,30);
        
        lblEmail = new JLabel();
        lblEmail.setBounds(370,230,150,30);
        
        lblPhonenum = new JLabel();
        lblPhonenum.setBounds(370,270,150,30);
        
        lblDegree = new JLabel();
        lblDegree.setBounds(370,310,150,30);
        
        btnEditProfile = new JButton("Edit Profile");
        btnEditProfile.setBounds(650, 150, 150, 80);
        btnEditProfile.addActionListener(this);
        
        btnChgPwd = new JButton("Change Password");
        btnChgPwd.setBounds(650,270,150,80);
        btnChgPwd.addActionListener(this);
        
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(lbl6);
        add(lblProfile);
        add(lblID);
        add(lblName);
        add(lblEmail);
        add(lblPhonenum);
        add(lblDegree);
        add(btnEditProfile);
        add(btnChgPwd);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnEditProfile){
            this.setVisible(false);
            studentdashboard.getStudentDashboard().add(editprofile, BorderLayout.CENTER);
            editprofile.setCurrent(current);
            editprofile.setVisible(true);
        }else if(e.getSource()==btnChgPwd){
            this.setVisible(false);
            studentdashboard.getStudentDashboard().add(changepassword, BorderLayout.CENTER);
            changepassword.setCurrent(current);
            changepassword.setVisible(true);
        }
    }
}
