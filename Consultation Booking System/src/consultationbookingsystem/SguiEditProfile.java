package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class SguiEditProfile extends JPanel implements ActionListener{
    private Student current;
    private JLabel lbl1;
    private JLabel lbl2,lbl3,lbl4,lbl5;
    private JTextField txtName, txtEmail,txtPhonenum;
    private JComboBox cboDegree;
    private JButton btnUpdate, btnBack;
    private SguiMyProfile myprofile;
    
    public void setCurrent(Student a){
        current = a;
        txtName.setText(current.getName());
        txtEmail.setText(current.getEmail());
        txtPhonenum.setText(current.getPhonenum());
        if(current.getDegree().equals("Level 1")){
            cboDegree.setSelectedIndex(0);
        }else if(current.getDegree().equals("Level 2")){
            cboDegree.setSelectedIndex(1);
        }else if(current.getDegree().equals("Level 3")){
            cboDegree.setSelectedIndex(2);
        }
    }

    public SguiEditProfile(SguiMyProfile a) {
        myprofile = a;
        myprofile.setSguiEditProfile(this);
        
        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(850, 500));
        
        lbl1 = new JLabel("Edit Profile");
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 26));
        lbl1.setBounds(30,30,400,60);
        
        lbl2 = new JLabel("Name :");
        lbl2.setBounds(250,150,100,30);
        lbl3 = new JLabel("Email :");
        lbl3.setBounds(250,190,100,30);
        lbl4 = new JLabel("Phone Number :");
        lbl4.setBounds(250,230,100,30);
        lbl5 = new JLabel("Degree :");
        lbl5.setBounds(250,270,100,30);
        
        txtName = new JTextField();
        txtName.setBounds(370,150,150,30);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(370,190,150,30);
        
        txtPhonenum = new JTextField();
        txtPhonenum.setBounds(370,230,150,30);
        
        String D[] = {"Level 1", "Level 2", "Level 3"};
        cboDegree = new JComboBox(D);
        cboDegree.setBounds(370,270,150,30);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBounds(370,350,150,60);
        btnUpdate.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(40,360,100,50);
        btnBack.addActionListener(this);
        
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(lbl5);
        add(txtName);
        add(txtEmail);
        add(txtPhonenum);
        add(cboDegree);
        add(btnUpdate);
        add(btnBack);
        
        
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnUpdate){
            String name = txtName.getText().trim();
            String email = txtEmail.getText();
            String phonenum = txtPhonenum.getText();
            String degree = cboDegree.getSelectedItem().toString();
            
            Pattern pname = Pattern.compile("^[A-Za-z@/' ]{2,30}");
            Matcher mname = pname.matcher(name);
            boolean matchesname = mname.matches();
            
            if (matchesname==false)
            {
                JOptionPane.showMessageDialog(null,"Name can only contain letters and ('), (/), (@) symbols. \nName must be between 2 to 30 characters.");
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
            current.editProfile(name, email, phonenum, degree);
            JOptionPane.showMessageDialog(null,"Sucessfully Updated Profile.");
            
            myprofile.studentdashboard.setName(current.getName());
            myprofile.setCurrentUser(current);
            this.setVisible(false);
            myprofile.studentdashboard.getStudentDashboard().add(myprofile, BorderLayout.CENTER);
            myprofile.setVisible(true);
            
        }else if(e.getSource()==btnBack){
            this.setVisible(false);
            myprofile.studentdashboard.getStudentDashboard().add(myprofile, BorderLayout.CENTER);
            myprofile.setVisible(true);
        }
        
    }
}
