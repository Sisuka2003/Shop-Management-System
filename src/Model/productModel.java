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
public class productModel {

    static Logger log = Logger.getLogger(productModel.class.getName());
    Connection conn;

    public productModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadProductTable(String string, DefaultTableModel dtm) {
        String query = "select * from products join product_category on products.id_category=product_category.id_category where products.barcode like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_products");
                String name = rs.getString("product_name");
                String price = rs.getString("sell_price");
                String buy = rs.getString("buy_price");
                String qty = rs.getString("avl_qty");
                String catergory = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = price;
                dataRow[3] = buy;
                dataRow[4] = qty;
                dataRow[5] = catergory;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadProductTableOnCategory(String string, DefaultTableModel dtm) {
        String query = "select * from products join product_category on products.id_category=product_category.id_category where product_category.category_name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                  String id = rs.getString("id_products");
                String name = rs.getString("product_name");
                String price = rs.getString("sell_price");
                String buy = rs.getString("buy_price");
                String qty = rs.getString("avl_qty");
                String catergory = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = price;
                dataRow[3] = buy;
                dataRow[4] = qty;
                dataRow[5] = catergory;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void priceRangerLoad(String value1, String value2, DefaultTableModel dtm2) {
        String query = "SELECT * FROM products  join product_category on products.id_category = product_category.id_category WHERE products.sell_price BETWEEN '" + value1 + "'  AND '" + value2 + "' ";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                  String id = rs.getString("id_products");
                String name = rs.getString("product_name");
                String price = rs.getString("sell_price");
                String buy = rs.getString("buy_price");
                String qty = rs.getString("avl_qty");
                String catergory = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = price;
                dataRow[3] = buy;
                dataRow[4] = qty;
                dataRow[5] = catergory;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadCategoryTable(String string, DefaultTableModel dtm2) {
        String query = "select * from product_category where category_name LIKE '%" + string + "%'";
        dtm2.setRowCount(0);

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_category");
                String name = rs.getString("category_name");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] = name;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }

    }

    public String product_register(String name, String barcode, String sell, String buy, String qty, String category) {
        String msg = "";
        String query = "insert into products(product_name,barcode,sell_price,buy_price,avl_qty,id_category)VALUES(?,?,?,?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, barcode);
            psm.setString(3, sell);
            psm.setString(4, buy);
            psm.setString(5, qty);
            psm.setString(6, category);
            psm.execute();
            msg = "product added succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "product adding error";
        }
        return msg;
    }

    public String getCategoryId(String valueOf) {
        String msg = "";
        String query = "select id_category from product_category where category_name ='" + valueOf + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String catId = rs.getString("id_category");
                msg = catId;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String product_update(String id, String name, String sell, String buy, String qty, String category) {
        String msg = "";
        String query = "update products set product_name=?,sell_price=?,buy_price=?,avl_qty=?,id_category=? where id_products =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, sell);
            psm.setString(3, buy);
            psm.setString(4, qty);
            psm.setString(5, category);
            psm.setString(6, id);
            psm.execute();
            msg = "product updated succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "product updated error";
        }
        return msg;
    }

    public String product_delete(String id) {
        String msg = "";
        String query = "delete from products where id_products =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg = "product delete succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "product delete error";
        }
        return msg;
    }

    public String product_existance(String barcode) {
       String msg="no product";
       String query ="select * from products where barcode='"+barcode+"'"; 
       try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
             msg="product have";
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
       return msg;
    }

    public String loadProductData(String barcode) {
         String msg="";
        String query="select * from products where barcode = '"+barcode+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                msg="success";
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg=null;
        }
        return msg;
    }
}
