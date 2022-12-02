
package consultationbookingsystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LguiAppointment extends javax.swing.JFrame {

    private LguiCalendar calendar; 
    private LguiEditConsultation edit_consultation;
    private Lecturer current;
    private Consultation consultation;
    private Consultation x;
        
       
    public void setLecEditConsultation(LguiEditConsultation x){ //*IMPORTANT*
        edit_consultation = x;
    }
        
    boolean window = false;
    
    public void setBoolean(Boolean y){
        window = y;
    }

    public void setUser(Lecturer xx, Consultation y){ //*IMPORTANT*
        current = xx;
        consultation = y;
       
        JPanel contentPane = new JPanel();  
        JLabel g = new JLabel();
        g.setIcon(new ImageIcon("Lecturer Image\\previous.png"));
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        contentPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        
                
        g.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
                calendar.setUser(current);
                calendar.setVisible(true);
                setVisible(false);
            }  
        });
        
        for(int i = 0; i<current.getCons().size(); i++){
            x = current.getCons().get(i);
            
            if(consultation.getDay().equals(x.getDay())){
                
                JPanel[] leftPanel = new JPanel[current.getCons().size()];   
                JPanel[] buttonLeftPanel = new JPanel[current.getCons().size()];
                JLabel[] lblvenue = new JLabel[current.getCons().size()];
                JLabel[] lblvenuee = new JLabel[current.getCons().size()];
                JLabel[] lbltime = new JLabel[current.getCons().size()];
                JLabel[] lbltimee = new JLabel[current.getCons().size()];
                JLabel[] lbldate = new JLabel[current.getCons().size()];
                JLabel[] lbldatee = new JLabel[current.getCons().size()];
                JLabel[] lblSname = new JLabel[current.getCons().size()];
                JLabel[] lblSnamee = new JLabel[current.getCons().size()];
                JLabel[] lblSemail = new JLabel[current.getCons().size()];
                JLabel[] lblSemaill = new JLabel[current.getCons().size()];
                JLabel[] lblSphone = new JLabel[current.getCons().size()];
                JLabel[] lblSphonee = new JLabel[current.getCons().size()];
                JLabel[] resetButton = new JLabel[current.getCons().size()];   
                JPanel[] labelPanel = new JPanel[current.getCons().size()];
                JButton[] a = new JButton[current.getCons().size()];
                JButton[] b = new JButton[current.getCons().size()];
                JLabel[] cc = new JLabel[current.getCons().size()];
                JButton[] c = new JButton[current.getCons().size()];
                
                                                
                leftPanel[i] = new JPanel();  
                lblvenue[i] = new JLabel(x.getVenue());
                lblvenuee[i] = new JLabel("   Venue");
                lbltime[i] = new JLabel(x.getTime());
                lbltimee[i] = new JLabel("   Time");
                lbldate[i] = new JLabel(x.getDay());
                lbldatee[i] = new JLabel("   Date");

                leftPanel[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
                leftPanel[i].setLayout(new BoxLayout(leftPanel[i], BoxLayout.Y_AXIS)); 
                labelPanel[i] = new JPanel();
                buttonLeftPanel[i] = new JPanel();
                buttonLeftPanel[i].setLayout(new GridLayout(7,2));
                
                                    
                resetButton[i] = new JLabel();  
                String venue = x.getVenue();
                String time = x.getTime();
                String date = x.getDay(); 
                                
                if(x.getS()==null){
                    resetButton[i].setIcon(new ImageIcon("Lecturer Image\\location-map-flat.png"));
                    buttonLeftPanel[i].setLayout(new GridLayout(4,2));
                    a[i] = new JButton("Edit");
                    b[i] = new JButton("Delete");
                    
                    Date d = new Date();
                    String consultationDate = consultation.getDay();
                                                                    
                    try{        
                                    
                    SimpleDateFormat dateFormatterrr = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");   
                    dateFormatterrr = new SimpleDateFormat("d/M/y");     
                    Date bb = dateFormatterrr.parse(consultationDate);  
                    
                    if(bb.before(d)){
                        
                                    buttonLeftPanel[i].add(lblvenuee[i]);
                                    buttonLeftPanel[i].add(lblvenue[i]);
                                    buttonLeftPanel[i].add(lbltimee[i]);
                                    buttonLeftPanel[i].add(lbltime[i]);
                                    buttonLeftPanel[i].add(lbldatee[i]);
                                    buttonLeftPanel[i].add(lbldate[i]);
                    }else{              
                    a[i] = new JButton("Edit");
                    b[i] = new JButton("Delete");
                    
                    a[i].addActionListener(new ActionListener()
                                {
                                public void actionPerformed (ActionEvent e)
                                {
                                    Consultation z = null;  
                                    for(int i = 0; i<current.getCons().size(); i++){
                                    Consultation a = current.getCons().get(i);
                                    
                                    String venuee = a.getVenue();
                                    String timee = a.getTime();
                                    String datee = a.getDay();
                                    
                                    if(venue.equals(venuee)&&time.equals(timee)&&date.equals(datee))
                                    {
                                        z=a;
                                        edit_consultation.setUser(current, z);
                                        edit_consultation.setBoolean(true);
                                        edit_consultation.setVisible(true);
                                        setVisible(false);
                                        break;
                                    }else{
                                    }
                                }
                                    
                                }
                                
                                
                                }
                                
                                
                                
                                );
                                        
                    b[i].addActionListener(new ActionListener()
                                {
                                public void actionPerformed (ActionEvent e)
                                {
                                    Consultation z = null;
                                for(int i = 0; i<current.getCons().size(); i++){
                                    Consultation x = current.getCons().get(i);
                                    String venuee = x.getVenue();
                                    String datee = x.getDay();
                                    String timee = x.getTime();

                                    if(venue.equals(venuee)&&time.equals(timee)&&date.equals(datee)){
                                        z = x;
                                        JOptionPane.showMessageDialog(null, "Consultation Deleted","Consultation Deleted!", JOptionPane.INFORMATION_MESSAGE);
                                        calendar.setUser(current);
                                        calendar.setVisible(true);  
                                        current.getCons().remove(z);
                                        calendar.mainpage.getCons().remove(z);
                                        setVisible(false);
                                        break;
                                    }
                                }
                                
                                    calendar.consultation.remove(date);
                                    calendar.window = true;
                                }
                                
                                
                                }
                                
                                
                                
                                );
                                                        
                                                        
                    buttonLeftPanel[i].add(lblvenuee[i]);
                    buttonLeftPanel[i].add(lblvenue[i]);
                    buttonLeftPanel[i].add(lbltimee[i]);
                    buttonLeftPanel[i].add(lbltime[i]);
                    buttonLeftPanel[i].add(lbldatee[i]);
                    buttonLeftPanel[i].add(lbldate[i]);
                    buttonLeftPanel[i].add(a[i]);  
                    buttonLeftPanel[i].add(b[i]);
                    }
                
                    }catch(ParseException pe){}
                    
                }else{
                    Date d = new Date();
                    String consultationDate = consultation.getDay();
                                                                    
                    try{        
                                    
                    SimpleDateFormat dateFormatterrr = new SimpleDateFormat("E, y-M-d 'at' h:m:s a z");   
                    dateFormatterrr = new SimpleDateFormat("d/M/y");     
                    Date bb = dateFormatterrr.parse(consultationDate);  
                    
                    if(bb.before(d)){
                                lblSname[i]= new JLabel(x.getS().getName());
                                lblSnamee[i]= new JLabel("   Student Name");
                                lblSemail[i] = new JLabel(x.getS().getEmail()); 
                                lblSemaill[i] = new JLabel("   Email"); 
                                lblSphone[i] = new JLabel(x.getS().getPhonenum());
                                lblSphonee[i] = new JLabel("   Phone");
                                resetButton[i].setIcon(new ImageIcon("image\\" + x.getS().getImage()));
                                buttonLeftPanel[i].add(lblSnamee[i]);
                                buttonLeftPanel[i].add(lblSname[i]);
                                buttonLeftPanel[i].add(lblSemaill[i]);
                                buttonLeftPanel[i].add(lblSemail[i]);
                                buttonLeftPanel[i].add(lblSphonee[i]);
                                buttonLeftPanel[i].add(lblSphone[i]);
                                buttonLeftPanel[i].add(lblvenuee[i]);
                                buttonLeftPanel[i].add(lblvenue[i]);
                                buttonLeftPanel[i].add(lbltimee[i]);
                                buttonLeftPanel[i].add(lbltime[i]);
                                buttonLeftPanel[i].add(lbldatee[i]);
                                buttonLeftPanel[i].add(lbldate[i]);
                    }else{  
                                            
                    cc[i] = new JLabel();
                    c[i] = new JButton("Cancel Booking");
                    String sname = x.getS().getName(); 
                    String semail = x.getS().getEmail();
                    String stuname = x.getS().getName(); 
                    String con_venue = x.getVenue();
                    String con_time = x.getTime();
                    String con_date = x.getDay();
                    String lec_name = current.getName();
                    String lec_email = current.getEmail();
                    
                    
                    
                                c[i].addActionListener(new ActionListener()
                                {
                                    @Override
                                    public void actionPerformed (ActionEvent e) 
                                    {
                                        Consultation zz = null;
                                        for(int i = 0; i<current.getCons().size(); i++){
                                            Consultation xy = current.getCons().get(i);
                                            String venuee = xy.getVenue();
                                            String datee = xy.getDay();
                                            String timee = xy.getTime();
                                            
                                            if(venue.equals(venuee) && time.equals(timee) && date.equals(datee) && sname.equals(xy.getS().getName()))
                                            {    
                                                JOptionPane.showMessageDialog(null, "Cancelling & Sending Email...","Cancelling & Sending Email...", JOptionPane.INFORMATION_MESSAGE);
                                                zz = xy;
                                                xy.getS().getCons().remove(zz);
                                                xy.setStudent(null);
                                                setUser(current, xy);
                                                
                                                try {
                                                    sendMail(semail, stuname, con_venue, con_time, con_date, lec_name);
                                                } catch (Exception ex) {
                                                    Logger.getLogger(LguiAppointment.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                                JOptionPane.showMessageDialog(null, "Email Sent & Cancel Successfully!","Email Sent & Cancel Successfully!", JOptionPane.INFORMATION_MESSAGE);
                                                break;
                                            }else
                                            {
                                            }
                                        }
                                
                                    }
                                });
                                lblSname[i]= new JLabel(x.getS().getName());
                                lblSnamee[i]= new JLabel("   Student Name");
                                lblSemail[i] = new JLabel(x.getS().getEmail()); 
                                lblSemaill[i] = new JLabel("   Email"); 
                                lblSphone[i] = new JLabel(x.getS().getPhonenum());
                                lblSphonee[i] = new JLabel("   Phone");
                                resetButton[i].setIcon(new ImageIcon("image\\" + x.getS().getImage()));
                                buttonLeftPanel[i].add(lblSnamee[i]);
                                buttonLeftPanel[i].add(lblSname[i]);
                                buttonLeftPanel[i].add(lblSemaill[i]);
                                buttonLeftPanel[i].add(lblSemail[i]);
                                buttonLeftPanel[i].add(lblSphonee[i]);
                                buttonLeftPanel[i].add(lblSphone[i]);
                                buttonLeftPanel[i].add(lblvenuee[i]);
                                buttonLeftPanel[i].add(lblvenue[i]);
                                buttonLeftPanel[i].add(lbltimee[i]);
                                buttonLeftPanel[i].add(lbltime[i]);
                                buttonLeftPanel[i].add(lbldatee[i]);
                                buttonLeftPanel[i].add(lbldate[i]);
                                buttonLeftPanel[i].add(cc[i]);
                                buttonLeftPanel[i].add(c[i]);
                    }
                
                    }catch(ParseException pe){}

                }

                labelPanel[i].add(resetButton[i]);
                leftPanel[i].add(labelPanel[i]);
                leftPanel[i].add(buttonLeftPanel[i]);
                contentPane.add(leftPanel[i]);
                contentPane.add(g);
            }
        }
                
        setContentPane(contentPane);
        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
        
    public LguiAppointment() {
        initComponents();
        JOptionPane.showMessageDialog(this, "You Cannot Open Like This","You Cannot Open Like This!", JOptionPane.ERROR_MESSAGE);
        window = false;
    }
    
    public LguiAppointment(LguiCalendar a) {
        initComponents();
        
        calendar = a;
        calendar.setLecAppointment(this);
        
        window = false;
    }
    
       public static void sendMail(String recepient, String stuname, String con_venue, String con_time, String con_date, String lec_name) throws Exception {  
       System.out.println("Preparing to send message");
       Properties properties = new Properties();
       
       properties.put("mail.smtp.auth", "true");
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.host", "smtp.gmail.com");
       properties.put("mail.smtp.port", "587");
       
       String myAccountEmail = "consultationbookingsystem@gmail.com";
       String myAccountPassword = "consultation123@";
       
       Session session = Session.getInstance(properties, new Authenticator() {
       
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(myAccountEmail, myAccountPassword);
           }
       });
       
       Message message = prepareMessage(session, myAccountEmail, recepient, stuname,con_venue, con_time, con_date,lec_name);
       Transport.send(message);
       System.out.println("Message send successfully");
   }

    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String stuname, String con_venue, String con_time, String con_date, String lec_name) {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject("YOUR COPY : Lecturer Consultation Hours : " + lec_name + " IS CANCELLED");
           message.setText("=============================================================\n" +
                            "|  This is a system generated email. Please do not reply.   |\n" +
                            "============================================================= \n\n"
                   + "Your Consultation with " + lec_name +" is cancelled on:- \n"
                   + "Venue: " + con_venue + "\n"
                           + "Consultation Time: " + con_time + "\n"
                                   + "Consultation Date: " + con_date + "\n\n"
                                           + "=============================================================\n" +
                                            "For more information, please login to the Consultation Booking System. \n"
                                           + "Technical Services");
           return message;
       } catch (Exception ex) {
           Logger.getLogger(LguiAppointment.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(400, 300));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
                
        if(window == false){
            this.dispose();
        }
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(LguiAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LguiAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LguiAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LguiAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LguiAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
