/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.outputs;

import java.awt.Toolkit;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class fail extends javax.swing.JFrame {
   static Logger log = Logger.getLogger(fail.class.getName());
    /**
     * Creates new form fail2
     */
    public fail() {
        icon();
        initComponents();
    }

       private void icon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/carpenter-icon.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        jPanel1.setPreferredSize(new java.awt.Dimension(548, 349));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/Forgot password.gif"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 15)); // NOI18N
        jButton1.setText("Okay");
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fail().setVisible(true);
            }
        });
    }

        public void popupstatus(String result) {
    
        //uer login section 
        if(result =="Login Failure"){
               try {
                       jLabel3.setText("User Login Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
           }
    
        
        
        
        
        //attendance register,update and delete section
        if(result =="attendance adding error"){
               try {
                       jLabel3.setText("Attendance Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="Attendace update Failed"){
               try {
                       jLabel3.setText("Attendance Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="attendance deleting error"){
               try {
                       jLabel3.setText("Attendance Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
    
        
        
        
        
    //Staff register,update and delete
        if(result =="Staff adding error"){
               try {
                       jLabel3.setText("Staff Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="Staff updating error"){
               try {
                       jLabel3.setText("Staff Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="staff deleting error"){
               try {
                       jLabel3.setText("Staff Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        //Admin  register,update and Delete
        if(result =="admin adding error"){
               try {
                       jLabel3.setText("Admin Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="admin updating error"){
               try {
                       jLabel3.setText("Admin Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="admin deleting error"){
               try {
                       jLabel3.setText("Admin Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //job insert, update and delete
        if(result =="job adding error"){
               try {
                       jLabel3.setText("Designation Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="job updating error"){
               try {
                       jLabel3.setText("Designation Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                    }
             }
        if(result =="job deleting error"){
               try {
                       jLabel3.setText("Designation Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //basic salary insert, update and delete
        if(result =="basic salary added error"){
               try {
                       jLabel3.setText("Salary Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="basic salary update error"){
               try {
                       jLabel3.setText("Salary Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="basic salary delete error"){
               try {
                       jLabel3.setText("Salary Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //staff_payments insert, update and delete
        if(result =="payment added error"){
               try {
                       jLabel3.setText("Payment Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="payment updated error"){
               try {
                       jLabel3.setText("Payment Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="payment deleting error"){
               try {
                       jLabel3.setText("Payment Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        //waterbill payments insert, update and delete
        if(result =="waterbill added fail"){
               try {
                       jLabel3.setText("Waterbill Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="waterbill payment update fail"){
               try {
                       jLabel3.setText("Waterbill Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="waterbill payment delete fail"){
               try {
                       jLabel3.setText("Waterbill Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        //electricity payments insert, update and delete
        if(result =="electricitybill added fail"){
               try {
                       jLabel3.setText("Electricity Bill Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="electricitybill payment update fail"){
               try {
                       jLabel3.setText("Electricity Bill Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="electricity payment delete fail"){
               try {
                       jLabel3.setText("Electricity Bill Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //product category insert, update and delete
        if(result =="cat adding error"){
               try {
                       jLabel3.setText("Category Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="cat update error"){
               try {
                       jLabel3.setText("Category Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="cat deleted error"){
               try {
                       jLabel3.setText("Category Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //company insert, update and delete
        if(result =="company adding error"){
               try {
                       jLabel3.setText("Company Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="company updated error"){
               try {
                       jLabel3.setText("Company Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="company deleted error"){
               try {
                       jLabel3.setText("Company Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        //Supplier insert, update and delete
        if(result =="supplier adding error"){
               try {
                       jLabel3.setText("Supplier Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="supplier update error"){
               try {
                       jLabel3.setText("Supplier Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="supplier delete error"){
               try {
                       jLabel3.setText("Supplier Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //product insert, update and delete
        if(result =="product adding error"){
               try {
                       jLabel3.setText("Product Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="product updated error"){
               try {
                       jLabel3.setText("Product Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="product delete error"){
               try {
                       jLabel3.setText("Product Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //order insert, update and delete
        if(result =="order adding error"){
               try {
                       jLabel3.setText("Order Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="order updating error"){
               try {
                       jLabel3.setText("Order Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="order deleting error"){
               try {
                       jLabel3.setText("Order Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        //order insert, update and delete
        if(result =="order id adding error"){
               try {
                       jLabel3.setText("Order Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="order id updating error"){
               try {
                       jLabel3.setText("Order Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="order id deleted error"){
               try {
                       jLabel3.setText("Order Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        
        //invoice insert, update and delete
        if(result =="invoice added error"){
               try {
                       jLabel3.setText("Invoice Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="invoice updated error"){
               try {
                       jLabel3.setText("Invoice Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="invoice deleted error"){
               try {
                       jLabel3.setText("Invoice Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        if(result =="invoice Canceled error"){
               try {
                       jLabel3.setText("Invoice Cancellation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        
        
        
        //invoice_item insert, update and delete
        if(result =="invoice item added error"){
               try {
                       jLabel3.setText("Invoice Item Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="invoice item updated error"){
               try {
                       jLabel3.setText("Invoice Item Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="order id deleted error"){
               try {
                       jLabel3.setText("Invoice Item Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="Lesser Items are Remaining in Stock"){
               try {
                       jLabel3.setText("Limited Stocks Remaining");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        //grn insert, update and delete
        if(result =="GRN added Failed"){
               try {
                       jLabel3.setText("GRN Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="GRN updated Failed"){
               try {
                       jLabel3.setText("GRN Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="item added Failed"){
               try {
                       jLabel3.setText("GRN Item Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        
        
        //customer insert, update and delete
        if(result =="customer added error"){
               try {
                       jLabel3.setText("Customer Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="customer updated error"){
               try {
                       jLabel3.setText("Customer Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="customer deleted error"){
               try {
                       jLabel3.setText("Customer Deletion Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        
        //stock insert and update
        if(result =="stock adding error"){
               try {
                       jLabel3.setText("Stock Registration Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
        if(result =="stock updating error"){
               try {
                       jLabel3.setText("Stock Updation Failed");
                       this.dispose();
                    } catch (Exception e) {
                       e.printStackTrace();
                       log.debug(e.getMessage());
                    }
             }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
