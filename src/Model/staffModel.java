/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.login;
import db.dbConnection;
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
public class staffModel {
    static Logger log = Logger.getLogger(staffModel.class.getName());
   
    Connection conn;
    
    public staffModel(){
     conn=db.dbConnection.getConnection();
    }
    

    public void loadStaffTable(String keyword, DefaultTableModel dtm) {
         String query="select id_staff,full_name,mobile,nic,role_name from staff join staff_job_role on staff.id_role = staff_job_role.id_role WHERE staff.full_name LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String staffid= rs.getString("id_staff");
            String name=rs.getString("full_name");
            String mobile=rs.getString("mobile");
            String nic=rs.getString("nic");
           String role= rs.getString("role_name");
             dataRow = new String[5];
             dataRow[0] = staffid;
             dataRow[1] = name;
             dataRow[2] = mobile;
             dataRow[3] = nic;
             dataRow[4] = role;
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

    
    
    public String staff_register(String name, String mob, String nic,String job) {
       String msg="";
        String query="INSERT INTO staff(full_name,mobile,nic,id_role)VALUES(?,?,?,?)";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            
            psm.setString(1,name);
            psm.setString(2,mob);
            psm.setString(3,nic);
            psm.setString(4,job);
            psm.execute();
            msg="Staff added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="Staff adding error";
        }
       return msg;
    }

    public String staff_update(String id, String name, String mob, String nic, String job) {
       String msg="";
     String query="update staff SET full_name=? , mobile=?, nic =?,id_role=? WHERE id_staff=?";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, mob);
            psm.setString(3, nic);
            psm.setString(4, job);
            psm.setString(5, id);
            psm.execute();
            msg="Staff updated succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="Staff updating error";
        }
        return msg;
    }

    public String staff_delete(String id) {
     String msg="";
     String query="delete FROM staff WHERE id_staff =? ";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="staff deleted succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="staff deleting error";
        }
        return msg;
    }

    public void loadStaffTableNIC(String keyword, DefaultTableModel dtm) {
          String query="select id_staff,full_name,mobile,nic,role_name from staff join staff_job_role on staff.id_role = staff_job_role.id_role WHERE staff.nic LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String staffid= rs.getString("id_staff");
            String name=rs.getString("full_name");
            String mobile=rs.getString("mobile");
            String nic=rs.getString("nic");
           String role= rs.getString("role_name");
             dataRow = new String[5];
             dataRow[0] = staffid;
             dataRow[1] = name;
             dataRow[2] = mobile;
             dataRow[3] = nic;
             dataRow[4] = role;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }

    public void loadStaffTableJOB(String keyword, DefaultTableModel dtm) {
          String query="select id_staff,full_name,mobile,nic,role_name from staff join staff_job_role on staff.id_role = staff_job_role.id_role WHERE staff_job_role.role_name LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String staffid= rs.getString("id_staff");
            String name=rs.getString("full_name");
            String mobile=rs.getString("mobile");
            String nic=rs.getString("nic");
           String role= rs.getString("role_name");
             dataRow = new String[5];
             dataRow[0] = staffid;
             dataRow[1] = name;
             dataRow[2] = mobile;
             dataRow[3] = nic;
             dataRow[4] = role;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }



}
