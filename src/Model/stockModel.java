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
public class stockModel {
    static Logger log=Logger.getLogger(stockModel.class.getName());
    Connection conn;
    
    public stockModel(){
     conn=db.dbConnection.getConnection();
    }

    public void loadStockTable(String keyword, DefaultTableModel dtm) {
       String query="select * from stocks join product_category on stocks.id_category= product_category.id_category where category_name like '%"+keyword+"%'";
       dtm.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("idstocks");
            String category=rs.getString("category_name");
            String catid=rs.getString("id_category");
            String Qty=loadTotalStocks(catid);
            
            dataRow=new String[3];
            dataRow[0]=id;
            dataRow[1]=category;
            dataRow[2]=Qty;
            dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }
//
//    public void loadStockTable(String keyword, DefaultTableModel dtm) {
//       String query="select * from stocks join product_category on stocks.id_category= product_category.id_category where category_name like '%"+keyword+"%'";
//       dtm.setRowCount(0);
//        try {
//            Statement stm=conn.createStatement();
//            ResultSet rs=stm.executeQuery(query);
//            String[] dataRow;
//            while(rs.next()){
//            String id=rs.getString("idstocks");
//            String qty=rs.getString("stock_qty");
//            String category=rs.getString("category_name");
//            
//            int updatedQty=Integer.parseInt(updatedqty);
//            int defaultqty=Integer.parseInt(qty);
//            int calculatedQty=updatedQty - defaultqty;
//            int actualQty=calculatedQty+updatedQty;
//            
//            String Qty=String.valueOf(actualQty);
//            dataRow=new String[3];
//            dataRow[0]=id;
//            dataRow[1]=category;
//            dataRow[2]=Qty;
//            dtm.addRow(dataRow);
//            }
//        } catch (Exception e) {
//        e.printStackTrace();
//        }
//    }

    

 public void loadCategoryTable(String string, DefaultTableModel dtm2) {
        String query="select * from product_category where category_name LIKE '%"+string+"%'";
        dtm2.setRowCount(0);
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
            dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
    }

 
 
 
    public String loadTotalStocks(String s1) {
     String msg="";
     String query="select SUM(avl_qty) from products where id_category='"+s1+"'";
     try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            while(rs.next()){
           int avl_qty= rs.getInt("SUM(avl_qty)");
           String avl_msg_qty=String.valueOf(avl_qty);
                msg=avl_msg_qty;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }   
     return msg;
    }

    
                          
    public String stock_reg(String name, String stocks) {
      String msg="";
     String query="insert into stocks(stock_qty,id_category)values(?,?)";
     try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,stocks);
            psm.setString(2,name);
            psm.execute();
            msg="stock added succesfully";
            }
         catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="stock adding error";
        }   
     return msg;
    }

    public String stock_update(String id, String name, String stocks) {
        String msg="";
     String query="update stocks set stock_qty=?,id_category=? where idstocks=?";
     try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,stocks);
            psm.setString(2,name);
            psm.setString(3,id);
            psm.execute();
            msg="stock updating succesfully";
            }
         catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="stock updating error";
        }   
     return msg;
    }

    public String getCategoryID(String name) {
       String msg="";
       String query="select id_category from product_category where category_name ='"+name+"'";
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String id=rs.getString("id_category");
            msg=id;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
       
       return msg;
    }
}
 
