/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sales;

import GUI.outputs.fails;
import GUI.outputs.succese;
import Model.salesModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.scripts.JD;
import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;

/**
 *
 * @author DELL
 */
public class view_sales extends javax.swing.JFrame {
String monthlyYear="";
String year="";
String month="";
    static Logger log = Logger.getLogger(view_sales.class.getName());
    DefaultTableModel dtm;
    DefaultTableModel dtm2;
    DefaultTableModel dtm3;
    DefaultTableModel dtm4;
    DefaultTableModel dtm5;
    DefaultTableModel dtm6;
    salesModel adm;
    Connection conn;

    public view_sales() {
        icon();
        initComponents();
        conn = db.dbConnection.getConnection();
        int index = jTabbedPane1.getSelectedIndex();
        dtm = (DefaultTableModel) jTable1.getModel();
        dtm2 = (DefaultTableModel) jTable2.getModel();
        dtm3 = (DefaultTableModel) jTable3.getModel();
        dtm4 = (DefaultTableModel) products.getModel();
        dtm5 = (DefaultTableModel) products2.getModel();
        dtm6 = (DefaultTableModel) products4.getModel();
        adm = new salesModel();
        adm.loadInvoiceTable("", dtm);
        adm.loadInvoiceTable("", dtm2);
//        adm.loadInvoiceTable("", dtm3);
        adm.loadInvoiceTableMonth("", dtm3);
//        adm.loadInvoiceTableOnDate("");
//        adm.loadInvoiceTableOnMonth("", dtm2);
//        adm.loadInvoiceTableOnYear("", dtm3);
        date1();
        year();
        if (index == 0) {

        } else if (index == 1) {
            System.out.println("hello1");
        } else if (index == 2) {
            System.out.println("hello2");
        }

        //table header editing
        jTable1.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        jTable1.getTableHeader().setPreferredSize(new Dimension(40, 40));
        jTable1.getTableHeader().setOpaque(false);
        jTable1.getTableHeader().setBackground(new Color(255, 255, 255));

        jTable2.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        jTable2.getTableHeader().setPreferredSize(new Dimension(40, 40));
        jTable2.getTableHeader().setOpaque(false);
        jTable2.getTableHeader().setBackground(new Color(255, 255, 255));

        jTable3.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        jTable3.getTableHeader().setPreferredSize(new Dimension(40, 40));
        jTable3.getTableHeader().setOpaque(false);
        jTable3.getTableHeader().setBackground(new Color(255, 255, 255));

        products.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        products.getTableHeader().setPreferredSize(new Dimension(40, 40));
        products.getTableHeader().setOpaque(false);
        products.getTableHeader().setBackground(new Color(255, 255, 255));

        products2.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        products2.getTableHeader().setPreferredSize(new Dimension(40, 40));
        products2.getTableHeader().setOpaque(false);
        products2.getTableHeader().setBackground(new Color(255, 255, 255));

        products4.getTableHeader().setFont(new Font("Segoe UI Semibold", Font.BOLD, 12));
        products4.getTableHeader().setPreferredSize(new Dimension(40, 40));
        products4.getTableHeader().setOpaque(false);
        products4.getTableHeader().setBackground(new Color(255, 255, 255));
    }

    private void icon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/carpenter-icon.png")));
    }

    public void date1() {
        String txtDate = new SimpleDateFormat("dd / MM / yyyy", Locale.ENGLISH).format(new Date());
        jTextField1.setText(txtDate);
    }

    private void year() {
        int year = Year.now().getValue();
        String castedYear = String.valueOf(year);
        jTextField2.setText(castedYear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        header = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        title = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        alert = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        totalAmountField = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        products = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        alert1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        products2 = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        totalAmountField2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        statusField = new javax.swing.JComboBox<>();
        jPanel12 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        pnlLabel = new javax.swing.JLabel();
        pnlStatus = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        alert2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        products4 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        totalAmountField1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        yearFieldSection = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        pnlLabel1 = new javax.swing.JLabel();
        pnlStatus1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 51, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        header.setBackground(new java.awt.Color(255, 255, 255));
        header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 0, 1, new java.awt.Color(91, 50, 20)));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/cancel.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        header.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 0, -1, 60));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/carpenter-removebg-preview.png"))); // NOI18N
        header.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 60, 60));

        title.setFont(new java.awt.Font("Segoe UI Semibold", 1, 13)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Lanka Carvings");
        header.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 0, 110, 60));

        jPanel1.add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 60));

        jTabbedPane1.setBackground(new java.awt.Color(102, 51, 0));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(102, 51, 0)));
        jTabbedPane1.setFocusable(false);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(226, 185, 130));
        jPanel7.setLayout(null);

        alert.setBackground(new java.awt.Color(226, 185, 130));
        alert.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        alert.setForeground(new java.awt.Color(51, 51, 51));
        alert.setText("Please Select a Invoice To view the items");
        alert.setBorder(null);
        alert.setBorderPainted(false);
        alert.setContentAreaFilled(false);
        alert.setFocusPainted(false);
        alert.setOpaque(true);
        jPanel7.add(alert);
        alert.setBounds(0, 0, 370, 530);

        jPanel3.setBackground(new java.awt.Color(226, 185, 130));
        jPanel3.setDoubleBuffered(false);
        jPanel3.setEnabled(false);
        jPanel3.setFocusable(false);

        jPanel11.setBackground(new java.awt.Color(247, 215, 142));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/purchase-order.png"))); // NOI18N
        jLabel9.setText("TOTAL AMOUNT :");

        totalAmountField.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        totalAmountField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalAmountField.setText("amount");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(totalAmountField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jScrollPane9.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        products.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        products.setForeground(new java.awt.Color(69, 69, 69));
        products.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        products.setEnabled(false);
        products.setFocusable(false);
        products.setGridColor(new java.awt.Color(255, 255, 255));
        products.setIntercellSpacing(new java.awt.Dimension(0, 0));
        products.setOpaque(false);
        products.setRequestFocusEnabled(false);
        products.setRowHeight(28);
        products.setRowSelectionAllowed(false);
        products.setSelectionBackground(new java.awt.Color(222, 191, 142));
        products.setSelectionForeground(new java.awt.Color(0, 0, 0));
        products.setShowVerticalLines(false);
        products.getTableHeader().setReorderingAllowed(false);
        products.setUpdateSelectionOnSort(false);
        products.setVerifyInputWhenFocusTarget(false);
        products.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productsMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(products);
        if (products.getColumnModel().getColumnCount() > 0) {
            products.getColumnModel().getColumn(0).setResizable(false);
            products.getColumnModel().getColumn(1).setResizable(false);
            products.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel7.add(jPanel3);
        jPanel3.setBounds(0, 70, 370, 460);

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 530));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jTable1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        jTable1.setForeground(new java.awt.Color(69, 69, 69));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INVOICE ID", "PAYMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setGridColor(new java.awt.Color(255, 255, 255));
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(28);
        jTable1.setSelectionBackground(new java.awt.Color(222, 191, 142));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable1.setShowVerticalLines(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 510, 210));

        jTextField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("DD / MM / YYYY");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(164, 142, 109)));
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField1MouseExited(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 240, 30));

        jButton1.setBackground(new java.awt.Color(222, 191, 142));
        jButton1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("SEARCH");
        jButton1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(184, 156, 118)));
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusPainted(false);
        jButton1.setOpaque(true);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 90, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Rs. 0.00");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 390, 70));

        jLabel3.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel3.setText("Sales For the Date :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("None");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, 80, -1));

        jTabbedPane1.addTab("    Daily    ", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(226, 185, 130));
        jPanel9.setLayout(null);

        alert1.setBackground(new java.awt.Color(226, 185, 130));
        alert1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        alert1.setForeground(new java.awt.Color(51, 51, 51));
        alert1.setText("Please Select a Invoice To view the items");
        alert1.setBorder(null);
        alert1.setBorderPainted(false);
        alert1.setContentAreaFilled(false);
        alert1.setFocusPainted(false);
        alert1.setOpaque(true);
        jPanel9.add(alert1);
        alert1.setBounds(0, 0, 370, 530);

        jPanel6.setBackground(new java.awt.Color(226, 185, 130));
        jPanel6.setDoubleBuffered(false);
        jPanel6.setEnabled(false);
        jPanel6.setFocusable(false);

        jScrollPane8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        products2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        products2.setForeground(new java.awt.Color(69, 69, 69));
        products2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        products2.setEnabled(false);
        products2.setFocusable(false);
        products2.setGridColor(new java.awt.Color(255, 255, 255));
        products2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        products2.setOpaque(false);
        products2.setRequestFocusEnabled(false);
        products2.setRowHeight(28);
        products2.setRowSelectionAllowed(false);
        products2.setSelectionBackground(new java.awt.Color(222, 191, 142));
        products2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        products2.setShowVerticalLines(false);
        products2.getTableHeader().setReorderingAllowed(false);
        products2.setUpdateSelectionOnSort(false);
        products2.setVerifyInputWhenFocusTarget(false);
        products2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products2MouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(products2);
        if (products2.getColumnModel().getColumnCount() > 0) {
            products2.getColumnModel().getColumn(0).setResizable(false);
            products2.getColumnModel().getColumn(1).setResizable(false);
            products2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel10.setBackground(new java.awt.Color(247, 215, 142));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/purchase-order.png"))); // NOI18N
        jLabel15.setText("TOTAL AMOUNT :");

        totalAmountField2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        totalAmountField2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalAmountField2.setText("amount");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(totalAmountField2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountField2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(77, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel9.add(jPanel6);
        jPanel6.setBounds(0, 50, 370, 480);

        jPanel4.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 530));

        jLabel7.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Sales For the Month :");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 60, 150, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("None");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 60, 70, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Rs. 0.00");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 390, 70));

        statusField.setEditable(true);
        statusField.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        statusField.setForeground(new java.awt.Color(51, 51, 51));
        statusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "NONE" }));
        statusField.setSelectedIndex(12);
        statusField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(153, 153, 153)));
        statusField.setFocusable(false);
        statusField.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                statusFieldItemStateChanged(evt);
            }
        });
        statusField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusFieldActionPerformed(evt);
            }
        });
        jPanel4.add(statusField, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 260, -1, 30));

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(164, 142, 109)));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTextField2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jTextField2MouseExited(evt);
            }
        });
        jPanel12.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 30));

        jButton2.setBackground(new java.awt.Color(222, 191, 142));
        jButton2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setText("SEARCH");
        jButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(184, 156, 118)));
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusPainted(false);
        jButton2.setOpaque(true);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 60, 80, 30));

        jPanel4.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, 270, -1));

        jScrollPane6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jTable3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        jTable3.setForeground(new java.awt.Color(69, 69, 69));
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INVOICE ID", "PAYMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setFocusable(false);
        jTable3.setGridColor(new java.awt.Color(255, 255, 255));
        jTable3.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable3.setRowHeight(28);
        jTable3.setSelectionBackground(new java.awt.Color(222, 191, 142));
        jTable3.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable3.setShowVerticalLines(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setResizable(false);
            jTable3.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel4.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 510, 210));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel15.setLayout(null);

        pnlLabel.setBackground(new java.awt.Color(255, 102, 102));
        pnlLabel.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        pnlLabel.setForeground(new java.awt.Color(120, 222, 123));
        pnlLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLabelMouseExited(evt);
            }
        });
        jPanel15.add(pnlLabel);
        pnlLabel.setBounds(140, 0, 90, 29);

        pnlStatus.setBackground(new java.awt.Color(255, 102, 102));
        pnlStatus.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        pnlStatus.setForeground(new java.awt.Color(0, 255, 153));
        pnlStatus.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlStatus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlStatusMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlStatusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlStatusMouseExited(evt);
            }
        });
        jPanel15.add(pnlStatus);
        pnlStatus.setBounds(80, 0, 59, 29);

        jPanel4.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 230, 30));

        jTabbedPane1.addTab("  Monthly  ", jPanel4);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel8MouseEntered(evt);
            }
        });
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setBackground(new java.awt.Color(226, 185, 130));
        jPanel13.setLayout(null);

        alert2.setBackground(new java.awt.Color(226, 185, 130));
        alert2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        alert2.setForeground(new java.awt.Color(51, 51, 51));
        alert2.setText("Please Select a Invoice To view the items");
        alert2.setBorder(null);
        alert2.setBorderPainted(false);
        alert2.setContentAreaFilled(false);
        alert2.setFocusPainted(false);
        alert2.setOpaque(true);
        jPanel13.add(alert2);
        alert2.setBounds(0, 0, 370, 530);

        jPanel14.setBackground(new java.awt.Color(226, 185, 130));
        jPanel14.setDoubleBuffered(false);
        jPanel14.setEnabled(false);
        jPanel14.setFocusable(false);

        jScrollPane7.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        products4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        products4.setForeground(new java.awt.Color(69, 69, 69));
        products4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "QUANTITY", "AMOUNT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        products4.setEnabled(false);
        products4.setFocusable(false);
        products4.setGridColor(new java.awt.Color(255, 255, 255));
        products4.setIntercellSpacing(new java.awt.Dimension(0, 0));
        products4.setOpaque(false);
        products4.setRequestFocusEnabled(false);
        products4.setRowHeight(28);
        products4.setRowSelectionAllowed(false);
        products4.setSelectionBackground(new java.awt.Color(222, 191, 142));
        products4.setSelectionForeground(new java.awt.Color(0, 0, 0));
        products4.setShowVerticalLines(false);
        products4.getTableHeader().setReorderingAllowed(false);
        products4.setUpdateSelectionOnSort(false);
        products4.setVerifyInputWhenFocusTarget(false);
        products4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                products4MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(products4);
        if (products4.getColumnModel().getColumnCount() > 0) {
            products4.getColumnModel().getColumn(0).setResizable(false);
            products4.getColumnModel().getColumn(1).setResizable(false);
            products4.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel5.setBackground(new java.awt.Color(247, 215, 142));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/purchase-order.png"))); // NOI18N
        jLabel14.setText("TOTAL AMOUNT :");

        totalAmountField1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        totalAmountField1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        totalAmountField1.setText("amount");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalAmountField1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalAmountField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 370, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.add(jPanel14);
        jPanel14.setBounds(0, 70, 370, 460);

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 530));

        jScrollPane4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        jTable2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        jTable2.setForeground(new java.awt.Color(69, 69, 69));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "INVOICE ID", "PAYMENT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setFocusable(false);
        jTable2.setGridColor(new java.awt.Color(255, 255, 255));
        jTable2.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable2.setRowHeight(28);
        jTable2.setSelectionBackground(new java.awt.Color(222, 191, 142));
        jTable2.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jTable2.setShowVerticalLines(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);
        if (jTable2.getColumnModel().getColumnCount() > 0) {
            jTable2.getColumnModel().getColumn(0).setResizable(false);
            jTable2.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel8.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, 510, 210));

        yearFieldSection.setFont(new java.awt.Font("Segoe UI Semibold", 0, 10)); // NOI18N
        yearFieldSection.setForeground(new java.awt.Color(153, 153, 153));
        yearFieldSection.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearFieldSection.setText("Please Enter the Sales Year");
        yearFieldSection.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 0, new java.awt.Color(164, 142, 109)));
        yearFieldSection.setCaretColor(new java.awt.Color(255, 255, 255));
        yearFieldSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                yearFieldSectionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                yearFieldSectionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                yearFieldSectionMouseExited(evt);
            }
        });
        jPanel8.add(yearFieldSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, 240, 30));

        jButton4.setBackground(new java.awt.Color(222, 191, 142));
        jButton4.setFont(new java.awt.Font("Segoe UI Semibold", 1, 11)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setText("SEARCH");
        jButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 1, new java.awt.Color(184, 156, 118)));
        jButton4.setContentAreaFilled(false);
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.setFocusPainted(false);
        jButton4.setOpaque(true);
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton4MouseExited(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 260, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Rs. 0.00");
        jPanel8.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 390, 70));

        jLabel16.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel16.setText("Sales For The Year :");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 60, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel17.setText("None");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 60, 50, -1));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel16.setLayout(null);

        pnlLabel1.setBackground(new java.awt.Color(255, 102, 102));
        pnlLabel1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        pnlLabel1.setForeground(new java.awt.Color(120, 222, 123));
        pnlLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlLabel1MouseExited(evt);
            }
        });
        jPanel16.add(pnlLabel1);
        pnlLabel1.setBounds(140, 0, 90, 29);

        pnlStatus1.setBackground(new java.awt.Color(255, 102, 102));
        pnlStatus1.setFont(new java.awt.Font("Yu Gothic UI", 1, 14)); // NOI18N
        pnlStatus1.setForeground(new java.awt.Color(0, 255, 153));
        pnlStatus1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        pnlStatus1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlStatus1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlStatus1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlStatus1MouseExited(evt);
            }
        });
        jPanel16.add(pnlStatus1);
        pnlStatus1.setBounds(80, 0, 59, 29);

        jPanel8.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 230, 30));

        jTabbedPane1.addTab("   Yearly   ", jPanel8);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 940, 560));

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

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText(null);
        jTextField1.setCaretColor(new Color(0, 0, 0));
        jTextField1.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseEntered

    }//GEN-LAST:event_jTextField1MouseEntered

    private void jTextField1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseExited

    }//GEN-LAST:event_jTextField1MouseExited

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited

    }//GEN-LAST:event_jButton1MouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        succese succeed = new succese(this, true);
        succeed.setVisible(true);
        String keyword = jTextField1.getText();

        if (keyword.equals("")) {
            adm.loadInvoiceTable(keyword, dtm);
            jLabel4.setText("None");
            jLabel1.setText("Rs. 0.00");
        } else {
            String result = adm.loadInvoiceTableDate(keyword);
            if (result.equals("error")) {
                fails f = new fails(this, true);
                f.popupstatus(result);
                f.setVisible(true);
                log.debug(result);
            }
            jLabel4.setText(result);
            String result2 = adm.loadInvoiceTableSales(keyword);
            jLabel1.setText("Rs. " + result2);
            adm.loadInvoiceTable(keyword, dtm);
        }
        date1();
        jTextField1.setCaretColor(new Color(255, 255, 255));
        jTextField1.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        alert.setVisible(false);
        int row = jTable1.getSelectedRow();
        Object o1 = jTable1.getValueAt(row, 0);
        String invid = String.valueOf(o1);
        adm.loadInvoiceItemTable(invid, dtm4);
        int rowscount = products.getRowCount();
        double sum = 0;
        for (int i = 0; i < rowscount; i++) {
            sum = sum + Double.parseDouble(products.getValueAt(i, 2).toString());
        }
        totalAmountField.setText("Rs. " + sum);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int status2 = statusField.getSelectedIndex();
         monthlyYear = jTextField2.getText();
        String result1 = adm.loadInvoiceTableYear(monthlyYear);

        if (result1.contains(monthlyYear)) {
            succese succeed = new succese(this, true);
            succeed.setVisible(true);

            if (status2 == 0) {
                month = "January";
            } else if (status2 == 1) {
                month = "February";
            } else if (status2 == 2) {
                month = "March";
            } else if (status2 == 3) {
                month = "April";
            } else if (status2 == 4) {
                month = "May";
            } else if (status2 == 5) {
                month = "June";
            } else if (status2 == 6) {
                month = "July";
            } else if (status2 == 7) {
                month = "August";
            } else if (status2 == 8) {
                month = "September";
            } else if (status2 == 9) {
                month = "October";
            } else if (status2 == 10) {
                month = "November";
            } else if (status2 == 11) {
                month = "December";
            } else if (status2 == 12) {
                month = "";
            }

            String pnl=adm.getMonthlyProfitOrLoss(month,monthlyYear);
            if(pnl.equals("")){
                String cal="Profit / Loss Calculation error";
              fails f = new fails(this, true);
                f.popupstatus(cal);
                f.setVisible(true);
                log.debug(cal);
            }else if(pnl.contains("-")){
                pnlStatus.setText("Loss :");
                pnlLabel.setText("Rs. "+pnl);
                pnlStatus.setForeground(new Color(255,102,102));
                pnlLabel.setForeground(new Color(255,102,102));
            }else{
                pnlStatus.setText("Profit :");
                pnlLabel.setText("Rs. "+pnl);
                pnlStatus.setForeground(new Color(132,234,185));
                pnlLabel.setForeground(new Color(132,234,185));
            }
            
            String result = adm.loadInvoiceTableMonth(month);
            if (result.equals("error")) {
                fails f = new fails(this, true);
                f.popupstatus(result);
                f.setVisible(true);
                log.debug(result);
                jLabel8.setText("None");
                jLabel13.setText("Rs. 0.00");

            } else if (result.equals("")) {
                String monthout = "invalid month";
                jLabel8.setText("None");
                jLabel13.setText("Rs. 0.00");
                fails f = new fails(this, true);
                f.popupstatus(monthout);
                f.setVisible(true);
                log.debug(result);
            } else {
                jLabel8.setText(result);
                String result2 = adm.loadInvoiceTableSales2(month,monthlyYear);
                if (result2.equals("no value")) {
                    jLabel13.setText("Rs. 0.00");
                }
                jLabel13.setText("Rs. " + result2);
            }
            adm.loadInvoiceTableMonth(month, dtm3);
            statusField.setSelectedIndex(12);
        } else {
            String year2 = "year";
            fails f2 = new fails(this, true);
            f2.popupstatus(year2);
            f2.setVisible(true);
            log.debug(year2);

        }
        date1();
        jTextField2.setCaretColor(new Color(255, 255, 255));
        jTextField2.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void statusFieldItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_statusFieldItemStateChanged

    }//GEN-LAST:event_statusFieldItemStateChanged

    private void statusFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusFieldActionPerformed

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        jTextField2.setText(null);
        jTextField2.setCaretColor(new Color(0, 0, 0));
        jTextField2.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jTextField2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseEntered

    private void jTextField2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseExited

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        alert.setVisible(true);
        jLabel4.setText("None");
        jLabel1.setText("Rs. 0.00");
    }//GEN-LAST:event_jPanel2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        alert1.setVisible(false);
        int row = jTable3.getSelectedRow();
        Object o1 = jTable3.getValueAt(row, 0);
        String invid = String.valueOf(o1);
        adm.loadInvoiceItemTable(invid, dtm5);
        int rowscount = products2.getRowCount();
        double sum = 0;
        for (int i = 0; i < rowscount; i++) {
            sum = sum + Double.parseDouble(products2.getValueAt(i, 2).toString());
        }
        totalAmountField2.setText("Rs. " + sum);

    }//GEN-LAST:event_jTable3MouseClicked

    private void products2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_products2MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        alert1.setVisible(true);
        jLabel8.setText("None");
        jLabel13.setText("Rs. 0.00");
        pnlStatus.setText("");
        pnlLabel.setText("");
    }//GEN-LAST:event_jPanel4MouseClicked

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2MouseEntered

    private void products4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_products4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_products4MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        alert2.setVisible(false);
        int row = jTable2.getSelectedRow();
        Object o1 = jTable2.getValueAt(row, 0);
        String invid = String.valueOf(o1);
        adm.loadInvoiceItemTable(invid, dtm6);
        int rowscount = products4.getRowCount();
        double sum = 0;
        for (int i = 0; i < rowscount; i++) {
            sum = sum + Double.parseDouble(products4.getValueAt(i, 2).toString());
        }
        totalAmountField1.setText("Rs. " + sum);

    }//GEN-LAST:event_jTable2MouseClicked

    private void yearFieldSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearFieldSectionMouseClicked
        yearFieldSection.setText(null);
        yearFieldSection.setCaretColor(new Color(0, 0, 0));
        yearFieldSection.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_yearFieldSectionMouseClicked

    private void yearFieldSectionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearFieldSectionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldSectionMouseEntered

    private void yearFieldSectionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_yearFieldSectionMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldSectionMouseExited

    private void jButton4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseExited

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         year = yearFieldSection.getText();
        String yearResult = adm.loadInvoiceTableYear2(year);

        if (yearResult.contains(year)) {
            succese succeed = new succese(this, true);
            succeed.setVisible(true);
            jLabel17.setText(year);
            String amount=adm.loadInvoiceYearSalesTable(year);
            jLabel6.setText("Rs. " + amount);

                 String pnl=adm.getYearlyProfitOrLoss(year);
            if(pnl.equals("")){
                String cal="calculate error";
              fails f = new fails(this, true);
                f.popupstatus(cal);
                f.setVisible(true);
                log.debug(cal);
            }else if(pnl.contains("-")){
                pnlStatus1.setText("Loss :");
                pnlLabel1.setText("Rs. "+pnl);
                pnlStatus1.setForeground(new Color(255,102,102));
                pnlLabel1.setForeground(new Color(255,102,102));
            }else{
                pnlStatus1.setText("Profit :");
                pnlLabel1.setText("Rs. "+pnl);
                pnlStatus1.setForeground(new Color(132,234,185));
                pnlLabel1.setForeground(new Color(132,234,185));
            }
            
            adm.loadsalesYear(monthlyYear, dtm2);
        } else {
            String years = "year";
            fails f2 = new fails(this, true);
            f2.popupstatus(years);
            f2.setVisible(true);
            log.debug(years);
        }
//        year();
        yearFieldSection.setText("Please Enter The Sales Year");
        yearFieldSection.setCaretColor(new Color(255, 255, 255));
        yearFieldSection.setForeground(new Color(153, 153, 153));
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        alert2.setVisible(true);
        jLabel17.setText("None");
        jLabel6.setText("Rs. 0.00");
        pnlStatus1.setText("");
        pnlLabel1.setText("");
        adm.loadInvoiceTable("", dtm2);
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel8MouseEntered

    private void productsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_productsMouseClicked

    private void pnlLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabelMouseEntered
        String status=pnlStatus.getText();
        if(status.equals("Profit :")){
        pnlStatus.setForeground(new Color(23,153,101));
        pnlLabel.setForeground(new Color(23,153,101));
        }else if(status.equals("Loss :")){
        pnlStatus.setForeground(new Color(243,88,88));
        pnlLabel.setForeground(new Color(243,88,88));
        }
    }//GEN-LAST:event_pnlLabelMouseEntered

    private void pnlStatusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatusMouseEntered
            String status=pnlStatus.getText();
        if(status.equals("Profit :")){
                pnlStatus.setForeground(new Color(0,255,153));
                pnlLabel.setForeground(new Color(0,255,153));
        }else if(status.equals("Loss :")){
                pnlStatus.setForeground(new Color(255,102,102));
                pnlLabel.setForeground(new Color(255,102,102));
        }
    }//GEN-LAST:event_pnlStatusMouseEntered

    private void pnlLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabelMouseExited
                 String status=pnlStatus.getText();
        if(status.equals("Profit :")){
                pnlStatus.setForeground(new Color(132,234,185));
                pnlLabel.setForeground(new Color(132,234,185));
        }else if(status.equals("Loss :")){
                pnlStatus.setForeground(new Color(255,102,102));
                pnlLabel.setForeground(new Color(255,102,102));
        }
    }//GEN-LAST:event_pnlLabelMouseExited

    private void pnlStatusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatusMouseExited
                   String status=pnlStatus.getText();
        if(status.equals("Profit :")){
        pnlStatus.setForeground(new Color(143,236,199));
        pnlLabel.setForeground(new Color(143,236,199));
        }else if(status.equals("Loss :")){
        pnlStatus.setForeground(new Color(243,88,88));
        pnlLabel.setForeground(new Color(243,88,88));
        }
    }//GEN-LAST:event_pnlStatusMouseExited

    private void pnlLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabel1MouseEntered
           String status=pnlStatus1.getText();
        if(status.equals("Profit :")){
        pnlStatus1.setForeground(new Color(23,153,101));
        pnlLabel1.setForeground(new Color(23,153,101));
        }else if(status.equals("Loss :")){
        pnlStatus1.setForeground(new Color(243,88,88));
        pnlLabel1.setForeground(new Color(243,88,88));
        }
    }//GEN-LAST:event_pnlLabel1MouseEntered

    private void pnlLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabel1MouseExited
                 String status=pnlStatus1.getText();
        if(status.equals("Profit :")){
                pnlStatus1.setForeground(new Color(132,234,185));
                pnlLabel1.setForeground(new Color(132,234,185));
        }else if(status.equals("Loss :")){
                pnlStatus1.setForeground(new Color(255,102,102));
                pnlLabel1.setForeground(new Color(255,102,102));
        }
    }//GEN-LAST:event_pnlLabel1MouseExited

    private void pnlStatus1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatus1MouseEntered
        String status=pnlStatus1.getText();
        if(status.equals("Profit :")){
                pnlStatus1.setForeground(new Color(0,255,153));
                pnlLabel1.setForeground(new Color(0,255,153));
        }else if(status.equals("Loss :")){
                pnlStatus1.setForeground(new Color(255,102,102));
                pnlLabel1.setForeground(new Color(255,102,102));
        }
    }//GEN-LAST:event_pnlStatus1MouseEntered

    private void pnlStatus1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatus1MouseExited
                 String status=pnlStatus1.getText();
        if(status.equals("Profit :")){
                pnlStatus1.setForeground(new Color(132,234,185));
                pnlLabel1.setForeground(new Color(132,234,185));
        }else if(status.equals("Loss :")){
                pnlStatus1.setForeground(new Color(255,102,102));
                pnlLabel1.setForeground(new Color(255,102,102));
        }
    }//GEN-LAST:event_pnlStatus1MouseExited

    private void pnlLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabelMouseClicked
 sales.profit_and_loss pnl=new sales.profit_and_loss(this,true);

String electricity=adm.calculateElectricityExpenses(month, monthlyYear);
String water=adm.calculateWaterExpenses(month, monthlyYear);
String product=adm.calculateProductsExpenses(month, monthlyYear);
String staff=adm.calculateStaffExpenses(month, monthlyYear);
String income=adm.calculateIncome(month, monthlyYear);
pnl.ElectricityValueLabel.setText("Rs. "+electricity);
pnl.WaterValueLabel.setText("Rs. "+water);
pnl.productsValueLabel.setText("Rs. "+product);
pnl.staffValueLabel.setText("Rs. "+staff);
pnl.incomeValueLabel.setText("Rs. "+income);
pnl.totalIncome.setText("Rs. "+income);
pnl.incomeValue.setText("Rs. "+income);

double delectricity=Double.parseDouble(electricity);
double dwater=Double.parseDouble(water);
double dproduct=Double.parseDouble(product);
double dstaff=Double.parseDouble(staff);

double expensetotal=delectricity+dwater+dproduct+dstaff;
String castedexpensesTotal=String.valueOf(expensetotal);
pnl.expenseTotal.setText("Rs. "+castedexpensesTotal);
pnl.expenseValue.setText("Rs. "+castedexpensesTotal);


double newincome=Double.parseDouble(income);

double newTotal=newincome-expensetotal;
String castedNewTotal=String.valueOf(newTotal);
pnl.displayingValue.setText("Rs. "+castedNewTotal);

  String checker=pnlLabel.getText();
        if(checker.contains("-")){
       pnl.jPanel2.setBackground(new Color(255,102,102));    
       pnl.jPanel5.setBackground(new Color(253,163,163));    
        pnl.jPanel6.setBackground(new Color(253,163,163));    
            }else{
        pnl.jPanel2.setBackground(new Color(115,255,199));    
        pnl.jPanel5.setBackground(new Color(191,254,229));    
        pnl.jPanel6.setBackground(new Color(191,254,229));    
        }

pnl.setVisible(true);
    }//GEN-LAST:event_pnlLabelMouseClicked

    private void pnlLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlLabel1MouseClicked
     sales.profit_and_loss pnl=new sales.profit_and_loss(this,true);
        String electricity=adm.calculateElectricityExpensesyearly(year);
String water=adm.calculateWaterExpensesyearly(year);
String product=adm.calculateProductsExpensesyearly(year);
String staff=adm.calculateStaffExpensesyearly(year);
String income=adm.calculateIncomeyearly(year);
pnl.ElectricityValueLabel.setText("Rs. "+electricity);
pnl.WaterValueLabel.setText("Rs. "+water);
pnl.productsValueLabel.setText("Rs. "+product);
pnl.staffValueLabel.setText("Rs. "+staff);
pnl.incomeValueLabel.setText("Rs. "+income);
pnl.totalIncome.setText("Rs. "+income);
pnl.incomeValue.setText("Rs. "+income);

double delectricity=Double.parseDouble(electricity);
double dwater=Double.parseDouble(water);
double dproduct=Double.parseDouble(product);
double dstaff=Double.parseDouble(staff);

double expensetotal=delectricity+dwater+dproduct+dstaff;
String castedexpensesTotal=String.valueOf(expensetotal);
pnl.expenseTotal.setText("Rs. "+castedexpensesTotal);
pnl.expenseValue.setText("Rs. "+castedexpensesTotal);


double newincome=Double.parseDouble(income);

double newTotal=newincome-expensetotal;
String castedNewTotal=String.valueOf(newTotal);
pnl.displayingValue.setText("Rs. "+castedNewTotal);

  String checker=pnlLabel1.getText();
        if(checker.contains("-")){
       pnl.jPanel2.setBackground(new Color(255,102,102));    
       pnl.jPanel5.setBackground(new Color(253,163,163));    
        pnl.jPanel6.setBackground(new Color(253,163,163));    
            }else{
        pnl.jPanel2.setBackground(new Color(115,255,199));    
        pnl.jPanel5.setBackground(new Color(191,254,229));    
        pnl.jPanel6.setBackground(new Color(191,254,229));    
        }

pnl.setVisible(true);
    }//GEN-LAST:event_pnlLabel1MouseClicked

    private void pnlStatusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatusMouseClicked
       sales.profit_and_loss pnl=new sales.profit_and_loss(this,true);

String electricity=adm.calculateElectricityExpenses(month, monthlyYear);
String water=adm.calculateWaterExpenses(month, monthlyYear);
String product=adm.calculateProductsExpenses(month, monthlyYear);
String staff=adm.calculateStaffExpenses(month, monthlyYear);
String income=adm.calculateIncome(month, monthlyYear);
pnl.ElectricityValueLabel.setText("Rs. "+electricity);
pnl.WaterValueLabel.setText("Rs. "+water);
pnl.productsValueLabel.setText("Rs. "+product);
pnl.staffValueLabel.setText("Rs. "+staff);
pnl.incomeValueLabel.setText("Rs. "+income);
pnl.totalIncome.setText("Rs. "+income);
pnl.incomeValue.setText("Rs. "+income);

double delectricity=Double.parseDouble(electricity);
double dwater=Double.parseDouble(water);
double dproduct=Double.parseDouble(product);
double dstaff=Double.parseDouble(staff);

double expensetotal=delectricity+dwater+dproduct+dstaff;
String castedexpensesTotal=String.valueOf(expensetotal);
pnl.expenseTotal.setText("Rs. "+castedexpensesTotal);
pnl.expenseValue.setText("Rs. "+castedexpensesTotal);


double newincome=Double.parseDouble(income);

double newTotal=newincome-expensetotal;
String castedNewTotal=String.valueOf(newTotal);
pnl.displayingValue.setText("Rs. "+castedNewTotal);

  String checker=pnlLabel.getText();
        if(checker.contains("-")){
       pnl.jPanel2.setBackground(new Color(255,102,102));    
       pnl.jPanel5.setBackground(new Color(253,163,163));    
        pnl.jPanel6.setBackground(new Color(253,163,163));    
            }else{
        pnl.jPanel2.setBackground(new Color(115,255,199));    
        pnl.jPanel5.setBackground(new Color(191,254,229));    
        pnl.jPanel6.setBackground(new Color(191,254,229));    
        }

pnl.setVisible(true);
    }//GEN-LAST:event_pnlStatusMouseClicked

    private void pnlStatus1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlStatus1MouseClicked
         sales.profit_and_loss pnl=new sales.profit_and_loss(this,true);
        String electricity=adm.calculateElectricityExpensesyearly(year);
String water=adm.calculateWaterExpensesyearly(year);
String product=adm.calculateProductsExpensesyearly(year);
String staff=adm.calculateStaffExpensesyearly(year);
String income=adm.calculateIncomeyearly(year);
pnl.ElectricityValueLabel.setText("Rs. "+electricity);
pnl.WaterValueLabel.setText("Rs. "+water);
pnl.productsValueLabel.setText("Rs. "+product);
pnl.staffValueLabel.setText("Rs. "+staff);
pnl.incomeValueLabel.setText("Rs. "+income);
pnl.totalIncome.setText("Rs. "+income);
pnl.incomeValue.setText("Rs. "+income);

double delectricity=Double.parseDouble(electricity);
double dwater=Double.parseDouble(water);
double dproduct=Double.parseDouble(product);
double dstaff=Double.parseDouble(staff);

double expensetotal=delectricity+dwater+dproduct+dstaff;
String castedexpensesTotal=String.valueOf(expensetotal);
pnl.expenseTotal.setText("Rs. "+castedexpensesTotal);
pnl.expenseValue.setText("Rs. "+castedexpensesTotal);


double newincome=Double.parseDouble(income);

double newTotal=newincome-expensetotal;
String castedNewTotal=String.valueOf(newTotal);
pnl.displayingValue.setText("Rs. "+castedNewTotal);
  String checker=pnlLabel1.getText();
        if(checker.contains("-")){
       pnl.jPanel2.setBackground(new Color(255,102,102));    
       pnl.jPanel5.setBackground(new Color(253,163,163));    
        pnl.jPanel6.setBackground(new Color(253,163,163));    
            }else{
        pnl.jPanel2.setBackground(new Color(115,255,199));    
        pnl.jPanel5.setBackground(new Color(191,254,229));    
        pnl.jPanel6.setBackground(new Color(191,254,229));    
        }
pnl.setVisible(true);
    }//GEN-LAST:event_pnlStatus1MouseClicked

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
            java.util.logging.Logger.getLogger(view_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(view_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(view_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(view_sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new view_sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alert;
    private javax.swing.JButton alert1;
    private javax.swing.JButton alert2;
    public javax.swing.JPanel header;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    public javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel pnlLabel;
    private javax.swing.JLabel pnlLabel1;
    private javax.swing.JLabel pnlStatus;
    private javax.swing.JLabel pnlStatus1;
    private javax.swing.JTable products;
    private javax.swing.JTable products2;
    private javax.swing.JTable products4;
    private javax.swing.JComboBox<String> statusField;
    public javax.swing.JLabel title;
    public javax.swing.JLabel totalAmountField;
    public javax.swing.JLabel totalAmountField1;
    public javax.swing.JLabel totalAmountField2;
    private javax.swing.JTextField yearFieldSection;
    // End of variables declaration//GEN-END:variables
}
