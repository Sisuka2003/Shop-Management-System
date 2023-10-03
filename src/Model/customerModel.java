/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.customer_section.add_customer;
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
public class customerModel {

    static Logger log = Logger.getLogger(customerModel.class.getName());
    Connection conn;

    public customerModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadCustomerTable(String string, DefaultTableModel dtm) {
        String query = "select * from customer where mobile like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_customer");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String mobile = rs.getString("mobile");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = fname;
                dataRow[2] = lname;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadCustomerTableLname(String string, DefaultTableModel dtm) {
        String query = "select * from customer where last_name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_customer");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String mobile = rs.getString("mobile");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = fname;
                dataRow[2] = lname;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadCustomerTableFname(String string, DefaultTableModel dtm) {
        String query = "select * from customer where first_name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_customer");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String mobile = rs.getString("mobile");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = fname;
                dataRow[2] = lname;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String customer_reg(String fname, String lname, String mobile) {
//       customer added error
//customer added successfully
        String msg = "";
        String query = "insert into customer(first_name,last_name,mobile)values(?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, fname);
            psm.setString(2, lname);
            psm.setString(3, mobile);
            psm.execute();
            msg = "customer added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "  customer added error";
        }
        return msg;
    }

    public String customer_update(String id, String fname, String lname, String mobile) {
//      customer updated successfully
//customer updated error
        String msg = "";
        String query = "update customer set first_name=?,last_name=?,mobile=? where id_customer =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, fname);
            psm.setString(2, lname);
            psm.setString(3, mobile);
            psm.setString(4, id);
            psm.execute();
            msg = "customer updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "customer updated error";
        }
        return msg;
    }

    public String customer_delete(String id) {
//      customer deleted successfully
//customer deleted error
       String msg = "";
        String query = "delete from customer where id_customer =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg = "customer deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "customer deleted error";
        }
        return msg;
    }

}
