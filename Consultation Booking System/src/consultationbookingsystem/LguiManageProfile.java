package consultationbookingsystem;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


public class LguiManageProfile extends javax.swing.JFrame {

        
    private Lecturer current;
    private LguiDashboard mainpage;
    private LguiChangePassword changepassword;
    boolean window = false;
    
    public void setLecChangePassword(LguiChangePassword x){ //*IMPORTANT*
        changepassword = x;
    }
       
    public void setBoolean(Boolean y){
        window = y;
    }
    
    
    public LguiManageProfile() {
        initComponents();
        
        JOptionPane.showMessageDialog(this, "You Cannot Open Like This","You Cannot Open Like This!", JOptionPane.ERROR_MESSAGE);
        window = false;
    }
    
    public void setUser(Lecturer x){ //*IMPORTANT*
        current = x;
    }    
    public LguiManageProfile(LguiDashboard b) {
        initComponents();

        window = false;
        mainpage = b;
        mainpage.setLecManageProfile(this);
        this.setUndecorated(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        lblEmail1 = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblSchoolOf = new javax.swing.JLabel();
        cboSOD = new javax.swing.JComboBox<>();
        lblPicture = new javax.swing.JLabel();
        txtPhoneNumber = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        HomePage = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblID.setText("Lecturer ID: ");

        txtID.setEditable(false);
        txtID.setText("jTextField1");

        lblEmail1.setText("Phone Number:");

        lblFullName.setText("Full Name: ");

        txtName.setText("jTextField1");

        lblEmail.setText("Email: ");

        txtEmail.setText("jTextField1");

        lblSchoolOf.setText("School Of: ");

        cboSOD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "School of Computing", "School of Foundation", "School of Engineering", "School of Management", "School of Media Arts and Design" }));

        txtPhoneNumber.setText("jTextField1");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/refresh.png"))); // NOI18N
        jLabel1.setText("UPDATE");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/padlock.png"))); // NOI18N
        jLabel2.setText("EDIT PASSWORD");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        HomePage.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        HomePage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/house.png"))); // NOI18N
        HomePage.setText("HOME PAGE");
        HomePage.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HomePage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomePageMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/profile.png"))); // NOI18N
        jLabel4.setText("MANAGE PROFILE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 599, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(HomePage, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblID)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblSchoolOf)
                                        .addGap(24, 24, 24)
                                        .addComponent(cboSOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEmail1)
                                .addGap(24, 24, 24)
                                .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblEmail)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblFullName)
                                        .addGap(24, 24, 24)
                                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(191, 191, 191))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(208, 208, 208))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(HomePage)
                    .addComponent(jLabel4))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblID)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFullName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEmail1)
                            .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSchoolOf)
                            .addComponent(cboSOD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(22, 22, 22))
        );

        setSize(new java.awt.Dimension(902, 618));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(window == false){
            this.dispose();
        }else{
        }
    }//GEN-LAST:event_formWindowOpened

    private void HomePageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomePageMouseClicked
        // TODO add your handling code here:
               
        mainpage.setUser(current);
        mainpage.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_HomePageMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
                
        String ID = txtID.getText();
        String newName = txtName.getText();
        String newEmail = txtEmail.getText();
        String newPhoneNum = txtPhoneNumber.getText();
        String newSOD = cboSOD.getSelectedItem().toString();
        String password = current.getPassword();
        
        Pattern lec_name = Pattern.compile("^[A-Za-z@/' ]{2,30}");
        Matcher mat_lec_name = lec_name.matcher(newName);
        boolean matchesname = mat_lec_name.matches();
        
        if(matchesname == false)
        {
            JOptionPane.showMessageDialog(null,"Name can only contain letters and ('), (/), (@) symbols. \nName must be between 2 to 30 characters.");
            txtName.setText(current.getName());
            return;
        }
        
                    
        Pattern lec_email = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
        Matcher memail = lec_email.matcher(newEmail);  
        boolean matchesemail = memail.matches();
        
                    
        if (matchesemail==false)
        {
            JOptionPane.showMessageDialog(null,"Please enter a valid email.");
            txtEmail.setText(current.getEmail());
            return;
        }
        
                    
        Pattern lec_phone = Pattern.compile("^[0-9]{10,11}");
        Matcher m = lec_phone.matcher(newPhoneNum);
        boolean matches = m.matches();

        if (matches==false)
        {
            JOptionPane.showMessageDialog(null,"Phone number can only be 10 to 11 characters. \nPhone number can only contain integers.");
            txtPhoneNumber.setText(current.getPhonenum());
            return;
        }
        boolean validation = false;
        for(int i = 0; i<mainpage.getLec().size(); i++){
            Lecturer x = mainpage.getLec().get(i);
            
            if(current.getUserid().equals(x.getUserid())){
                validation = true;
            }else{
                if(newName.equals(x.getName())){
                    JOptionPane.showMessageDialog(this, "The Name is used!","The Name is Used!", JOptionPane.INFORMATION_MESSAGE);
                    txtName.setText(current.getName());
                    validation = false;
                    break;
                }else if(newEmail.equals(x.getEmail())){           
                    JOptionPane.showMessageDialog(this, "The Email is used!","The Email is Used!", JOptionPane.INFORMATION_MESSAGE);
                    txtEmail.setText(current.getEmail());
                    validation = false;
                    break;
                }else if(newPhoneNum.equals(x.getPhonenum())){      
                    JOptionPane.showMessageDialog(this, "The Phone Number is used!","The Phone Number is Used!", JOptionPane.INFORMATION_MESSAGE);
                    txtPhoneNumber.setText(current.getPhonenum());
                    validation = false;
                    break;
                }else if(newName.equals(x.getName()) && newEmail.equals(x.getEmail()) && newPhoneNum.equals(x.getPhonenum())){         
                    JOptionPane.showMessageDialog(this, "The Name, Email, Phone Number is used!","The Name, Email, Phone Number!", JOptionPane.INFORMATION_MESSAGE);
                    validation = false;
                    break;
                }
            }
        }
        
        if(validation == true){
            if(!ID.trim().isEmpty() && !newName.trim().isEmpty() && !newEmail.trim().isEmpty() && !newPhoneNum.trim().isEmpty()){
                
                current.editProfile(ID, password, newName, newEmail, current.getImage(), newPhoneNum, newSOD);

                JOptionPane.showMessageDialog(this, "Edit Successfully!","Edit Successfully!", JOptionPane.INFORMATION_MESSAGE);

            }else if(newName.trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Name is Empty","Please Fill your Full Name!", JOptionPane.ERROR_MESSAGE);
            }else if(newEmail.trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Email is Empty","Please Fill your Email!", JOptionPane.ERROR_MESSAGE);
            }else if(newPhoneNum.trim().isEmpty()){
                JOptionPane.showMessageDialog(this, "Phone Number is Empty","Please Fill your Phone Number!", JOptionPane.ERROR_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(this, "Empty Information Field","Please Complete your Information!", JOptionPane.ERROR_MESSAGE);
            } 
        }


    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
                
        changepassword.setUser(current);
        changepassword.setBoolean(true); 
        changepassword.setBoolean(true);
        changepassword.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LguiManageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LguiManageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LguiManageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LguiManageProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LguiManageProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HomePage;
    public javax.swing.JComboBox<String> cboSOD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmail1;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblID;
    public javax.swing.JLabel lblPicture;
    private javax.swing.JLabel lblSchoolOf;
    public javax.swing.JTextField txtEmail;
    public javax.swing.JTextField txtID;
    public javax.swing.JTextField txtName;
    public javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
