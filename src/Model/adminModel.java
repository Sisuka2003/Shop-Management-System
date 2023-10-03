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
public class adminModel {
    
    static Logger log = Logger.getLogger(adminModel.class.getName());
    Connection conn;

    public adminModel() {
        conn = db.dbConnection.getConnection();
    }
    

    public void loadAdminTable(String keyword, DefaultTableModel dtm) {
      String query="select id,username,password,role_name from shop_admins join staff_job_role on shop_admins.id_role = staff_job_role.id_role WHERE staff_job_role.role_name LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Connection connection=db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String adminid= rs.getString("id");
            String name=rs.getString("username");
            String pswd=rs.getString("password");
           String role= rs.getString("role_name");
             dataRow = new String[4];
             dataRow[0] = adminid;
             dataRow[1] = name;
             dataRow[2] = pswd;
             dataRow[3] = role;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }


    public void loadJobRoleTable(String keyword, DefaultTableModel dtm2) {
           String query="select * from staff_job_role WHERE staff_job_role.role_name LIKE '%"+keyword+"%'";
      dtm2.setRowCount(0);
        try {
            Connection connection=db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String roleid= rs.getString("id_role");
           String role= rs.getString("role_name");
             dataRow = new String[2];
             dataRow[0] = roleid;
             dataRow[1] = role;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }   
    }
    
    public String getJobId(String s4) {
     String msg="";
     String query="SELECT id_role FROM staff_job_role where role_name LIKE '%"+s4+"%'";
       try {
            Connection connection=db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs= stm.executeQuery(query);
            while(rs.next()){
           String roleid= rs.getString("id_role");
            msg=roleid;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }   
       return msg;
    }
    
    
    
    public String admin_register(String name, String pswd, String job) {
      String msg="";
      String query="INSERT INTO shop_admins(username,password,id_role)VALUES(?,?,?)";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            
            psm.setString(1,name);
            psm.setString(2,pswd);
            psm.setString(3,job);
            psm.execute();
            msg="admin added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="admin adding error";
        }
      return msg;
    }

    public String admin_update(String id,String name, String pswd, String job) {
     String msg="";
     String query="update shop_admins SET username=? , password=?, id_role =? WHERE id=?";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, pswd);
            psm.setString(3, job);
            psm.setString(4, id);
            psm.execute();
            msg="admin updated succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="admin updating error";
        }
        return msg;
    }

    public String admin_delete(String id) {
     String msg="";
     String query="delete FROM shop_admins WHERE id =? ";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="admin deleted succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="admin deleting error";
        }
        return msg;
    }

}
