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
public class jobModel {
    
    static Logger log=Logger.getLogger(jobModel.class.getName());
    Connection conn;
    
    public jobModel(){
    conn=db.dbConnection.getConnection();
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

    public String job_reg(String name) {
       String msg="";
       String query="insert into staff_job_role(role_name)VALUES(?)";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.execute();
            msg="job added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="job adding error";
        }
       return msg;
    }

    public String job_update(String id, String name) {
      String msg="";
      String query="update staff_job_role set role_name=? where id_role=?";
      
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.setString(2,id);
            psm.execute();
            msg="job updated succesfully";
        } catch (Exception e) {
            e.printStackTrace();
        log.debug(e.getMessage());
            msg="job updating error";
        }
      return msg;
    }
    
    

    public String job_delete(String id) {
       String msg="";
       String query="delete from staff_job_role where id_role =?";
       
        try {
            PreparedStatement psm =conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg="job deleted succesfully";
        } catch (Exception e) {
            e.printStackTrace();
        log.debug(e.getMessage());
            msg="job deleting error";
        }
       
    return msg;
    }
}
