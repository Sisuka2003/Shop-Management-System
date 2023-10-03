/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class waterbillPayment {
static Logger log=Logger.getLogger(waterbillPayment.class.getName());
    Connection conn;

    public waterbillPayment() {
        conn = db.dbConnection.getConnection();
    }

    public void loadWaterBillTable(String string, DefaultTableModel dtm) {
        String query = "select * from waterbill_payment where month LIKE '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("bill_id");
                String month = rs.getString("month");
                String year = rs.getString("year");
                String amount = rs.getString("amount");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = month;
                dataRow[2] = year;
                dataRow[3] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    
    public void loadWaterBillTableOnYear(String string, DefaultTableModel dtm) {
        String query = "select * from waterbill_payment where year LIKE '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("bill_id");
                String month = rs.getString("month");
                String year = rs.getString("year");
                String amount = rs.getString("amount");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = month;
                dataRow[2] = year;
                dataRow[3] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String waterbill_register(String status, String amount,String year) {
        String msg = "";
        String query = "insert into waterbill_payment(month,year,amount)values(?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, status);
            psm.setString(2, year);
            psm.setString(3, amount);
            psm.execute();
            msg = "Waterbill added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "waterbill added fail";
        }
        return msg;
    }

    public String waterbill_update(String status, String amount, String id) {
        String msg = "";
        String query = "update waterbill_payment set month=?,amount=? where bill_id=?";
        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, status);
            psm.setString(2, amount);
            psm.setString(3, id);
            psm.execute();
            msg = "Waterbill Payment update successfully";
        } catch (Exception e) {
            msg = "waterbill payment update fail";
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String waterbill_delete(String id) {
        String msg = "";
        String query = "delete from waterbill_payment where bill_id=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg = "Waterbill Payment deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "waterbill payment delete fail";
        }
        return msg;
    }

    public void priceRangerLoad(String value1,String value2, DefaultTableModel dtm2) {
        String query = "SELECT * FROM waterbill_payment WHERE amount BETWEEN '"+value1+"'  AND '"+value2+"' ";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("bill_id");
                String month = rs.getString("month");
                String year = rs.getString("year");
                String amount = rs.getString("amount");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = month;
                dataRow[2] = year;
                dataRow[3] = amount;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loader(DefaultTableModel dtm3) {
        String query = "SELECT * FROM waterbill_payment";
        dtm3.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("bill_id");
                String month = rs.getString("month");
                String amount = rs.getString("amount");
                dataRow = new String[3];
                dataRow[0] = id;
                dataRow[1] = month;
                dataRow[2] = amount;
                dtm3.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

}
