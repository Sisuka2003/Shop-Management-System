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
public class invoiceModel {
   static Logger log = Logger.getLogger(invoiceModel.class.getName());
    Connection conn;

    public invoiceModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadCustomerTable(String string, DefaultTableModel dtm) {
        String query = "select * from customer where mobile like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_customer");
                String fname = rs.getString("first_name");
                String lname = rs.getString("last_name");
                String mobile = rs.getString("mobile");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = fname;
                dataRow[2] = lname;
                dataRow[3] = mobile;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadInvoiceTable(String string, DefaultTableModel dtm) {
        String query = "select * from invoice join customer on invoice.id_customer=customer.id_customer where invoice.date like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String date = rs.getString("date");
                String pay = rs.getString("payment");
                String customer = rs.getString("first_name");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = date;
                dataRow[2] = pay;
                dataRow[3] = customer;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    
    
    public void loadInvoiceTableCustomer(String string, DefaultTableModel dtm) {
           String query = "select * from invoice join customer on invoice.id_customer=customer.id_customer where customer.first_name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String date = rs.getString("date");
                String pay = rs.getString("payment");
                String customer = rs.getString("first_name");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = date;
                dataRow[2] = pay;
                dataRow[3] = customer;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    

    
    public void priceRangerLoad(String value1,String value2, DefaultTableModel dtm2) {
        String query = "SELECT * FROM invoice join customer on customer.id_customer= invoice.id_customer WHERE invoice.payment BETWEEN '"+value1+"'  AND '"+value2+"' ";
        dtm2.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String date = rs.getString("date");
                String pay = rs.getString("payment");
                String customer = rs.getString("first_name");
                  dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = date;
                dataRow[2] = pay;
                dataRow[3] = customer;
                dtm2.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    
    public String invoice_reg(String date, String pay, String customer,String month) {
        //       invoice added error
//invoice added successfully
        String msg = "";
        String query = "insert into invoice(date,payment,id_customer,month)values(?,?,?,?)";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, date);
            psm.setString(2, pay);
            psm.setString(3, customer);
            psm.setString(4, month);
            psm.execute();
            msg = "invoice added successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "invoice added error";
        }
        return msg;
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

    public void loadInvoiceItemTable(String string, DefaultTableModel dtm) {
        String query = "select * from invoice_item join products on invoice_item.id_products =products.id_products where id_invoice = '" + string + "'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice_item");
                String qty = rs.getString("qty");
                String products = rs.getString("product_name");
                String invoice = rs.getString("id_invoice");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = qty;
                dataRow[2] = products;
                dataRow[3] = invoice;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadInvoiceItemTableOnProduct(String string, DefaultTableModel dtm) {
        String query = "select * from invoice_item join products on invoice_item.id_products =products.id_products where product_name like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice_item");
                String qty = rs.getString("qty");
                String products = rs.getString("product_name");
                String invoice = rs.getString("id_invoice");
                dataRow = new String[4];
                dataRow[0] = id;
                dataRow[1] = qty;
                dataRow[2] = products;
                dataRow[3] = invoice;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    
    
    public void loadInvoiceItemsOnID(String orderID, DefaultTableModel dtm) {
        String query = "select * from invoice_item join products on invoice_item.id_products =products.id_products where invoice_item.id_invoice = '" + orderID + "'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice_item");
                String qty = rs.getString("qty");
                String products = rs.getString("product_name");
                String invoice = rs.getString("id_invoice");
                String sell_price=rs.getString("sell_price");
                String qtys=rs.getString("qty");
                double castedSell=Double.parseDouble(sell_price);
                double castedqty=Double.parseDouble(qtys);
                double total=castedSell*castedqty;
                String castedtotal=String.valueOf(total);
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = qty;
                dataRow[2] = products;
                dataRow[3] = invoice;
                dataRow[4] = castedtotal;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    
    
    public String loadTotalQty(String orderID, DefaultTableModel dtm) {
       String msg="";
        String query="select SUM(qty) FROM invoice_item where invoice_item.id_invoice = '" + orderID + "'";
        
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String qty=rs.getString("SUM(qty)");
            msg=qty;
            }
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        }
        
        return  msg;
    }

    
    public String invoice_item_reg(String qty, String pid, String invid) {
        //  invoice item added error
//invoice item added successfully
        String msg = "";
        String result = selectQty(qty, pid);
        int intResult = Integer.parseInt(result);
        int intQty = Integer.parseInt(qty);
        if (intQty > intResult) {
            msg = ("Lesser Items are Remaining in Stock");
        } else {
            String query = "insert into invoice_item(qty,id_products,id_invoice)values(?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, qty);
                psm.setString(2, pid);
                psm.setString(3, invid);
                psm.execute();
                updateQty(qty, result, pid);
                String result2=updateInvoPaymentforinsert(qty,pid,invid);
                if(result2 != ""){
                msg = "invoice item added successfully";
                }else{
                msg="invoice item added error";
                }
            } catch (Exception e) {
                e.printStackTrace();
            log.debug(e.getMessage());
                msg = "invoice item added error";
            }
        }
        return msg;
    }

    private String selectQty(String qty, String pid) {
        String msg = "";
        String query = "select avl_qty from products where id_products ='" + pid + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);

            while (rs.next()) {
                String avl_qty = rs.getString("avl_qty");
                msg = avl_qty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    private void updateQty(String boughtqty, String avl_qty, String productid) {
        int bqty = Integer.parseInt(boughtqty);
        int aqty = Integer.parseInt(avl_qty);
        int remainingqty = aqty - bqty;
        String rqty = String.valueOf(remainingqty);
        String query = "update products set avl_qty=? where id_products =?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, rqty);
            psm.setString(2, productid);
            psm.execute();
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String getProductId(String name) {
        String msg = "";
        String query = "select * from products where product_name like '%" + name + "%'";
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

    public String invoice_update(String date, String pay, String id, String customer,String month) {
        //       invoice updated error
//invoice updated successfully
        String msg = "";
        String query = "update invoice set date=?,payment=?,id_customer=?,month=? where id_invoice=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, date);
            psm.setString(2, pay);
            psm.setString(3, customer);
            psm.setString(4, month);
            psm.setString(5, id);
            psm.execute();
            msg = "invoice updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "invoice updated error";
        }
        return msg;
    }

    public String invoice_item_update(String qty, String pid, String invid, String id) {
        //  invoice item updated error
//invoice item updated successfully
        String msg = "";
        String result = selectCurrentQty(id);
        String result2 = selectProductQty(pid);
        String resultqty = updateQty2(qty, result,result2, pid, id);
        String resultpay=updateInvoPayment(qty,pid,invid);
        String query = "update invoice_item set qty=?,id_products=?,id_invoice=? where id_invoice_item=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, qty);
            psm.setString(2, pid);
            psm.setString(3, invid);
            psm.setString(4, id);
            psm.execute();
            if(resultpay != ""  &&  resultqty != ""){
            msg = resultqty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "invoice item updated error";
        }
//            }
        return msg;
    }

    private String updateQty2(String boughtqty, String avl_qty,String currentProductQty, String productid, String id) {
        String msg = "";
        System.out.println("Buying qty is "+boughtqty);
        System.out.println("Current quantity ordered "+avl_qty);
        int currentQty = Integer.parseInt(avl_qty);
        int bqty = Integer.parseInt(boughtqty);

        if (bqty > currentQty) {
            int remainingqty = bqty - currentQty;
            int intcurrentProductQty=Integer.parseInt(currentProductQty);
            intcurrentProductQty=intcurrentProductQty-remainingqty;
            String rqty = String.valueOf(intcurrentProductQty);
            String query = "update products set avl_qty=? where id_products =?";
            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, rqty);
                psm.setString(2, productid);
                psm.execute();
                msg = "invoice item updated successfully";
            } catch (Exception e) {
                e.printStackTrace();
            log.debug(e.getMessage());
                msg = "invoice item updated error";
            }
        } else if (currentQty > bqty) {
            int remainingqty = currentQty - bqty;
            String result = selectQty(avl_qty, productid);
            int intresult = Integer.parseInt(result);
            int calculated = intresult + remainingqty;
            String rqty = String.valueOf(calculated);
            String query = "update products set avl_qty=? where id_products =?";
            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, rqty);
                psm.setString(2, productid);
                psm.execute();
                msg = "invoice item updated successfully";
            } catch (Exception e) {
                e.printStackTrace();
            log.debug(e.getMessage());
                msg = "invoice item updated error";
            }
        }

        return msg;
    }

    private String selectCurrentQty(String id) {
        String msg = "";
        String query = "select qty from invoice_item where id_invoice_item='" + id + "'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String qty = rs.getString("qty");
                msg = qty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    private String selectProductQty(String pid) {
           String msg = "";
        String query = "select avl_qty from products where id_products='" + pid + "'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String qty = rs.getString("avl_qty");
                msg = qty;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    
    
    
    
    public String invoice_delete(String id) {
//     invoice deleted successfully
//invoice deleted error
String msg="";
String query="delete from invoice where id_invoice =?";

        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,id);
            psm.execute();
            msg="invoice deleted successfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="invoice deleted error";
        }
return msg;
    }

    public String invoice_cancel(String id) {
       String msg="";
       String query="select * from invoice join invoice_item on invoice.id_invoice=invoice_item.id_invoice join products on invoice_item.id_products = products.id_products where invoice.id_invoice = '"+id+"'";
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String pid=rs.getString("id_products");
            String avl_qty=rs.getString("avl_qty");
            String qty=rs.getString("qty");
            
           String result= qtyReAdded(avl_qty,pid,qty);
           msg=result;
           if(result.equals("invoice Canceled successfully")){
           String Dquery="delete from invoice where id_invoice=?";
           
               try {
                   PreparedStatement psm=conn.prepareStatement(Dquery);
                   psm.setString(1,id);
                   psm.execute();
               } catch (Exception e) {
               e.printStackTrace();
            log.debug(e.getMessage());
               }
           }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        msg="invoice Canceled error";
        }
       
       return msg;
    }

    private String qtyReAdded(String avl_qty,String pid, String qty) {
        String msg="";
        int avlqty=Integer.parseInt(avl_qty);
        int currentqty=Integer.parseInt(qty);
        
        int calculatedQty=avlqty + currentqty;
        String castedCalculatedQty=String.valueOf(calculatedQty);
        String query="update products set avl_qty=? where id_products =?";
        
        try {
         PreparedStatement psm=conn.prepareStatement(query);
         psm.setString(1,castedCalculatedQty);
         psm.setString(2,pid);
         psm.execute();
         msg="invoice Canceled successfully";
        } catch (Exception e) {
        e.printStackTrace();
            log.debug(e.getMessage());
        msg="invoice Canceled error";
        }
        return msg;
    }

    
    
    public String getCustomerID(String valueOf) {
        String msg = "";
        String query = "select * from customer where first_name ='" + valueOf + "'";

        try {
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String id=rs.getString("id_customer");
            msg=id;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    private String updateInvoPayment(String qty, String pid, String invid) {
       String msg="";
        String query="select * from products where id_products ='"+pid+"'";
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String sellprice=rs.getString("sell_price");
            double dsellprice=Double.parseDouble(sellprice);
            String getqty=selectpqty(qty,pid,invid);
            double dqty=Double.parseDouble(getqty);
            double payment=dsellprice*dqty;
            String result=updatecuspay(payment,invid);
            if(result !=""){
            msg=result;
            }
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        return msg;
    }

    private String updateInvoPaymentforinsert(String qty, String pid, String invid) {
       String msg="";
        String query="select * from products where id_products ='"+pid+"'";
       
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String sellprice=rs.getString("sell_price");
            double dsellprice=Double.parseDouble(sellprice);
            double dqty=Double.parseDouble(qty);
            double payment=dsellprice*dqty;
            String result=updatecuspay(payment,invid);
            if(result !=""){
            msg=result;
            }
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        return msg;
    }

    
    private String selectpqty(String qty,String pid,String invid){
    String msg="";
    String query="select * from invoice_item where id_products='"+pid+"' AND id_invoice = '"+invid+"'";
        try {
             Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
                String getqty=rs.getString("qty");
                System.out.println("this is get qty "+getqty);
                double dqty=Double.parseDouble(qty);
                double dgetqty=Double.parseDouble(getqty);
                double qtydifference=dqty-dgetqty;
                String castedgetQty=String.valueOf(qtydifference);
                System.out.println(castedgetQty);
                msg=castedgetQty;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    
    return msg;
    }
    
    
    
    private String updatecuspay(double payment, String invid) {
        String msg="";
        String query="select * from invoice where id_invoice = '"+invid+"'";
        
        try {
              Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String payments=rs.getString("payment");
            double dpayment=Double.parseDouble(payments);
            dpayment=dpayment + payment;
            String castedPayment=String.valueOf(dpayment);
            String updateresult=updatepay(invid,castedPayment);
            if(updateresult=="success"){
            msg=castedPayment;
                System.out.println(castedPayment);
            }
            }
        } catch (Exception e) {
         e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    private String updatepay(String invid, String castedPayment) {
      String msg="";
        String query="update invoice set payment=? where id_invoice=? ";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,castedPayment);
            psm.setString(2,invid);
            psm.execute();
            msg="success";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        return msg;
    }
}
