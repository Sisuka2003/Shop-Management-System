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
public class basicSalary {
static  Logger log=Logger.getLogger(basicSalary.class.getName());
    Connection conn;
    public basicSalary(){
    conn=db.dbConnection.getConnection();
    }
    
    public void loadSalaryTable(String string, DefaultTableModel dtm) {
      String query="select id_salaries,amount,role_name from staff_salaries join staff_job_role on staff_salaries.id_role = staff_job_role.id_role where staff_job_role.role_name LIKE '%"+string+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm= conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_salaries");
            String amount=rs.getString("amount");
            String role=rs.getString("role_name");
            dataRow = new String[3];
             dataRow[0] = id;
             dataRow[1] = role;
             dataRow[2] = amount;
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
            Statement stm = conn.createStatement();
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

    
    
    public String salary_register(String amount, String job) {
     String msg="";
     String query="insert into staff_salaries(amount,id_role)VALUES(?,?)";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,amount);
            psm.setString(2,job);
            psm.execute();
            msg="Basic sallary added successfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="basic salary added error";
        }
        return msg;
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

    
    
    
    public String salary_update(String id, String amount, String job) {
    String msg="";
    String query="update staff_salaries set amount=?,id_role=? where id_salaries =?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, amount);
            psm.setString(2, job);
            psm.setString(3, id);
            psm.execute();
            msg="basic salary updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg="basic salary update error";
        }
    
    return msg;
    }

    public String salary_delete(String id) {
      String msg="";
      String query="delete from staff_salaries where id_salaries =?";
      
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="basic salary deleted successfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="basic salary delete error";
        }
      return msg;
    }

    public void loadSalaryTableAmount(String keyword, DefaultTableModel dtm) {
      String query="select id_salaries,amount,role_name from staff_salaries join staff_job_role on staff_salaries.id_role = staff_job_role.id_role where staff_salaries.amount LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm= conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_salaries");
            String amount=rs.getString("amount");
            String role=rs.getString("role_name");
            dataRow = new String[3];
             dataRow[0] = id;
             dataRow[1] = role;
             dataRow[2] = amount;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
}
