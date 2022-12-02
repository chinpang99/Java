package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class SguiChangePassword extends JPanel implements ActionListener{
    private Student current;
    private JLabel lbl1;
    private JLabel lbl2,lbl3,lbl4;
    private JPasswordField txtCurrPass, txtNewPass,txtConNewPass;
    private JButton btnChange, btnBack;
    private SguiMyProfile myprofile;

    public void setCurrent(Student a){
        current = a;
        txtCurrPass.setText("");
        txtNewPass.setText("");
        txtConNewPass.setText("");
    }
    
    public SguiChangePassword(SguiMyProfile a) {
        myprofile = a;
        myprofile.setSguiChangePassword(this);
        
        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(850, 500));
        
        lbl1 = new JLabel("Change Password");
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 26));
        lbl1.setBounds(30,30,400,60);
        
        lbl2 = new JLabel("Current Password :");
        lbl2.setBounds(250,150,130,30);
        lbl3 = new JLabel("New Password :");
        lbl3.setBounds(250,190,130,30);
        lbl4 = new JLabel("Confirm New Password :");
        lbl4.setBounds(250,230,150,30);
        
        txtCurrPass = new JPasswordField();
        txtCurrPass.setBounds(400,150,150,30);
        
        txtNewPass = new JPasswordField();
        txtNewPass.setBounds(400,190,150,30);
        
        txtConNewPass = new JPasswordField();
        txtConNewPass.setBounds(400,230,150,30);
        
        btnChange = new JButton("Change");
        btnChange.setBounds(400,350,150,60);
        btnChange.addActionListener(this);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(40,360,100,50);
        btnBack.addActionListener(this);
        
        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(txtCurrPass);
        add(txtNewPass);
        add(txtConNewPass);
        add(btnChange);
        add(btnBack);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnChange){
            String currpass = txtCurrPass.getText();
            String newpass = txtNewPass.getText();
            String connewpass = txtConNewPass.getText();
            
            if(currpass.equals("") || newpass.equals("") || connewpass.equals(""))
            {
               JOptionPane.showMessageDialog(null,"Please fill in every input field.");
               return;
            }
            
            if(!current.getPassword().equals(currpass)){
               JOptionPane.showMessageDialog(null,"Incorrect current password.");
               return;
            }
            
            if(newpass.contains(" "))
            {
                JOptionPane.showMessageDialog(null,"New Password cannot contain spaces.");
                return;
            }
        
            if(newpass.length()<5 || newpass.length()>20)
            {
                JOptionPane.showMessageDialog(null,"New Password must be between 5 to 20 characters.");
                return;
            }
            
            if(newpass.equals(currpass))
            {
                JOptionPane.showMessageDialog(null,"New Password cannot be the same as current password.");
                return;
            }
        
            if(!newpass.equals(connewpass))
            {
                JOptionPane.showMessageDialog(null,"New Passwords do no match.");
            return;
            }
            
            current.setPassword(newpass);
            JOptionPane.showMessageDialog(null,"Sucessfully Changed Password.");
            
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
