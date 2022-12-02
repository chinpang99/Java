
package consultationbookingsystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class LguiDashboard extends javax.swing.JFrame {
    
    private Lecturer current;
    private LguiManageProfile manageprofile;
    private LguiCalendar calendar;
    private LguiCreateConsultation create_consultation;
    private LguiMyConsultationVenue my_consultation_venue;
    private guiLogin login;
    private ArrayList<Student> std;
    private ArrayList<Lecturer> lec;
    private ArrayList<Consultation> cons;
       
    
    public void setLecManageProfile(LguiManageProfile x){ //*IMPORTANT*
        manageprofile = x;
    }
        
    public void setLecCalendar(LguiCalendar c){ //*IMPORTANT*
        calendar = c;
    }
    
    public void setLecCreateConsultation(LguiCreateConsultation a){ //*IMPORTANT*
        create_consultation = a;
    }
        
    public void setLecViewConsultationVenue(LguiMyConsultationVenue b){ //*IMPORTANT*
        my_consultation_venue = b;
    }
        
    public void setBoolean(Boolean y){
        window = y;
    }
  
    public void setUser(Lecturer x){ //*IMPORTANT*
        current = x;
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
    
    boolean window = false;
    
    public LguiDashboard() {
        initComponents();
        JOptionPane.showMessageDialog(this, "You Cannot Open Like This","You Cannot Open Like This!", JOptionPane.ERROR_MESSAGE);
        window = false;
    }
    
    public LguiDashboard(guiLogin a) {
        initComponents();
        
        
        login = a;
        login.setLguiDashboard(this);
        this.setUndecorated(true);
        
        std = login.getStd();
        lec = login.getLec();
        cons = login.getCons();
        
        window = false;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblText = new javax.swing.JLabel();
        MP_3 = new javax.swing.JPanel();
        MP_1 = new javax.swing.JLabel();
        MP_2 = new javax.swing.JLabel();
        CS_3 = new javax.swing.JPanel();
        CS_2 = new javax.swing.JLabel();
        CS_1 = new javax.swing.JLabel();
        MCV_2 = new javax.swing.JPanel();
        MCV_3 = new javax.swing.JLabel();
        MCV_1 = new javax.swing.JLabel();
        CBM_3 = new javax.swing.JPanel();
        CBM_2 = new javax.swing.JLabel();
        CBM_1 = new javax.swing.JLabel();
        LogOut_2 = new javax.swing.JPanel();
        LogOut_1 = new javax.swing.JLabel();
        LogOut_3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        lblText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblText.setText("jLabel1");

        MP_3.setBackground(new java.awt.Color(255, 204, 204));
        MP_3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MP_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MP_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MP_3MouseClicked(evt);
            }
        });

        MP_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/profile.png"))); // NOI18N
        MP_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MP_1MouseClicked(evt);
            }
        });

        MP_2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        MP_2.setText("MANAGE PROFILE");
        MP_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MP_2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MP_3Layout = new javax.swing.GroupLayout(MP_3);
        MP_3.setLayout(MP_3Layout);
        MP_3Layout.setHorizontalGroup(
            MP_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MP_3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(MP_1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(MP_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MP_3Layout.setVerticalGroup(
            MP_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MP_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MP_1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MP_3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(MP_2)
                .addGap(61, 61, 61))
        );

        CS_3.setBackground(new java.awt.Color(255, 204, 204));
        CS_3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CS_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CS_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CS_3MouseClicked(evt);
            }
        });

        CS_2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/Consultation.png"))); // NOI18N
        CS_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CS_2MouseClicked(evt);
            }
        });

        CS_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CS_1.setText("CREATE CONSULTATION");
        CS_1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CS_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CS_1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CS_3Layout = new javax.swing.GroupLayout(CS_3);
        CS_3.setLayout(CS_3Layout);
        CS_3Layout.setHorizontalGroup(
            CS_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CS_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CS_2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(CS_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CS_3Layout.setVerticalGroup(
            CS_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CS_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CS_2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CS_3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CS_1)
                .addGap(58, 58, 58))
        );

        MCV_2.setBackground(new java.awt.Color(255, 204, 204));
        MCV_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        MCV_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MCV_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MCV_2MouseClicked(evt);
            }
        });

        MCV_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/location.png"))); // NOI18N
        MCV_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MCV_3MouseClicked(evt);
            }
        });

        MCV_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        MCV_1.setText("MY CONSULTATION VENUE");
        MCV_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MCV_1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MCV_2Layout = new javax.swing.GroupLayout(MCV_2);
        MCV_2.setLayout(MCV_2Layout);
        MCV_2Layout.setHorizontalGroup(
            MCV_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MCV_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(MCV_3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MCV_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MCV_2Layout.setVerticalGroup(
            MCV_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MCV_3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
            .addGroup(MCV_2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(MCV_1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CBM_3.setBackground(new java.awt.Color(255, 204, 204));
        CBM_3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        CBM_3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CBM_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBM_3MouseClicked(evt);
            }
        });

        CBM_2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        CBM_2.setText("CONSULTATION / APPOINTMENT");
        CBM_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBM_2MouseClicked(evt);
            }
        });

        CBM_1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/schedule.png"))); // NOI18N
        CBM_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CBM_1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout CBM_3Layout = new javax.swing.GroupLayout(CBM_3);
        CBM_3.setLayout(CBM_3Layout);
        CBM_3Layout.setHorizontalGroup(
            CBM_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CBM_3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CBM_1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CBM_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CBM_3Layout.setVerticalGroup(
            CBM_3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CBM_1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
            .addGroup(CBM_3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(CBM_2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        LogOut_2.setBackground(new java.awt.Color(255, 204, 204));
        LogOut_2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        LogOut_2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogOut_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOut_2MouseClicked(evt);
            }
        });

        LogOut_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        LogOut_1.setText("LOG OUT");
        LogOut_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOut_1MouseClicked(evt);
            }
        });

        LogOut_3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultationbookingsystem/Image/logout.png"))); // NOI18N
        LogOut_3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOut_3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LogOut_2Layout = new javax.swing.GroupLayout(LogOut_2);
        LogOut_2.setLayout(LogOut_2Layout);
        LogOut_2Layout.setHorizontalGroup(
            LogOut_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LogOut_2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LogOut_3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(LogOut_1)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        LogOut_2Layout.setVerticalGroup(
            LogOut_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogOut_3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogOut_2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LogOut_1)
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(MCV_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MP_3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(CS_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBM_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(447, 447, 447)
                        .addComponent(LogOut_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(484, 484, 484))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblText, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MP_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CS_3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CBM_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MCV_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41)
                .addComponent(LogOut_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(114, 114, 114))
        );

        setSize(new java.awt.Dimension(1520, 772));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void MP_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MP_3MouseClicked
        // TODO add your handling code here:
        ManageProfile();
    }//GEN-LAST:event_MP_3MouseClicked

    private void MP_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MP_1MouseClicked
        // TODO add your handling code here:
        ManageProfile();
    }//GEN-LAST:event_MP_1MouseClicked

    private void MP_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MP_2MouseClicked
        // TODO add your handling code here:
        
        ManageProfile();
    }//GEN-LAST:event_MP_2MouseClicked

    private void CS_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CS_2MouseClicked
        // TODO add your handling code here:
        CreateConsultation();
    }//GEN-LAST:event_CS_2MouseClicked

    private void CS_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CS_1MouseClicked
        // TODO add your handling code here:
        CreateConsultation();
    }//GEN-LAST:event_CS_1MouseClicked

    private void CS_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CS_3MouseClicked
        // TODO add your handling code here:
        CreateConsultation();
    }//GEN-LAST:event_CS_3MouseClicked

    private void MCV_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MCV_3MouseClicked
        // TODO add your handling code here:
        MyConsultationVenue();
    }//GEN-LAST:event_MCV_3MouseClicked

    private void MCV_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MCV_1MouseClicked
        // TODO add your handling code here:
        MyConsultationVenue();
    }//GEN-LAST:event_MCV_1MouseClicked

    private void MCV_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MCV_2MouseClicked
        // TODO add your handling code here:
        MyConsultationVenue();
    }//GEN-LAST:event_MCV_2MouseClicked

    private void CBM_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBM_2MouseClicked
        // TODO add your handling code here:
        ConsultationBookedAppointment();
    }//GEN-LAST:event_CBM_2MouseClicked

    private void CBM_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBM_1MouseClicked
        // TODO add your handling code here:
        ConsultationBookedAppointment();
    }//GEN-LAST:event_CBM_1MouseClicked

    private void CBM_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CBM_3MouseClicked
        // TODO add your handling code here:
        ConsultationBookedAppointment();
    }//GEN-LAST:event_CBM_3MouseClicked

    private void LogOut_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOut_1MouseClicked
        // TODO add your handling code here:
        LogOut();
    }//GEN-LAST:event_LogOut_1MouseClicked

    private void LogOut_3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOut_3MouseClicked
        // TODO add your handling code here:
        LogOut();
    }//GEN-LAST:event_LogOut_3MouseClicked

    private void LogOut_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOut_2MouseClicked
        // TODO add your handling code here:
        LogOut();
    }//GEN-LAST:event_LogOut_2MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
                        
        if(window == false){
            this.dispose();
        }else{
            SimpleDateFormat dateFormatter = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");
            dateFormatter = new SimpleDateFormat("a");
            Date a = new Date(); 
            String ab = dateFormatter.format(a);
            if(ab.equalsIgnoreCase("AM")){
                lblText.setText("Good Morning " + current.getName());
            }else{
                lblText.setText("Good Evening " + current.getName());
            }
        }
    }//GEN-LAST:event_formWindowActivated

    public void ManageProfile(){
        manageprofile.setUser(current);
        manageprofile.setVisible(true);
        manageprofile.setBoolean(true); 
        manageprofile.txtName.setText(current.getName());
        manageprofile.txtID.setText(current.getUserid());
        manageprofile.txtEmail.setText(current.getEmail());
        manageprofile.cboSOD.setSelectedItem(current.getSchool());
        manageprofile.txtPhoneNumber.setText(current.getPhonenum());
        manageprofile.lblPicture.setIcon(new ImageIcon("Lecturer Image/" + current.getImage()));
        this.setVisible(false);
    }
    
    public void CreateConsultation(){
                
        create_consultation.setUser(current);
        create_consultation.setBoolean(true);
        create_consultation.setVisible(true);
        this.setVisible(false);
    }
    
    public void MyConsultationVenue(){
                
        my_consultation_venue.setUser(current);
        my_consultation_venue.setBoolean(true);
        my_consultation_venue.setVisible(true);
        this.setVisible(false);
    }
    
    public void ConsultationBookedAppointment(){
                
        calendar.setUser(current);
        calendar.setBoolean(true);
        calendar.setVisible(true);
        calendar.setBoolean(true);
        this.setVisible(false);
    }
    
    public void LogOut(){
                
        login.getLoginPage().setVisible(true);
        this.setVisible(false); 
    }
    
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
            java.util.logging.Logger.getLogger(LguiDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LguiDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LguiDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LguiDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new LguiDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CBM_1;
    private javax.swing.JLabel CBM_2;
    private javax.swing.JPanel CBM_3;
    private javax.swing.JLabel CS_1;
    private javax.swing.JLabel CS_2;
    private javax.swing.JPanel CS_3;
    private javax.swing.JLabel LogOut_1;
    private javax.swing.JPanel LogOut_2;
    private javax.swing.JLabel LogOut_3;
    private javax.swing.JLabel MCV_1;
    private javax.swing.JPanel MCV_2;
    private javax.swing.JLabel MCV_3;
    private javax.swing.JLabel MP_1;
    private javax.swing.JLabel MP_2;
    private javax.swing.JPanel MP_3;
    public javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
