/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.purchase_order;

import GUI.login;
import GUI.outputs.fail;
import GUI.outputs.success;
import Model.orderModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class view_related_products extends javax.swing.JFrame {
    static Logger log = Logger.getLogger(view_related_products.class.getName());

    DefaultTableModel dtm;
    orderModel adm;
     String product_order ;
        String product;
        String company;
        String qty;
        String uprice;
    String amount;
     String orderID;
    public view_related_products() {
        icon();
        initComponents();
        dtm = (DefaultTableModel) ordersLoader.getModel();
        adm = new orderModel();
        adm.loadOrderedProductViewer2("", dtm);
       String result2=adm.loadTotalAmount("",dtm); 
       int count = ordersLoader.getRowCount();
        String castCount = String.valueOf(count);
        addProductBtn.setVisible(false);
       
       totalAmountField.setText(result2);
       totalProducts.setText(castCount);
        ordersLoader.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        ordersLoader.getTableHeader().setPreferredSize(new Dimension(40, 40));
        ordersLoader.getTableHeader().setOpaque(false);
        ordersLoader.getTableHeader().setBackground(new Color(255, 255, 255));
        
    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/carpenter-icon.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ordersLoader = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        totalProducts = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        doneBtn = new javax.swing.JButton();
        addProductBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        ordersLoader.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        ordersLoader.setForeground(new java.awt.Color(69, 69, 69));
        ordersLoader.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PRODUCT", "COMPANY", "QUANTITY", "UNIT PRICE", "ORDER ID", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ordersLoader.setFocusable(false);
        ordersLoader.setGridColor(new java.awt.Color(255, 255, 255));
        ordersLoader.setIntercellSpacing(new java.awt.Dimension(0, 0));
        ordersLoader.setRowHeight(28);
        ordersLoader.setSelectionBackground(new java.awt.Color(222, 191, 142));
        ordersLoader.setSelectionForeground(new java.awt.Color(0, 0, 0));
        ordersLoader.setShowVerticalLines(false);
        ordersLoader.getTableHeader().setReorderingAllowed(false);
        ordersLoader.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ordersLoaderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ordersLoaderMouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(ordersLoader);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1052, 0, 40, 60));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/carpenter-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lanka Carvings");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 0, 110, 60));

        jPanel3.setBackground(new java.awt.Color(245, 230, 210));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/full-box.png"))); // NOI18N
        jLabel3.setText("TOTAL PRODUCTS :");

        totalProducts.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        totalProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalProducts.setText("qty");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/purchase-order.png"))); // NOI18N
        jLabel8.setText("TOTAL AMOUNT :");

        totalAmountField.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        totalAmountField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAmountField.setText("qty");

        jButton3.setBackground(new java.awt.Color(240, 209, 167));
        jButton3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setText("ADD ROW");
        jButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(184, 156, 118)));
        jButton3.setContentAreaFilled(false);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setFocusPainted(false);
        jButton3.setOpaque(true);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        doneBtn.setBackground(new java.awt.Color(240, 209, 167));
        doneBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        doneBtn.setForeground(new java.awt.Color(51, 51, 51));
        doneBtn.setText("DONE");
        doneBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(184, 156, 118)));
        doneBtn.setContentAreaFilled(false);
        doneBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doneBtn.setFocusPainted(false);
        doneBtn.setOpaque(true);
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        addProductBtn.setBackground(new java.awt.Color(240, 209, 167));
        addProductBtn.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        addProductBtn.setForeground(new java.awt.Color(51, 51, 51));
        addProductBtn.setText("ADD PRODUCT");
        addProductBtn.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(184, 156, 118)));
        addProductBtn.setContentAreaFilled(false);
        addProductBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProductBtn.setFocusPainted(false);
        addProductBtn.setOpaque(true);
        addProductBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalProducts)
                .addGap(59, 59, 59)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(totalAmountField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(addProductBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(totalProducts, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                        .addComponent(totalAmountField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1104, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ordersLoaderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersLoaderMouseClicked
// String orderID=null;
//
//   int row = ordersLoader.getSelectedRow();
//        Object o1 = ordersLoader.getValueAt(row, 0);
//        String s1 = String.valueOf(o1);
//        orderID=s1;
//       
//       add_newer_product anp=new add_newer_product();
//       adm.loadOrderedProductViewer(orderID, anp.dtm);
//       anp.setVisible(true);      
    }//GEN-LAST:event_ordersLoaderMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void ordersLoaderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ordersLoaderMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersLoaderMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dtm.addRow(new Object[]{null,null,null,null,null,null,null});
    }//GEN-LAST:event_jButton3ActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
  
        int row = ordersLoader.getSelectedRow();
        Object o2 = ordersLoader.getValueAt(row, 0);
        product = String.valueOf(o2);

        Object o3 = ordersLoader.getValueAt(row, 1);
        company = String.valueOf(o3);

        Object o4 = ordersLoader.getValueAt(row, 2);
        qty = String.valueOf(o4);

        Object o5 = ordersLoader.getValueAt(row, 3);
        uprice = String.valueOf(o5);

         Object o6 = ordersLoader.getValueAt(row, 4);
         orderID=String.valueOf(o6);
             
             
        int intqty=Integer.parseInt(qty);
        int intuprice=Integer.parseInt(uprice);

        int total=intqty*intuprice;
        amount=String.valueOf(total);
        dtm.setValueAt(amount, row, 5);

        doneBtn.setVisible(false);
        addProductBtn.setVisible(true);
    }//GEN-LAST:event_doneBtnActionPerformed

    private void addProductBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductBtnActionPerformed

           String product_id=null;
        String result2=adm.order_reg(orderID, product_id, company, qty, uprice, amount, product);
        
            if (result2 == "order added succesfully") {
                success suceed = new success();
                suceed.setVisible(true);
                  adm.loadOrderedProductViewer2(orderID, dtm);
                  String result3=adm.loadTotalAmount(orderID,dtm); 
                  int count = ordersLoader.getRowCount();
                  String castCount = String.valueOf(count);
                  totalProducts.setText(castCount);
                  totalAmountField.setText(result3);
            } else if (result2 == "order adding error") {
                fail f = new fail();
                f.popupstatus(result2);
                f.setVisible(true);
                log.debug(result2);
            }
        
    }//GEN-LAST:event_addProductBtnActionPerformed

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
            java.util.logging.Logger.getLogger(view_related_products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_related_products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_related_products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_related_products.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_related_products().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductBtn;
    private javax.swing.JButton doneBtn;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable ordersLoader;
    public javax.swing.JLabel totalAmountField;
    public javax.swing.JLabel totalProducts;
    // End of variables declaration//GEN-END:variables
}
