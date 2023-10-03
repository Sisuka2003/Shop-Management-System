/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.cj.xdevapi.PreparableStatement;
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
public class orderModel {
static Logger log=Logger.getLogger(orderModel.class.getName());
    Connection conn;
    String productId;
    String order;
    
               
    public orderModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadOrderTable(String string, DefaultTableModel dtm) {
        String query = "select * from purchase_order join products on products.id_products=purchase_order.products_id_products join orders on purchase_order.idorders = orders.idorders where orders.idorders = '" + string + "'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_product_order");
                String name = rs.getString("purchase_order.product_name");
                String compname = rs.getString("company_name");
                String qty = rs.getString("qty");
                String uprice = rs.getString("unit_price");
                String order_id = rs.getString("idOrders");
                String amount = rs.getString("total_amount");
                productId = rs.getString("products_id_products");
                dataRow = new String[7];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = compname;
                dataRow[3] = qty;
                dataRow[4] = uprice;
                dataRow[5] = order_id;
                dataRow[6] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadOrderTableOnPname(String string, DefaultTableModel dtm) {
        String query = "select * from purchase_order join products on products.id_products=purchase_order.products_id_products join orders on purchase_order.idorders = orders.idorders where purchase_order.product_name LIKE '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_product_order");
                String name = rs.getString("purchase_order.product_name");
                String compname = rs.getString("company_name");
                String qty = rs.getString("qty");
                String uprice = rs.getString("unit_price");
                String order_id = rs.getString("idOrders");
                String amount = rs.getString("total_amount");
                productId = rs.getString("products_id_products");
                dataRow = new String[7];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = compname;
                dataRow[3] = qty;
                dataRow[4] = uprice;
                dataRow[5] = order_id;
                dataRow[6] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
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
                String qty = rs.getString("avl_qty");
                String catergory = rs.getString("category_name");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = price;
                dataRow[3] = qty;
                dataRow[4] = catergory;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String order_reg(String oid,String id, String company, String qty, String uprice, String castedAmount, String name) {
        String msg = "";
        String query = "insert into purchase_order(product_name,company_name,qty,unit_price,total_amount,products_id_products,idorders)values(?,?,?,?,?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);  //product name
            psm.setString(2, company); //company name
            psm.setString(3, qty); // qty
            psm.setString(4, uprice);//unit price
            psm.setString(5, castedAmount);//total_amount
            psm.setString(6, id);//product id
            psm.setString(7, oid);//order id
            psm.execute();
            msg = "order added succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "order adding error";
        }
        return msg;
    }

    public String getProductName(String id) {
        String msg = "";
        String query = "select * from products where id_products='" + id + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String pid = rs.getString("product_name");
                msg = pid;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String order_update(String po, String oid,String pname, String company, String qty, String uprice, String castedAmount, String name) {
        String msg = "";
        String query = "update purchase_order set product_name=?,company_name=?,qty=?,unit_price=?,total_amount=?,products_id_products=?,idorders=? where id_product_order=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, name);
            psm.setString(2, company);
            psm.setString(3, qty);
            psm.setString(4, uprice);
            psm.setString(5, castedAmount);
            psm.setString(6, pname);
            psm.setString(7, oid);
            psm.setString(8, po);
            psm.execute();
            msg = "order updating succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "order updating error";
        }
        return msg;
    }

    
    
    public String getProductId(String name) {
        String msg = "";
        String query = "select * from purchase_order where product_name='" + name + "'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("products_id_products");
                msg = id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String order_delete(String oid) {
            String msg = "";
        String query = "delete from purchase_order where id_product_order=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, oid);
            psm.execute();
            msg = "order deleting succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "order deleting error";
        }
        return msg;
    }

    public void loadOrderIdTable(String string, DefaultTableModel dtm) {
       String query = "select * from orders where date like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("idorders");
                String date = rs.getString("date");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] =date;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String orderid_reg(String date) {
        String msg="";
        String query="insert into orders(date)values(?)";
        
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,date);
            psm.execute();
            msg="order id added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="order id adding error";
        }
        return msg;
    }

    public String orderid_update(String id, String date) {
        String msg="";
        String query="update orders set date=? where idorders=?";
        
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,date);
            psm.setString(2,id);
            psm.execute();
            msg="order id updating succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="order id updating error";
        }
        return msg;
    }

    public String orderid_delete(String id) {
       String msg="";
        String query="delete from orders where idorders=?";
        
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="order id deleted succesfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="order id deleted error";
        }
        return msg;
    }

    public void loadOrderIDTableID(String keyword, DefaultTableModel dtm) {
         String query = "select * from orders where idorders like '%" + keyword + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("idorders");
                String date = rs.getString("date");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] =date;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadOrderedProductViewer(String orderID, DefaultTableModel dtm) {
      String query = "select * from purchase_order join orders on purchase_order.idorders = orders.idorders where orders.idorders = '" + orderID + "'";
        dtm.setRowCount(0);
        dtm.getRowCount();
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_product_order");
                String name = rs.getString("product_name");
                String compname = rs.getString("company_name");
                String qty = rs.getString("qty");
                String uprice = rs.getString("unit_price");
                String amount = rs.getString("total_amount");
                dataRow = new String[6];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = compname;
                dataRow[3] = qty;
                dataRow[4] = uprice;
                dataRow[5] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String loadTotalAmount(String orderID, DefaultTableModel dtm) {
       String msg="";
        String query="select SUM(total_amount) FROM purchase_order join orders on purchase_order.idorders = orders.idorders where orders.idorders = '" + orderID + "'";
        
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String amount=rs.getString("SUM(total_amount)");
            msg=amount;
            }
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        return  msg;
    }

    
    
    
    

    public void loadOrderedProductViewer2(String orderID, DefaultTableModel dtm) {
         String query = "select * from purchase_order join orders on purchase_order.idorders = orders.idorders where orders.idorders = '" + orderID + "'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String name = rs.getString("product_name");
                String compname = rs.getString("company_name");
                String qty = rs.getString("qty");
                String uprice = rs.getString("unit_price");
                String order_id = rs.getString("idorders");
                order=order_id;
                String amount = rs.getString("total_amount");
                dataRow = new String[6];
                dataRow[0] = name;
                dataRow[1] = compname;
                dataRow[2] = qty;
                dataRow[3] = uprice;
                dataRow[4] = order_id;
                dataRow[5] = amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
}
