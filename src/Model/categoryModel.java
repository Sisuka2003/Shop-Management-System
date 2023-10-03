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
import org.apache.log4j.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class categoryModel {
static Logger log=Logger.getLogger(categoryModel.class.getName());
    Connection conn;

    public categoryModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadCategoryTable(String string, DefaultTableModel dtm) {
        String query="select * from product_category where category_name LIKE '%"+string+"%'";
        dtm.setRowCount(0);
        
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String [] dataRow;
            while(rs.next()){
            String id=rs.getString("id_category");
            String name=rs.getString("category_name");
            dataRow= new String[2];
            dataRow[0]=id;
            dataRow[1]=name;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
    }

    public String cat_reg(String name) {
     String msg="";
     String query="insert into product_category(category_name)values(?)";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,name);
            psm.execute();
            msg="cat added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="cat adding error";
        }
    return msg;
    }

    public String cat_update(String id,String name) {
       String msg="";
       String query="update product_category set category_name=? where id_category =?";
        try {
       PreparedStatement psm =conn.prepareStatement(query);
       psm.setString(1,name);
       psm.setString(2,id);
       psm.execute();
       msg="cat updated succesfully";     
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="cat update error";
        }
       return msg;
    }

    public String cat_delete(String id) {
        String msg="";
       String query="delete from product_category where id_category =?";
        try {
       PreparedStatement psm =conn.prepareStatement(query);
       psm.setString(1,id);
       psm.execute();
       msg="cat deleted succesfully";     
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="cat deleted error";
        }
       return msg;
    }
}
