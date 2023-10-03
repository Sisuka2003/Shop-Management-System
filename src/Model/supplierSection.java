/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.net.ConnectException;
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
public class supplierSection {
    static Logger log=Logger.getLogger(supplierSection.class.getName());
    Connection conn;
    
    public supplierSection(){
     conn=db.dbConnection.getConnection();
    }

    public void loadSupplierTable(String string, DefaultTableModel dtm) {
         String query="select * from supplier join supplier_company on supplier.id_company =supplier_company.id_company where supplier_company.name like '%"+string+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_supplier");
            String name=rs.getString("sup_name");
            String address=rs.getString("mobile_number");
            String mobile=rs.getString("name");
            dataRow = new String[4];
            dataRow[0]=id;
            dataRow[1]=name;
            dataRow[2]=address;
            dataRow[3]=mobile;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadCompanyTable(String string, DefaultTableModel dtm) {
       String query="select * from supplier_company where name like '%"+string+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_company");
            String name=rs.getString("name");
            String address=rs.getString("address");
            String mobile=rs.getString("mobile_number");
            dataRow = new String[4];
            dataRow[0]=id;
            dataRow[1]=name;
            dataRow[2]=address;
            dataRow[3]=mobile;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String supplier_reg(String name, String company, String contact) {
      String msg="";
      String query="insert into supplier(sup_name,mobile_number,id_company)values(?,?,?)";
      
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.setString(2,contact);
            psm.setString(3,company);
            psm.execute();
            msg="supplier added succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="supplier adding error";
        }
      return msg;
    }

    public String getCompanyID(String name) {
        String msg="";
     String query="SELECT id_company FROM supplier_company where name LIKE '%"+name+"%'";
       try {
            Connection connection=db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs= stm.executeQuery(query);
            while(rs.next()){
           String com_name= rs.getString("id_company");
            msg=com_name;
            }
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        }   
       return msg;
    }

    public String supplier_update(String name, String company, String number, String id) {
        String msg="";
        String query="update supplier set sup_name=?, mobile_number=?,id_company=? where id_supplier =?";
        
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.setString(2,number);
            psm.setString(3,company);
            psm.setString(4,id);
            psm.execute();
            msg="supplier updated succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="supplier update error";
        }
        
        return msg;
    }

    public String supplier_delete(String id) {
       String msg="";
       String query="delete from supplier where id_supplier =?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg="supplier delete succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="supplier delete error";
        }
        return msg;
    }

    public void loadSupplierTableName(String keyword, DefaultTableModel dtm) {
          String query="select * from supplier join supplier_company on supplier.id_company =supplier_company.id_company where supplier.sup_name like '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_supplier");
            String name=rs.getString("sup_name");
            String address=rs.getString("mobile_number");
            String mobile=rs.getString("name");
            dataRow = new String[4];
            dataRow[0]=id;
            dataRow[1]=name;
            dataRow[2]=address;
            dataRow[3]=mobile;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    

    public void loadSupplierTableMobile(String keyword, DefaultTableModel dtm) {
          String query="select * from supplier join supplier_company on supplier.id_company =supplier_company.id_company where supplier.mobile_number like '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_supplier");
            String name=rs.getString("sup_name");
            String address=rs.getString("mobile_number");
            String mobile=rs.getString("name");
            dataRow = new String[4];
            dataRow[0]=id;
            dataRow[1]=name;
            dataRow[2]=address;
            dataRow[3]=mobile;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
}
