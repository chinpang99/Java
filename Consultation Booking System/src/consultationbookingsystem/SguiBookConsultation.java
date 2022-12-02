package consultationbookingsystem;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;
public class SguiBookConsultation extends JPanel{
    private Student current;
    private ArrayList<Lecturer> lec;
    private JPanel pnl1,pnl2;
    private JLabel lbl1,lbl2;
    protected SguiDashboard studentdashboard;
    protected SguiLecHours lechours;
    private DefaultTableModel tblmdlLec;
    private JTable tblLec;
    
    public void setCurrent(Student a){
        current = a;
        
        DefaultTableModel model = (DefaultTableModel) tblLec.getModel();
        model.setRowCount(0);
        
        int size = lec.size();
        String[][] data = new String[size][5];
        for(int i=0; i<size; i++){
            Lecturer x = lec.get(i);
            data[i][0] = x.getUserid();
            data[i][1] = x.getName();
            data[i][2] = x.getEmail();
            data[i][3] = x.getPhonenum();
            data[i][4] = x.getSchool();
        }
        String[] columnNames = {"","Name", "Email", "Phone Number", "School" };
        tblmdlLec = new DefaultTableModel(data, columnNames){
            @Override 
            public boolean isCellEditable(int row, int column)
                {
                    return false;
                }
            };
        tblLec.setModel(tblmdlLec);
        tblLec.removeColumn(tblLec.getColumnModel().getColumn(0));
    }
    
    public void setSguiLecHours(SguiLecHours a){
        lechours = a;
    }
    
    public SguiBookConsultation(SguiDashboard a){
        studentdashboard = a;
        studentdashboard.setSguiBookConsultation(this);
        
        lec = studentdashboard.getLec();
        
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(850, 500));
        
        pnl1 = new JPanel();
        pnl1.setLayout(null);
        pnl1.setPreferredSize(new Dimension(850, 100));
        pnl1.setBackground(Color.WHITE);
        
        pnl2 = new JPanel();
        pnl2.setLayout(null);
        pnl2.setPreferredSize(new Dimension(850, 400));
        pnl2.setBackground(Color.WHITE);
        
        lbl1 = new JLabel("Book Consultation");
        lbl1.setFont(new Font("Calibri", Font.PLAIN, 26));
        lbl1.setBounds(30,30,400,60);
        
        lbl2 = new JLabel("Please select a Lecturer...");
        lbl2.setBounds(50,0,400,30);
        
        
        tblLec = new JTable();
        tblLec.getTableHeader().setResizingAllowed(false);
        tblLec.getTableHeader().setReorderingAllowed(false);
        
        
        tblLec.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tblLec.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent evt) {
                tblLecMouseClicked(evt);
            }
        });
        
        JScrollPane sp = new JScrollPane(tblLec);
        sp.setBounds(50,40,750,300);
        
        pnl1.add(lbl1);
        pnl2.add(lbl2);
        pnl2.add(sp);
        
        add(pnl1, BorderLayout.NORTH);
        add(pnl2, BorderLayout.CENTER);
    }
    
    private void tblLecMouseClicked(MouseEvent evt) {
        DefaultTableModel model = (DefaultTableModel)tblLec.getModel();
        int selectedRowIndex = tblLec.getSelectedRow();
        String userid = model.getValueAt(selectedRowIndex, 0).toString();
        Lecturer currLec = null;
        
        for(int i=0; i<lec.size(); i++){
            Lecturer ac = lec.get(i);
            if(ac.getUserid().equals(userid)){
                currLec = ac;
                break;
            }
        }
        this.setVisible(false);
        studentdashboard.getStudentDashboard().add(lechours, BorderLayout.CENTER);
        lechours.setCurrent(current, currLec);
        lechours.setVisible(true);
    }
}
