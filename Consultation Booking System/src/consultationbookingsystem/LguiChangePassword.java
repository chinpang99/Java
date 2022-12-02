
package consultationbookingsystem;

import javax.swing.JOptionPane;


public class LguiChangePassword extends javax.swing.JFrame {
    
    private Lecturer current;
    
    private LguiManageProfile manageprofile;
    
    boolean window = false;
    
    public void setBoolean(Boolean y){
        window = y;
    }

    public LguiChangePassword() {
        initComponents();
                
        JOptionPane.showMessageDialog(this, "You Cannot Open Like This","You Cannot Open Like This!", JOptionPane.ERROR_MESSAGE);
        window = false;
    }
    
    
    public void setUser(Lecturer x){ //*IMPORTANT*
        current = x;
    } 
    
    
    public LguiChangePassword(LguiManageProfile c) {
        initComponents();
        
        window = false;
        manageprofile = c;
        manageprofile.setLecChangePassword(this);
        this.setUndecorated(true);
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jLabel1 = new javax.swing.JLabel();
        txtOldPass = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        txtNewPass = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        txtConfirmPass = new javax.swing.JPasswordField();
        chkViewPass = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        Update = new javax.swing.JLabel();
        Cancel = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Old Password:");

        jLabel2.setText("New Password:");

        jLabel3.setText("Confirm Password:");

        chkViewPass.setText("View Password");
        chkViewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkViewPassActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/password.png"))); // NOI18N
        jLabel4.setText("EDIT PASSWORD");

        Update.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/refresh.png"))); // NOI18N
        Update.setText("UPDATE");
        Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateMouseClicked(evt);
            }
        });

        Cancel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        Cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/Cancel.png"))); // NOI18N
        Cancel.setText("CANCEL");
        Cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(chkViewPass)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtConfirmPass)
                                    .addComponent(txtNewPass)
                                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Update)
                            .addGap(25, 25, 25)
                            .addComponent(Cancel))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtOldPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtConfirmPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chkViewPass)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Update)
                    .addComponent(Cancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(481, 402));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(window == false){
            this.dispose();
        }else{
        }

    }//GEN-LAST:event_formWindowOpened

    private void chkViewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkViewPassActionPerformed
        // TODO add your handling code here:
        
        if(chkViewPass.isSelected()){
            txtOldPass.setEchoChar((char)0);
            txtNewPass.setEchoChar((char)0);
            txtConfirmPass.setEchoChar((char)0);
        }else{
                        
            txtOldPass.setEchoChar('●');
            txtNewPass.setEchoChar('●');
            txtConfirmPass.setEchoChar('●');
        }
    }//GEN-LAST:event_chkViewPassActionPerformed

    private void UpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateMouseClicked
        // TODO add your handling code here:

        
        String oldPassword = txtOldPass.getText();
        String newPassword = txtNewPass.getText();
        String ConfirmPassword = txtConfirmPass.getText();
        
        if(!oldPassword.equals(current.getPassword())){
            JOptionPane.showMessageDialog(txtNewPass,"Password Incorrect");
            txtOldPass.setText(null);
            txtNewPass.setText(null);
            txtConfirmPass.setText(null);
            txtOldPass.requestFocus();
        }
        else if(!newPassword.equals(ConfirmPassword)){
            JOptionPane.showMessageDialog(txtNewPass,"Password Not Match");
            txtNewPass.setText(null);
            txtConfirmPass.setText(null);
            txtNewPass.requestFocus();
        }else if(oldPassword.equals(newPassword)){
                        
            JOptionPane.showMessageDialog(txtNewPass,"New Password cannot same as Old Password");
            txtNewPass.setText(null);
            txtConfirmPass.setText(null);
            txtNewPass.requestFocus();
        }else if(oldPassword.trim().isEmpty() || newPassword.trim().isEmpty() || ConfirmPassword.trim().isEmpty()){
            JOptionPane.showMessageDialog(txtNewPass,"Please Fill all the Password Field");
        }
        else{
            String userid = current.getUserid();
            String password = txtConfirmPass.getText();
            String name = current.getName();
            String email = current.getEmail();
            String image = current.getImage();
            String phonenum = current.getPhonenum();
            String school = current.getSchool();
            
            current.editProfile(userid, password, name, email, image, phonenum, school);
            
            manageprofile.setUser(current);
            manageprofile.setVisible(true);

            txtOldPass.setText(null);
            txtNewPass.setText(null);
            txtConfirmPass.setText(null);
            txtOldPass.requestFocus();
            chkViewPass.setSelected(false);

                
            txtOldPass.setEchoChar('●');
                
            txtNewPass.setEchoChar('●');
                
            txtConfirmPass.setEchoChar('●');
            
            
            this.setVisible(false);
            JOptionPane.showMessageDialog(null,"Successfully Update Password");
        }
    }//GEN-LAST:event_UpdateMouseClicked

    private void CancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelMouseClicked
        // TODO add your handling code here:
                
        manageprofile.setUser(current);
        manageprofile.setVisible(true);
                    
        txtOldPass.setText(null);
        txtNewPass.setText(null);
        txtConfirmPass.setText(null);
        txtOldPass.requestFocus();
        chkViewPass.setSelected(false);
                                
            txtOldPass.setEchoChar('●');
            txtNewPass.setEchoChar('●');
            txtConfirmPass.setEchoChar('●');
        this.setVisible(false);
    }//GEN-LAST:event_CancelMouseClicked

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
            java.util.logging.Logger.getLogger(LguiChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LguiChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LguiChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LguiChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new LguiChangePassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cancel;
    private javax.swing.JLabel Update;
    private javax.swing.JCheckBox chkViewPass;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtConfirmPass;
    private javax.swing.JPasswordField txtNewPass;
    private javax.swing.JPasswordField txtOldPass;
    // End of variables declaration//GEN-END:variables
}
