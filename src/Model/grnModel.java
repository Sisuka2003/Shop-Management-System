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
public class grnModel {

    static Logger log=Logger.getLogger(grnModel.class.getName());
    Connection conn;

    public grnModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadSupplierTable(String string, DefaultTableModel dtm) {
        String query = "select * from supplier join supplier_company on supplier.id_company =supplier_company.id_company where supplier_company.name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_supplier");
                String name = rs.getString("sup_name");
                String address = rs.getString("mobile_number");
                String mobile = rs.getString("name");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = address;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void companyTableLoad(String string, DefaultTableModel dtm) {
        String query = "select * from supplier_company where name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_company");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String mobile = rs.getString("mobile_number");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = address;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadGrnTable(String string, DefaultTableModel dtm) {
        String query = "select * from grn join supplier on grn.id_supplier=supplier.id_supplier  join supplier_company on grn.id_company=supplier_company.id_company where grn.date like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_grn");
                String name = rs.getString("sup_name");
                String company = rs.getString("name");
                String payment = rs.getString("payment");
                String date = rs.getString("date");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = company;
                dataRow[3] = date;
                dataRow[4] = payment;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String grn_register(String date, String payment, String supplier, String company) {
        String msg = "";
        String query = "insert into grn(date,payment,id_supplier,id_company)values(?,?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, date);
            psm.setString(2, payment);
            psm.setString(3, supplier);
            psm.setString(4, company);
            psm.execute();
            msg = "GRN added Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "GRN added Failed";
        }
        return msg;
    }

    public void loadSuppilerNameRelatedCompany(String s1, DefaultTableModel dtm3) {
        String query = "select * from supplier_company join supplier on supplier_company.id_company = supplier.id_company where supplier.sup_name = '" + s1 + "'";
        dtm3.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_company");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String mobile = rs.getString("mobile_number");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = address;
                dataRow[3] = mobile;
                dtm3.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadGrnItemTable(String string, DefaultTableModel dtm2) {
        String query = "select * from grn_item join grn on grn_item.id_grn=grn.id_grn  join products on grn_item.id_products=products.id_products join product_category on products.id_category=product_category.id_category  where grn.id_grn = '" + string + "'";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String idItem = rs.getString("id_grn_item");
                String name = rs.getString("item_name");
                String qty = rs.getString("qty");
                String price = rs.getString("buying_price");
                String grn = rs.getString("id_grn");
                String category = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = idItem;
                dataRow[1] = name;
                dataRow[2] = qty;
                dataRow[3] = price;
                dataRow[4] = grn;
                dataRow[5] = category;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String getProductId(String product_name) {
        String msg = "";
        String query = "select * from products where product_name = '" + product_name + "'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id_products");
                msg = id;
            }
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        }

        return msg;
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

    public String product_register(String pname,String barcode, String sell_price, String bprice, String qty, String category, String grn_no) {
       String msg="";
       String query="insert into products(product_name,barcode,sell_price,buy_price,avl_qty,id_category)values(?,?,?,?,?,?)";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,pname);
            psm.setString(2,barcode);
            psm.setString(3,sell_price);
            psm.setString(4,bprice);
            psm.setString(5,qty);
            psm.setString(6,category);
            psm.execute();
            String result=select_product();
//            System.out.println(result);
            String result2=grn_Item_Register(pname, qty, bprice, grn_no, result, category);
            msg=result2;
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="item added Failed";
        }
       return msg;
    }

    
    
    private String select_product() {
        String msg="";
       String query="select last_insert_id() from products";
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            msg=rs.getString("last_insert_id()");
            }
        } catch (Exception e) {
        }
       return msg;
    }
    
    
    
    private String grn_Item_Register(String pname, String qty, String bprice, String grn_no, String pid, String category) {
        String msg="";
        String query="insert into grn_item(item_name,qty,buying_price,id_grn,id_products,id_category)values(?,?,?,?,?,?)";
        
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,pname);
            psm.setString(2,qty);
            psm.setString(3,bprice);
            psm.setString(4,grn_no);
            psm.setString(5,pid);
            psm.setString(6,category);
            psm.execute();
            int intqty=Integer.parseInt(qty);
            double dbuyprice=Double.parseDouble(bprice);
            double payment=intqty*dbuyprice;
           String result= select_grn_payments(grn_no, payment);
           if(result.equals("update success")){
            msg="item added successfully";
           }
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="item added Failed";
        }
        return msg;
    }
    
    public String select_grn_payments(String grn_no,double payment){
 String msg="";
        String query="select * from grn where id_grn='"+grn_no+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
     while(rs.next()){
         String defaultPayment=rs.getString("payment");
         
         double defaultdoublePay=Double.parseDouble(defaultPayment);
         
         double newpayment=defaultdoublePay+payment;
         String castednewpayment=String.valueOf(newpayment);
         String result=update_grn_payment(grn_no, castednewpayment);
         msg=result;
     }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        return msg;
    }

    
    public String update_grn_payment(String grn_no,String payment){
    String msg="";
        String query="update grn set payment=? where id_grn=?";
        
        try {
              PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,payment);
            psm.setString(2,grn_no);
            psm.execute();
            msg="update success";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }
    
    
    public void loadProductTable(String string,DefaultTableModel dtm4) {
       String query="select * from products where product_name like '%"+string+"%'";
      dtm4.setRowCount(0);
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
            String id=rs.getString("id_products");
            String pname=rs.getString("product_name");
            String sprice=rs.getString("sell_price");
            String bprice=rs.getString("buy_price");
            String qty=rs.getString("avl_qty");
            String category=rs.getString("id_category");
            dataRow = new String[6];
            dataRow[0]=id;
            dataRow[1]=pname;
            dataRow[2]=sprice;
            dataRow[3]=bprice;
            dataRow[4]=qty;
            dataRow[5]=category;
            dtm4.addRow(dataRow);
            }
        }catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    
    
    
    public String getqty(String pid) {
       String msg="";
       String query="select avl_qty from products where id_products ='"+pid+"'" ;
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String avl_qty=rs.getString("avl_qty");
            msg=avl_qty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
       return msg;
    }

    public String update_product_details(String pname, String sell_price, String bprice, String qty, String category, String grn_no, String castedQty, String pid) {
     String msg="";
     String query="update products set buy_price=?,avl_qty=? where id_products =?";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,bprice);
            psm.setString(2,castedQty);
            psm.setString(3,pid);
            psm.execute();
            String result2=grn_Item_Register(pname, qty, bprice, grn_no, pid, category);
            msg=result2;
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        msg="item added Failed";
        }
     
     return msg;
    }

    public String grn_delete(String grn_id) {
             String msg="";
     String query="delete from grn where id_grn =?";
     
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,grn_id);
            psm.execute();
            msg="grn deleted successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        msg="grn deleted Failed";
        }
     
     return msg;
    }

    public void loadGrnCompanyTable(String keyword, DefaultTableModel dtm) {
       String query = "select * from grn join supplier on grn.id_supplier=supplier.id_supplier  join supplier_company on grn.id_company=supplier_company.id_company where supplier_company.name like '%" + keyword + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_grn");
                String name = rs.getString("sup_name");
                String company = rs.getString("name");
                String payment = rs.getString("payment");
                String date = rs.getString("date");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = company;
                dataRow[3] = date;
                dataRow[4] = payment;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadGrnSupplierTable(String keyword, DefaultTableModel dtm) {
        String query = "select * from grn join supplier on grn.id_supplier=supplier.id_supplier  join supplier_company on grn.id_company=supplier_company.id_company where supplier.sup_name like '%" + keyword + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_grn");
                String name = rs.getString("sup_name");
                String company = rs.getString("name");
                String payment = rs.getString("payment");
                String date = rs.getString("date");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = company;
                dataRow[3] = date;
                dataRow[4] = payment;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadGrnItemTableOnProduct(String keyword, DefaultTableModel dtm2) {
       String query = "select * from grn_item join grn on grn_item.id_grn=grn.id_grn  join products on grn_item.id_products=products.id_products join product_category on products.id_category=product_category.id_category  where grn_item.item_name like '%" + keyword + "%'";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String idItem = rs.getString("id_grn_item");
                String name = rs.getString("item_name");
                String qty = rs.getString("qty");
                String price = rs.getString("buying_price");
                String grn = rs.getString("id_grn");
                String category = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = idItem;
                dataRow[1] = name;
                dataRow[2] = qty;
                dataRow[3] = price;
                dataRow[4] = grn;
                dataRow[5] = category;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadGrnItemTableOnCategory(String keyword, DefaultTableModel dtm2) {
       String query = "select * from grn_item join grn on grn_item.id_grn=grn.id_grn  join products on grn_item.id_products=products.id_products join product_category on products.id_category=product_category.id_category  where grn_item.qty like '%" + keyword + "%'";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String idItem = rs.getString("id_grn_item");
                String name = rs.getString("item_name");
                String qty = rs.getString("qty");
                String price = rs.getString("buying_price");
                String grn = rs.getString("id_grn");
                String category = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = idItem;
                dataRow[1] = name;
                dataRow[2] = qty;
                dataRow[3] = price;
                dataRow[4] = grn;
                dataRow[5] = category;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }


    public void loadGrnItemTableOnID(String string, DefaultTableModel dtm2) {
        String query = "select * from grn_item join grn on grn_item.id_grn=grn.id_grn  join products on grn_item.id_products=products.id_products join product_category on products.id_category=product_category.id_category  where grn.id_grn = '" + string + "'";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String idItem = rs.getString("id_grn_item");
                String name = rs.getString("item_name");
                String qty = rs.getString("qty");
                String price = rs.getString("buying_price");
                String grn = rs.getString("id_grn");
                String category = rs.getString("category_name");
                dataRow = new String[6];
                dataRow[0] = idItem;
                dataRow[1] = name;
                dataRow[2] = qty;
                dataRow[3] = price;
                dataRow[4] = grn;
                dataRow[5] = category;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    public String loadProductData(String barcode){
    String msg="";
        String query="select * from products where barcode = '"+barcode+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String pname=rs.getString("product_name");
            msg=pname;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg=null;
        }
        return msg;
    }
    
    
    public String loadProductDataBuy(String barcode){
    String msg="";
        String query="select * from products where barcode = '"+barcode+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String buy=rs.getString("buy_price");
            msg=buy;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg=null;
        }
        return msg;
    }
    
    public String loadProductDataCategory(String barcode){
    String msg="";
        String query="select * from products where barcode = '"+barcode+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String category=rs.getString("id_category");
            msg=category;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg=null;
        }
        return msg;
    }

    public String grn_update(String id, String date, String payment, String supplier, String company) {
        String msg = "";
        String query = "update grn set date=?,payment=?,id_supplier=?,id_company=? where id_grn =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, date);
            psm.setString(2, payment);
            psm.setString(3, supplier);
            psm.setString(4, company);
            psm.setString(5, id);
            psm.execute();
            msg = "GRN updated Successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "GRN updated Failed";
        }
        return msg;
    }

    public String getSuppID(String valueOf) {
        String msg="";
        String query="select * from supplier where sup_name='"+valueOf+"'";
          try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                String id=rs.getString("id_supplier");
                msg=id;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
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

    public String getCategoryID(String valueOf) {
      String msg="";
      String query="select * from product_category where category_name='"+valueOf+"'";
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

    public String cancelItem(String id,String pid) {
       String msg="";
       String query="select * from grn_item join products on grn_item.id_products=products.id_products where grn_item.id_grn_item='"+id+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String grnqty=rs.getString("qty");
            String productQty=rs.getString("avl_qty");
           String result= qtyReAdded(grnqty,pid,productQty,id);
           msg=result;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
       return msg;
    }

    
    
    
    
    private String qtyReAdded(String grnqty, String pid, String productQty,String id) {
        String msg="";
        int intGrnQty=Integer.parseInt(grnqty);
        int intProductQty=Integer.parseInt(productQty);
        int currentQty=intProductQty-intGrnQty;
        System.out.println(currentQty);
            String result=productQtyUpdate(pid,currentQty);
            if(result.equals("product Quantity Updated")){
        try {
              String query="delete from grn_item where id_grn_item=?";
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
            msg="Item cancelled from GRN";
            }else{
            msg="Item cancel failed from GRN";
            }
        return msg;
    }

    private String productQtyUpdate(String id, int currentQty) {
       String msg="";
       String query="update products set avl_qty=? where id_products=?";
        try {
            String castedQty=String.valueOf(currentQty);
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, castedQty);
            psm.setString(2, id);
            psm.execute();
            msg="product Quantity Updated";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
       return msg;
    }

}