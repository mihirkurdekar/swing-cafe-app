package src.CafeApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.*;



/*
 * Frame.java
 * It has all the GUI of main window of the program
 * All the listeners are also in this 
 * Created on 14 Jul, 2011, 4:01:44 PM
 */

/**
 * @author mihir
 */
@SuppressWarnings("serial")
public class Frame extends javax.swing.JFrame {

    /** Creates new form Frame */
    public Frame() {
        initComponents();
    }

    /*
     * 	I really don't what suppressWarnings that is generated by eclipse 
     */
    @SuppressWarnings({ })
    
    /*
     * This method is called from within the constructor
     * Initializes every GUI component as needed and packs the Frame
     */
    private void initComponents() {
    	
    	jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Select a category:");

        jLabel2.setText("Items in the bill");
        
        jLabel3.setText("Type no.s of menu items:");
        
        //adding action listener to the text field
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        
        //setting up text area and scroll pane 
        jTextArea1.setColumns(3);
        jTextArea1.setRows(3);
        jScrollPane1.setViewportView(jTextArea1);
        int fontPoints = 12; // or whatever works best!
        jTextArea1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, fontPoints ));
        //Setting a to border, list selection model and creating a list
        jList1.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.darkGray));
        listSelectionModel = jList1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return Exec.list.length; }
            public Object getElementAt(int i) { return Exec.list[i]; }
        });
        jScrollPane2.setViewportView(jList1);
        
        //setting text and adding action listeners to the button 
        jButton1.setText("Add one");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Edit&Print Bill");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        
        
        jButton4.setText("AddMany");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(selections));
        jComboBox1.setEditable(false);
        jComboBox1.setSelectedIndex(0);
        jComboBox1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 String newMode=(String)jComboBox1.getSelectedItem();
                if (newMode.equals("QUICK BITES")) {
                   Exec.changeStringArray(0,10);
                }
                else if (newMode.equals("PIZZA")) {
                	Exec.changeStringArray(11,17);
                }
                else if (newMode.equals("SANDWICHES")) {
                	Exec.changeStringArray(20,32);
                 }
                else if (newMode.equals("REFRESHMENTS")) {
                	Exec.changeStringArray(33,39);
                 }
                else if (newMode.equals("LUSHCIOUS SLUSHES")) {
                	Exec.changeStringArray(40,50);
                 }
                else if (newMode.equals("SQUASHES")) {
                	Exec.changeStringArray(51,63);
                 }
                else if (newMode.equals("VEG-STARTERS")) {
                	Exec.changeStringArray(64,77);
                 }
                else if (newMode.equals("VEG-SOUPS")) {
                	Exec.changeStringArray(78,84);
                 }
                else if (newMode.equals("VEG-NOODLES & RICE")) {
                	Exec.changeStringArray(85,91);
                 }
                else if (newMode.equals("VEG-GRAVIES")) {
                	Exec.changeStringArray(92,99);
                 }
                else if (newMode.equals("NONVEG-STARTERS")) {
                	Exec.changeStringArray(100,110);
                 }
                else if (newMode.equals("NONVEG-SOUPS")) {
                	Exec.changeStringArray(110,114);
                 }
                else if (newMode.equals("NONVEG-NOODLES & RICE")) {
                	Exec.changeStringArray(115,121);
                 }
                else if (newMode.equals("NONVEG-GRAVIES")) {
                	Exec.changeStringArray(122,126);
                 }
                else if (newMode.equals("PAV BHAJI")) {
                	Exec.changeStringArray(127,136);
                 }
                else if (newMode.equals("FRANKY & ROLLS")) {
                	Exec.changeStringArray(137,159);
                 }
                else{
                	Exec.list=Exec.menu;
                }
                
                jList1.validate();
                jList1.repaint();
        	}
        });
        
       
        //The whole thing from below this method till the end of this method is nothing code to add components and get desired alignment
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(119, 119, 119)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                                        .addComponent(jButton2)
                                        .addGap(167, 167, 167))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        pack();
    }
    
    //This is just list listener it assigns index selected in list as SelectedI
    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();

            if (lsm.isSelectionEmpty()) {
                jTextArea1.append(" <none>");
            } else {
                // Find out which indexes are selected.
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                    	//jTextArea1.append(" " +i);
                    	selectedI=i;
                    }
                }
            }
            
            
        }
    }
                                      

    //Action Listener for text field
    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String text = jTextField1.getText();
        jTextArea1.setText("");
        int x=Integer.parseInt(text);
        if(x>0&&x<=Exec.menu.length){
        	Exec.Item(x-1);
        	jTextArea1.append(Exec.display()+"");
        }
        else{
        	Exec.error("Wrong choice entered");
        } 
    }  
    
    //Action listener for ADD Button
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	Exec.Item(selectedI);
    	jTextArea1.removeAll();
    	jTextArea1.setText(null);
    	jTextArea1.append(Exec.display()+"");
    	jTextField1.selectAll();
    	        
    }                          
                                    
    //Action Listener for clear button
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
        Exec.empty();
        jTextArea1.removeAll();
        Exec.display();
        jTextArea1.setText("");
        jTextArea1.repaint();
    }                                     
    
    //Action Listener for to print or edit bill button creates a instance of popup and shows
	private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Popup().setVisible(true);
            }
        });
    	
    	
    }
	
    //Action listener for Add many button
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMany().setVisible(true);
            }
        });
    }
    //This is the main which creates a Frame instance 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    
  
    // Variables declaration - do not modify
    String[] selections = {"COMPLETE MENU","QUICK BITES","PIZZA","SANDWICHES","REFRESHMENTS","LUSHCIOUS SLUSHES","SQUASHES","VEG-STARTERS","VEG-SOUPS","VEG-NOODLES & RICE","VEG-GRAVIES","NONVEG-STARTERS","NONVEG-SOUPS","NONVEG-NOODLES & RICE","NONVEG-GRAVIES","PAV BHAJI","FRANKY & ROLLS"};

    public static int selectedI;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    ListSelectionModel listSelectionModel;
    
    // End of variables declaration                   

}