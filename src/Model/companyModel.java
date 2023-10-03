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
public class companyModel {
    static Logger log=Logger.getLogger(companyModel.class.getName());
Connection conn;

public companyModel(){
conn=db.dbConnection.getConnection();
}
    
    
    public void companyTableLoad(String string, DefaultTableModel dtm) {
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

    public String company_reg(String name, String address, String contact) {
       String msg="";
       String query="insert into supplier_company(name,address,mobile_number)values(?,?,?)";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.setString(2,address);
            psm.setString(3,contact);
            psm.execute();
            msg="company added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="company adding error";
        }
       return msg;
    }

    public String company_update(String id, String name, String address, String contact) {
               String msg="";
       String query="update supplier_company set name=?,address=?,mobile_number=? where id_company=?";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.setString(2,address);
            psm.setString(3,contact);
            psm.setString(4,id);
            psm.execute();
            msg="company updated succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="company updated error";
        }
       return msg;
    }

    public String company_delete(String id) {
                  String msg="";
       String query="delete from supplier_company where id_company=?";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="company deleted succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="company deleted error";
        }
       return msg;
    }
    
}
