package consultationbookingsystem;
import static consultationbookingsystem.LguiAppointment.sendMail;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.table.*;
public class SguiMyBookings extends JPanel implements ActionListener{
    private Student current;
    private JLabel lbl1;
    private JButton btnCancel;
    private JScrollPane sp;
    private DefaultTableModel tblmdlBooking;
    private JTable tblBooking;
    private SguiDashboard studentdashboard;
    
    public void setCurrentUser(Student x){
        current = x;
        
        DefaultTableModel model = (DefaultTableModel) tblBooking.getModel();
        model.setRowCount(0);
        
        int size = current.getCons().size();
        String[][] data = new String[size][4];
        for(int i=0; i<size; i++){
            Consultation y = current.getCons().get(i);
            data[i][0] = y.getL().getName();
            data[i][1] = y.getVenue();
            data[i][2] = y.getDay();
            data[i][3] = y.getTime();            
        }
        String[] columnNames = {"Lecturer's Name", "Venue", "Date", "Time"};
        tblmdlBooking = new DefaultTableModel(data, columnNames){
            @Override 
            public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        String date2 = formatter.format(date);
        
        for(int i=tblmdlBooking.getRowCount(); i>0;i--){
            try{
                Date date1 = formatter.parse(tblmdlBooking.getValueAt(i-1, 2).toString());
                Date date3 = formatter.parse(date2);
                if(date1.before(date3)){
                    tblmdlBooking.removeRow(i-1);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        tblBooking.setModel(tblmdlBooking);
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblBooking.getModel());
        tblBooking.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int firstColumnIndexToSort = 2;
        sortKeys.add(new RowSorter.SortKey(firstColumnIndexToSort, SortOrder.ASCENDING));
        
        int secondColumnIndexToSort = 3;
        sortKeys.add(new RowSorter.SortKey(secondColumnIndexToSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        sorter.setSortable(0, false);
        sorter.setSortable(1, false);
        sorter.setSortable(2, false);
        sorter.setSortable(3, false);
    }
    
    public SguiMyBookings(SguiDashboard a){
        studentdashboard = a;
        studentdashboard.setSguiMyBookings(this);
        
        setBackground(Color.WHITE);
        setLayout(null);
        setPreferredSize(new Dimension(850, 500));
        
        lbl1 = new JLabel("My Bookings");
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 26));
        lbl1.setBounds(30,30,400,60);
        
        btnCancel = new JButton("Cancel Booking");
        btnCancel.setBounds(600,60,150,50);
        btnCancel.addActionListener(this);
        
        tblBooking = new JTable();
        tblBooking.getTableHeader().setResizingAllowed(false);
        tblBooking.getTableHeader().setReorderingAllowed(false);
        tblBooking.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        sp = new JScrollPane(tblBooking);
        sp.setBounds(50,120,750,330);
        
        add(sp);
        
        
        add(lbl1);
        add(btnCancel);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnCancel){
            try
            {
                DefaultTableModel model = (DefaultTableModel)tblBooking.getModel();
                int SelectedRowIndex = tblBooking.convertRowIndexToModel(tblBooking.getSelectedRow()); 
                
                String lect = model.getValueAt(SelectedRowIndex, 0).toString();
                String venue = model.getValueAt(SelectedRowIndex, 1).toString();
                String day = model.getValueAt(SelectedRowIndex, 2).toString();
                String time = model.getValueAt(SelectedRowIndex, 3).toString();
                
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel this booking?\n"+lect+"\n"+venue+"\n"+day+"\n"+time, "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.NO_OPTION)
                {
                return;
                }
                else if (response == JOptionPane.YES_OPTION)
                {
                    model.removeRow(SelectedRowIndex);
                    
                    Consultation z = null;
                    
                    for(int i=0;i<current.getCons().size();i++){
                        Consultation y = current.getCons().get(i);
                        String slect = y.getL().getName();
                        String sday = y.getDay();
                        String stime = y.getTime();
                        
                        if(lect.equals(slect)&&day.equals(sday)&&time.equals(stime)){
                            z=y;
                            break;
                        }
                    }
                    current.getCons().remove(z);
                    z.setStudent(null);
                    
                    JOptionPane.showMessageDialog(null, "Cancelling & Sending Email...","Cancelling & Sending Email...", JOptionPane.INFORMATION_MESSAGE);
                    
                    try {
                            sendMail(z.getL().getEmail(), current.getName(), venue, time, day, lect);
                        } catch (Exception ex) {
                            Logger.getLogger(SguiMyBookings.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    
                    JOptionPane.showMessageDialog(null,"Successfully Cancelled.");
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Please select a booking.");
            }
        }
    }
    
    public void sendMail(String recepient, String stuname, String con_venue, String con_time, String con_date, String lec_name) throws Exception {  
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

    private Message prepareMessage(Session session, String myAccountEmail, String recepient, String stuname, String con_venue, String con_time, String con_date, String lec_name) {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject("YOUR COPY : Consultation Hours : " + stuname + " HAS CANCELLED CONSULTATION WITH YOU");
           message.setText("=============================================================\n" +
                            "|  This is a system generated email. Please do not reply.   |\n" +
                            "============================================================= \n\n"
                   + "Your Consultation with " + stuname +" is cancelled on:- \n"
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
    
}
