package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;
import java.util.Locale;
import javax.swing.*;
import javax.swing.table.*;
public class SguiLecHours extends JPanel implements ActionListener{
    private SguiBookConsultation bookconsultation;
    private JPanel pnl1,pnl2;
    private JLabel lbl1, lblProfile, lblName, lblEmail,lblPhonenum,lblSchool;
    private ImageIcon imgProfile;
    private JButton btnBack;
    private JScrollPane sp;
    private DefaultTableModel tblmdlHour;
    private JTable tblHour;
    private Student currStu;
    private Lecturer currLec;
    private ArrayList<Consultation> cons;
    
    public void setCurrent(Student a, Lecturer b){
        currStu = a;
        currLec = b;
        lblName.setText(currLec.getName());
        lblEmail.setText(currLec.getEmail());
        lblPhonenum.setText(currLec.getPhonenum());
        lblSchool.setText(currLec.getSchool());
        imgProfile.setImage(new ImageIcon("Lecturer Image/"+currLec.getImage()).getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        
        DefaultTableModel model = (DefaultTableModel) tblHour.getModel();
        model.setRowCount(0);
        
        int size = currLec.getCons().size();
        String[][] data = new String[size][4];
        for(int i=0; i<size; i++){
            Consultation x = currLec.getCons().get(i);
            data[i][0] = x.getVenue();
            data[i][1] = x.getDay();
            data[i][2] = x.getTime();
            if(x.getS()==null){
                data[i][3] = "Available";
            }else{
                data[i][3] = x.getS().getUserid();
            }
            
        }
        String[] columnNames = {"Venue", "Date", "Time", "Booked Status" };
        tblmdlHour = new DefaultTableModel(data, columnNames){
            @Override 
            public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
        Date date = new Date();
        String date2 = formatter.format(date);
        
        for(int i=tblmdlHour.getRowCount(); i>0;i--){
            try{
                Date date1 = formatter.parse(tblmdlHour.getValueAt(i-1, 1).toString());
                Date date3 = formatter.parse(date2);
                if(date1.before(date3)){
                    tblmdlHour.removeRow(i-1);
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
        }
        
        tblHour.setModel(tblmdlHour);
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(tblHour.getModel());
        tblHour.setRowSorter(sorter);
        java.util.List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        
        int firstColumnIndexToSort = 1;
        sortKeys.add(new RowSorter.SortKey(firstColumnIndexToSort, SortOrder.ASCENDING));
        
        int secondColumnIndexToSort = 2;
        sortKeys.add(new RowSorter.SortKey(secondColumnIndexToSort, SortOrder.ASCENDING));
        
        sorter.setSortKeys(sortKeys);
        sorter.sort();
        sorter.setSortable(0, false);
        sorter.setSortable(1, false);
        sorter.setSortable(2, false);
        sorter.setSortable(3, false);
        
        
    }
    
    public SguiLecHours(SguiBookConsultation a) {
        bookconsultation = a;
        bookconsultation.setSguiLecHours(this);
        
        cons = bookconsultation.studentdashboard.getCons();
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(850, 500));
        
        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setPreferredSize(new Dimension(850, 180));
        pnl1.setBackground(Color.WHITE);
        
        pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setPreferredSize(new Dimension(850, 320));
        pnl2.setBackground(Color.WHITE);
        
        imgProfile = new ImageIcon();
        lblProfile = new JLabel(imgProfile);
        lblProfile.setBounds(150,30,150,150);
        
        lblName = new JLabel();
        lblName.setBounds(400,30,150,30);
        
        lblEmail = new JLabel();
        lblEmail.setBounds(400,60,150,30);
        
        lblPhonenum = new JLabel();
        lblPhonenum.setBounds(400,90,150,30);
        
        lblSchool = new JLabel();
        lblSchool.setBounds(400,120,150,30);
        
        lbl1 = new JLabel("Click on a row \nto book consultation.");
        lbl1.setBounds(30,30,90,80);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(30,250,90,50);
        btnBack.addActionListener(this);
        
        pnl1.add(lblProfile);
        pnl1.add(lblName);
        pnl1.add(lblEmail);
        pnl1.add(lblPhonenum);
        pnl1.add(lblSchool);
        
        
        tblHour = new JTable();
        tblHour.getTableHeader().setResizingAllowed(false);
        tblHour.getTableHeader().setReorderingAllowed(false);
        tblHour.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tblHour.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                tblHourMouseClicked(evt);
            }
        });
        
        sp = new JScrollPane(tblHour);
        sp.setBounds(140,20,650,280);
        
        pnl2.add(sp);
        
        pnl2.add(lbl1);
        
        pnl2.add(btnBack);
        
        add(pnl1, BorderLayout.NORTH);
        add(pnl2, BorderLayout.CENTER);
    }
    
    private void tblHourMouseClicked(MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel)tblHour.getModel();
        int selectedRowIndex = tblHour.convertRowIndexToModel(tblHour.getSelectedRow()); 
        
        String day = model.getValueAt(selectedRowIndex, 1).toString();
        String time = model.getValueAt(selectedRowIndex, 2).toString();
        String userid = model.getValueAt(selectedRowIndex, 3).toString();
        
        if(!userid.equals("Available"))
        {
            JOptionPane.showMessageDialog(null,"Unable to Book.\nReason :\nThis session has been booked.");
            return;
        }
        
        for(int i=0;i<currStu.getCons().size();i++){
            Consultation y = currStu.getCons().get(i);
            String sday = y.getDay();
            String stime = y.getTime();
            if(day.equals(sday)&&time.equals(stime)){
               JOptionPane.showMessageDialog(null,"Unable to Book.\nReason :\nYou have other session on the same day and time.");
               return;
            }
        }
        
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to book this session?", "Confirm",
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.NO_OPTION)
        {
           return;
        }
        else if (response == JOptionPane.YES_OPTION)
        {
            Consultation zz = null;
            for(int i=0;i<currLec.getCons().size();i++){
               Consultation z = currLec.getCons().get(i);
               if(day.equals(z.getDay())&&time.equals(z.getTime())){
                  zz = z;
                  break;
              }
            }
            
            zz.setStudent(currStu);
            currStu.getCons().add(zz);
            
            JOptionPane.showMessageDialog(null,"Successfully Booked.");
            this.setVisible(false);
            bookconsultation.studentdashboard.getStudentDashboard().add(bookconsultation.studentdashboard.mybookings, BorderLayout.CENTER);
            bookconsultation.studentdashboard.mybookings.setCurrentUser(currStu);
            bookconsultation.studentdashboard.mybookings.setVisible(true);
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnBack){
            this.setVisible(false);
            bookconsultation.studentdashboard.getStudentDashboard().add(bookconsultation, BorderLayout.CENTER);
            bookconsultation.setVisible(true);
        }
    }
    
}
