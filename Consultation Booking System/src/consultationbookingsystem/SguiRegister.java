package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class SguiRegister implements ActionListener{
    private JFrame x;
    private JLabel lblTitle,lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7;
    private JTextField txtUserid, txtName, txtEmail,txtPhonenum;
    private JPasswordField txtPass, txtConPass;
    private JComboBox cboDegree;
    private JButton btnRegister, btnCancel;
    private ArrayList<Student> std;
    private guiLogin loginpage;
    int pX,pY;
    
    public JFrame getRegisterPage(){
        return x;
    }
    
    public void setUserID(){
        int size = std.size();
        if(size!=0){
            Student a = std.get(size-1);
            String newid = a.getUserid().substring(1);
            int num1 = Integer.parseInt(newid);
            num1+=1;
            newid = Integer.toString(num1);
            if(newid.length()==2){
                newid = "0" + newid;
            }else if(newid.length()==1){
                newid = "00"+newid;
            }
            newid = "S"+newid;
            txtUserid.setText(newid);
        }else{
            txtUserid.setText("S001");
        }
        txtName.setText("");
        txtPass.setText("");
        txtConPass.setText("");
        txtEmail.setText("");
        txtPhonenum.setText("");
    }

    public SguiRegister(guiLogin a) {
        loginpage = a;
        loginpage.setSguiRegister(this);
        
        std = loginpage.getStd();
        
        x = new JFrame("Register");
        x.setSize(450, 600);
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
        
        lblTitle = new JLabel("Register as Student");
        lblTitle.setFont(new Font("Calibri", Font.PLAIN, 26));
        lblTitle.setBounds(30,30,400,60);
        
        lbl1 = new JLabel("User ID :");
        lbl1.setBounds(50,150,100,30);
        lbl2 = new JLabel("Name :");
        lbl2.setBounds(50,190,100,30);
        lbl3 = new JLabel("Password :");
        lbl3.setBounds(50,230,100,30);
        lbl4 = new JLabel("Confirm Password :");
        lbl4.setBounds(50,270,130,30);
        lbl5 = new JLabel("Email :");
        lbl5.setBounds(50,310,100,30);
        lbl6 = new JLabel("Phone Number :");
        lbl6.setBounds(50,350,100,30);
        lbl7 = new JLabel("Degree :");
        lbl7.setBounds(50,390,100,30);
        
        txtUserid = new JTextField();
        txtUserid.setEditable(false);
        txtUserid.setBounds(180,150,150,30);
        txtName = new JTextField();
        txtName.setBounds(180,190,150,30);
        txtPass = new JPasswordField();
        txtPass.setBounds(180,230,150,30);
        txtConPass = new JPasswordField();
        txtConPass.setBounds(180,270,150,30);
        txtEmail = new JTextField();
        txtEmail.setBounds(180,310,150,30);
        txtPhonenum = new JTextField();
        txtPhonenum.setBounds(180,350,150,30);
        String D[] = {"Level 1", "Level 2", "Level 3"};
        cboDegree = new JComboBox(D);
        cboDegree.setBounds(180,390,150,30);

        btnRegister = new JButton("Register");
        btnRegister.setBounds(170,480,150,60);
        btnRegister.addActionListener(this);
        
        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(40,485,100,50);
        btnCancel.addActionListener(this);
        
        x.add(lblTitle);
        x.add(lbl1);
        x.add(lbl2);
        x.add(lbl3);
        x.add(lbl4);
        x.add(lbl5);
        x.add(lbl6);
        x.add(lbl7);
        x.add(txtUserid);
        x.add(txtName);
        x.add(txtPass);
        x.add(txtConPass);
        x.add(txtEmail);
        x.add(txtPhonenum);
        x.add(cboDegree);
        x.add(btnRegister);
        x.add(btnCancel);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnRegister){
            String userid = txtUserid.getText();
            String name = txtName.getText().trim();
            String pass = txtPass.getText();
            String conpass = txtConPass.getText();
            String email = txtEmail.getText();
            String phonenum = txtPhonenum.getText();
            String degree = cboDegree.getSelectedItem().toString();
            
            Pattern pname = Pattern.compile("^[A-Za-z@/' ]{2,30}");
            Matcher mname = pname.matcher(name);
            boolean matchesname = mname.matches();
            
            for(int i=0;i<std.size();i++){
                Student ss = std.get(i);
                if(ss.getUserid().equals(userid)){
                    JOptionPane.showMessageDialog(null,"Invalid User ID.");
                    return;
                }
            }
            
            if (matchesname==false)
            {
                JOptionPane.showMessageDialog(null,"Name can only contain letters and ('), (/), (@) symbols. \nName must be between 2 to 30 characters.");
                return;
            }
            
            if(pass.equals("") || conpass.equals(""))
            {
               JOptionPane.showMessageDialog(null,"Password cannot be empty.");
               return;
            }
            
            if(pass.contains(" "))
            {
                JOptionPane.showMessageDialog(null,"Password cannot contain spaces.");
                return;
            }
            
            if(pass.length()<5 || pass.length()>20)
            {
                JOptionPane.showMessageDialog(null,"Password must be between 5 to 20 characters.");
                return;
            }
            
            if(!pass.equals(conpass))
            {
                JOptionPane.showMessageDialog(null,"Passwords do no match.");
            return;
            }
            
            Pattern pemail = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
            Matcher memail = pemail.matcher(email);
            boolean matchesemail = memail.matches();
            
            if (matchesemail==false)
            {
                JOptionPane.showMessageDialog(null,"Please enter a valid email.");
                return;
            }
            
            Pattern p = Pattern.compile("^[0-9]{10,11}");
            Matcher m = p.matcher(phonenum);
            boolean matches = m.matches();
        
            if (matches==false)
            {
                JOptionPane.showMessageDialog(null,"Phone number can only be 10 to 11 characters. \nPhone number can only contain integers.");
                return;
            }
            
            Student newstu = new Student(userid,name,pass,email,"pic1.jpg",phonenum,degree);
            std.add(newstu);
            JOptionPane.showMessageDialog(null,"Successfully Registered.");
            x.setVisible(false);
            loginpage.getLoginPage().setVisible(true);
            
        }else if(e.getSource()==btnCancel){
            x.setVisible(false);
            loginpage.getLoginPage().setVisible(true);
        }
    }
}
