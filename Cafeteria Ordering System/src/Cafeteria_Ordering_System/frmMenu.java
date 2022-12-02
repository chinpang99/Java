/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cafeteria_Ordering_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Scanner;
import javafx.scene.layout.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Pang
 */
class no{
    int no;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
}

public class frmMenu extends javax.swing.JFrame {

    String value_selected;
    
    public frmMenu()
    {
        initComponents();
    }
    /**
     * Creates new form frmMenu
     */
    public frmMenu(String Name) {
        initComponents();
        
        lblFoodType.setText(Name);
        File file = new File("Food&Beverage.txt");
        String Line1;
        
        JPanel contentPane = new JPanel();
        JLabel g = new JLabel("View my Cart");
        g.setIcon(new ImageIcon("C:\\Users\\Pang\\Documents\\NetBeansProjects\\Assignment\\src\\Cafeteria_Ordering_System\\Pictures\\cart.png"));
        contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        g.setCursor(new Cursor(Cursor.HAND_CURSOR));
        g.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
               
               new frmViewMenu().setVisible(true);
               dispose();

            }  
        }); 
        //GridLayout grid = new GridLayout(3,3,2,1);
        //JPanel yourGrid = new JPanel(grid);
        contentPane.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));

        try
        {
            FileReader fr = new FileReader(file);
            LineNumberReader lr = new LineNumberReader(fr);
            Scanner Sc1 = new Scanner(file);
            int lineNumberCount = 0;
            
            try{
                while(lr.readLine()!=null)
                {
                    lineNumberCount++;
                    while(Sc1.hasNextLine())
                    {
                        Line1 = Sc1.nextLine();
                        String UserLine[] = Line1.split(",");
                        JPanel[] leftPanel = new JPanel[lineNumberCount];
                        JPanel[] buttonLeftPanel = new JPanel[lineNumberCount];
                        JLabel[] resetButton = new JLabel[lineNumberCount];
                        JLabel[] resetButtonn = new JLabel[lineNumberCount];
                        JPanel[] labelPanel = new JPanel[lineNumberCount];
                        JSpinner[] a = new JSpinner[lineNumberCount];
                        JButton[] b = new JButton[lineNumberCount];

                        
                        if(UserLine[2].equals(lblFoodType.getText()))
                        { 
                        //JLabel positionLabel = new JLabel(UserLine[0]);
                        for (int i =0; i <lineNumberCount; i ++) 
                            {
                                leftPanel[i] = new JPanel();  
                                resetButtonn[i] = new JLabel(UserLine[0], JLabel.CENTER);
                                leftPanel[i].setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
                                leftPanel[i].setLayout(new BoxLayout(leftPanel[i], BoxLayout.Y_AXIS)); 
                                labelPanel[i] = new JPanel();
                                buttonLeftPanel[i] = new JPanel();
                                a[i] = new JSpinner();
                                b[i] = new JButton("Add To Cart");
                                Dimension d = new Dimension(70, 30);
                                a[i].setPreferredSize(d);
                                a[i].setMinimumSize(d);
                                //positionLabel[i] = new JLabel("HI", JLabel.CENTER);

                                resetButton[i] = new JLabel();
                                String [] imagesnames = {UserLine[3]};
                                resetButton[i].setIcon(new ImageIcon(imagesnames[i]));
                                
                                
                                buttonLeftPanel[i].add(resetButtonn[i]);
                                labelPanel[i].add(resetButton[i]);
                                buttonLeftPanel[i].add(a[i]);
                                buttonLeftPanel[i].add(b[i]);
                                leftPanel[i].add(labelPanel[i]);
                                leftPanel[i].add(buttonLeftPanel[i]);
                                contentPane.add(leftPanel[i]);
                                contentPane.add(g);
                                
                                ChangeListener listener = new ChangeListener() {
                                    public void stateChanged(ChangeEvent e) {
                                        JSpinner spinner = (JSpinner) e.getSource();
                                        int value = (int)spinner.getValue();
                                        no spinnervalue = new no();
                                        spinnervalue.setNo(value);
                                        
                                        int haha = spinnervalue.getNo();
                                        value_selected = Integer.toString(haha);
                                    }
                                  };

                                  a[i].addChangeListener(listener);
                                
                                
                                b[i].addActionListener(new frmMenu.Action()
                                 {
                                    public void actionPerformed (ActionEvent e)
                                    {
                                        System.out.println(UserLine[0]);
                                        System.out.println(value_selected);
                                        
                                        String menu_name = UserLine[0].toString();
                                        String price = UserLine[1].toString();
                                        String valueselected = value_selected;
                                        int a = Integer.parseInt(valueselected);
                                        int b = Integer.parseInt(price);
                                        int c = b * a;
                                        String totalprice =  String.valueOf(c);
                                        
                                        
                                        File F = new File("order.txt"); //creating an object for the file
                                        System.out.println(F.exists());
                                        try{
                                           FileWriter fw = new FileWriter(F, true);
                                           BufferedWriter bw = new BufferedWriter(fw);
                                           Order O1 = new Order(menu_name,price,valueselected,totalprice);
                                           bw.write(O1.Order());
                                           bw.flush();
                                           bw.close();


                                           JOptionPane.showMessageDialog(null, "Order Successfully!","Order Successfully!", JOptionPane.INFORMATION_MESSAGE);
                                           frmCustomer C = new frmCustomer();
                                           C.setVisible(true);
                                           dispose();
                                        }
                                        catch (IOException Ex)
                                        {

                                        }
                                        
                                        
                                    }
                                 }
                                );
                            }
                        
                    }
                                                }
                }
            }catch (IOException Ex)
            {
                
            }
        }catch(IOException Ex)
            {
                
            }
        
        setContentPane(contentPane);
        pack();
        //setLocationByPlatform(true);
        setVisible(true);
    }

    
        static class Action implements ActionListener{
        @Override
        public void actionPerformed (ActionEvent e)
        {
            if (e.getSource() instanceof JButton) {
                String text = ((JButton) e.getSource()).getText();
                System.out.println(text);
                //JOptionPane.showMessageDialog(null, text);
            }
            
        }


    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoodType = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblFoodType.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(lblFoodType)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(lblFoodType, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel lblFoodType;
    // End of variables declaration//GEN-END:variables
}
