package src.CafeApp;

import java.awt.Font;
import java.io.IOException;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Popup.java
 *
 * Created on 19 Jul, 2011, 9:11:38 AM
 */

/**
 * @author mihir
 */
public class Popup extends javax.swing.JFrame {

    /**
	 * This is window which is used for printing or editing the bill has 1 jlist and 3 buttons
	 */
	private static final long serialVersionUID = 1L;
	/** Creates new form Popup */
    public Popup() {
        initComponents();
    }

    /** This method is called from within the constructor
     */
    @SuppressWarnings("serial")
	private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        //default close operation is dispose on close not exit on close cause program should not exit when this window is closed just the frame should be disposed 
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        //Setting a to list selection model and creating a list
        listSelectionModel = jList1.getSelectionModel();
        listSelectionModel.addListSelectionListener(new SharedListSelectionHandler());
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        jList1.setModel(new javax.swing.AbstractListModel() {
            public int getSize() { return Exec.billList.length; }
            public Object getElementAt(int i) { return Exec.billList[i]; }
        });
        
        //adding scrollpane to the list
        jScrollPane1.setViewportView(jList1);
        int fontPoints = 12; // or whatever works best!
        jList1.setFont(new Font(Font.MONOSPACED, Font.PLAIN, fontPoints ));
        
      //setting text and adding action listeners to the button 
        jButton1.setText("Delete");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("+1");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("-1");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               jButton3MouseClicked(evt);
            }
        });
        
        
        jButton4.setText("Get txt");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               try {
				jButton4MouseClicked(evt);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            }
        });
        
        jLabel1.setText("Name");

        jLabel2.setText("Qty.");

        jLabel3.setText("Amt");
        
        jLabel4.setText("Rate");
        
      //The whole thing from below this method till the end of this method is nothing code to add components and get desired alignment
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jButton1)
                .addGap(62, 62, 62)
                .addComponent(jButton2)
                .addGap(68, 68, 68)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(58, 58, 58))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 237, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(64, 64, 64)
                .addComponent(jLabel4)
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }
    
    //This is just list listener it assigns index selected in list as SelectedI
    class SharedListSelectionHandler implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) { 
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
           

            if (lsm.isSelectionEmpty()) {
            } else {
                // Find out which indexes are selected.
                int minIndex = lsm.getMinSelectionIndex();
                int maxIndex = lsm.getMaxSelectionIndex();
                for (int i = minIndex; i <= maxIndex; i++) {
                    if (lsm.isSelectedIndex(i)) {
                    	selectedI=i;
                    }
                }
            }
            
            
        }
    }
    
    //Action listener for delete Button
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	
        Exec.removeAt(selectedI);
        Frame.jTextArea1.removeAll();
    	Frame.jTextArea1.setText(null);
    	Frame.jTextArea1.append(Exec.display()+"");
        jList1.validate();
        jList1.repaint();    	       
    }                          
                                    
    //Action listener for -1
    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	Exec.increaseQuantity(selectedI);
    	Frame.jTextArea1.removeAll();
    	Frame.jTextArea1.setText(null);
    	Frame.jTextArea1.append(Exec.display()+"");
        jList1.validate();
        jList1.repaint();
       }   
  //Action listener for +1
    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {                                      
        // TODO add your handling code here:
    	
        Exec.reduceQuantity(selectedI);
    	Frame.jTextArea1.removeAll();
    	Frame.jTextArea1.setText(null);
    	Frame.jTextArea1.append(Exec.display()+"");
        jList1.validate();
        jList1.repaint();
       }   
    
    
    //Action listener to Get txt calls file writer method from file operations 
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) throws IOException {                                      
        // TODO add your handling code here:
    	FileOperations.fileWriter();
    	String program = "C:\\WINDOWS\\system32\\wordpad.exe";
    	String file = "D:\\Documents and Settings\\Report.txt";
    	load.exec(program + " " + file);
    }
    
    

    // Variables declaration - do not modify
    int selectedI;
    Runtime load = Runtime.getRuntime();
    ListSelectionModel listSelectionModel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration

}

