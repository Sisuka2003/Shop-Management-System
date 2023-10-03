/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author DELL
 */
public class salesModel {

    static Logger log = Logger.getLogger(salesModel.class.getName());
    Connection conn;

    public salesModel() {
        conn = db.dbConnection.getConnection();
    }

    public void loadInvoiceTabledup(String string, DefaultTableModel dtm) {
        String query = "select * from invoice";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String pay = rs.getString("payment");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] = pay;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadInvoiceTable(String string, DefaultTableModel dtm) {
        String query = "select * from invoice where date like '%" + string + "%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String pay = rs.getString("payment");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] = pay;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String loadInvoiceTableDate(String keyword) {
        String msg = "";
        String query = "select * from invoice where date like  '%" + keyword + "%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String date = rs.getString("date");
                msg = date;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "error";
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String loadInvoiceTableMonth(String keyword) {
        String msg = "";
        String query = "select * from invoice where month =  '" + keyword + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String date = rs.getString("date");
                msg = keyword;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "error";
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String loadInvoiceTableSales(String keyword) {
        String msg = "";
        String query = "select SUM(payment) from invoice where date like '%" + keyword + "%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String payment = rs.getString("SUM(payment)");
                msg = payment;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String loadInvoiceTableSales2(String keyword2,String year) {
        String msg = "";
        String query = "select SUM(payment) from invoice where month = '" + keyword2+"'  AND date like '%"+year+"%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String payment = rs.getString("SUM(payment)");
                if(payment=="0"){
                msg="no_value";
                }else{
                msg=payment;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg="payment_errors";
            log.debug(e.getMessage());
        }
        return msg;
    }

    public void loadInvoiceItemTable(String string, DefaultTableModel dtm4) {
        String query = "select * from invoice_item join products on invoice_item.id_products =products.id_products where id_invoice = '" + string + "'";
        dtm4.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String name = rs.getString("product_name");
                String qty = rs.getString("qty");
                String sell_price = rs.getString("sell_price");
                int intqty = Integer.parseInt(qty);
                double dsellprice = Double.parseDouble(sell_price);
                double amount = intqty * dsellprice;
                String castedAmount = String.valueOf(amount);
                dataRow = new String[3];
                dataRow[0] = name;
                dataRow[1] = qty;
                dataRow[2] = castedAmount;
                dtm4.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String loadInvoiceTableYear(String year) {
       String msg="";
       String query="select * from invoice where date like '%"+year+"%'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String date=rs.getString("date");
            msg=date;
            }
        } catch (Exception e) {
       e.printStackTrace();
       msg="year";
       log.debug(e.getMessage());
        }
        return msg;
    }

    public String loadInvoiceTableYear2(String year) {
       String msg="";
       String query="select * from invoice where date like '%"+year+"%'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String date=rs.getString("date");
            msg=date;
            }
        } catch (Exception e) {
       e.printStackTrace();
       msg="year";
       log.debug(e.getMessage());
        }
        return msg;
    }

    
    
    public void loadsalesYear(String string, DefaultTableModel dtm) {
        String query = "select * from invoice where date like '%"+string+"%'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String pay = rs.getString("payment");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] = pay;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
    
    
    public void loadInvoiceTableMonth(String month, DefaultTableModel dtm3) {
           String query = "select * from invoice where month like '%" + month + "%'";
        dtm3.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_invoice");
                String pay = rs.getString("payment");
                dataRow = new String[2];
                dataRow[0] = id;
                dataRow[1] = pay;
                dtm3.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String loadInvoiceYearSalesTable(String year) {
        String msg="";
        String query = "select SUM(payment) from invoice where date like '%"+year+"%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String pay = rs.getString("SUM(payment)");
                msg=pay;
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg="error";
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String getMonthlyProfitOrLoss(String month, String year) {
        String msg="";
        String numMonth="";
        String GRNPayment="";
        String ElectricityPayment="";
        String WaterPayment="";
        String StaffPayment="";
        String income="";
        
           if (month == "January") {
                numMonth="/ 01 /";
            } else if (month == "February") {
                numMonth="/ 02 /";
            } else if (month == "March") {
                numMonth="/ 03 /";
            } else if (month == "April") {
                numMonth="/ 04 /";
            } else if (month == "May") {
                numMonth="/ 05 /";
            } else if (month == "June") {
                numMonth="/ 06 /";
            } else if (month == "July") {
                numMonth="/ 07 /";
            } else if (month == "August") {
                numMonth="/ 08 /";
            } else if (month == "September") {
                numMonth="/ 09 /";
            } else if (month == "October") {
                numMonth="/ 10 /";
            } else if (month == "November") {
                numMonth="/ 11 /";
            } else if (month == "December") {
                numMonth="/ 12 /";
            }
           
           String createDate=numMonth+" "+year;
            
        String queryGRN="select SUM(payment) from grn where date like '%"+createDate+"%'";
        String queryStaff="select SUM(paid_amount) from staff_payments where month ='"+month+"' AND year='"+year+"'";
        String queryElectricity="select SUM(amount) from electricitybill_payment where month='"+month+"' AND year='"+year+"'";
        String queryWater="select SUM(amount) from waterbill_payment where month='"+month+"' AND year='"+year+"'";
        String queryIncome="select SUM(payment) from invoice where month ='"+month+"' AND date like '%"+year+"%'";
        
        try {
            Statement stmGRN=conn.createStatement();
            ResultSet rsGRN=stmGRN.executeQuery(queryGRN);
            while(rsGRN.next()){
             GRNPayment=rsGRN.getString("SUM(payment)");
//                System.out.println(GRNPayment);
            }
          
            
            Statement stmStaff=conn.createStatement();
            ResultSet rsStaff=stmStaff.executeQuery(queryStaff);
            while(rsStaff.next()){
             StaffPayment=rsStaff.getString("SUM(paid_amount)");
//                System.out.println(StaffPayment);
            }
            
            
            Statement stmElec=conn.createStatement();
            ResultSet rsElec=stmElec.executeQuery(queryElectricity);
            while(rsElec.next()){
             ElectricityPayment=rsElec.getString("SUM(amount)");
//                System.out.println(ElectricityPayment);
            }
            
            
            Statement stmWater=conn.createStatement();
            ResultSet rsWater=stmWater.executeQuery(queryWater);
            while(rsWater.next()){
             WaterPayment=rsWater.getString("SUM(amount)");
//                System.out.println(WaterPayment);
            }
            
            
            Statement stmIncome=conn.createStatement();
            ResultSet rsIncome=stmIncome.executeQuery(queryIncome);
            while(rsIncome.next()){
             income=rsIncome.getString("SUM(payment)");
//                System.out.println(income);
            }
            
            double dGRN=Double.parseDouble(GRNPayment);
            double dStaff=Double.parseDouble(StaffPayment);
            double dElectric=Double.parseDouble(ElectricityPayment);
            double dWater=Double.parseDouble(WaterPayment);
            double dincome=Double.parseDouble(income);
            
            double expenses=dGRN+dStaff+dElectric+dWater;
            double porl=dincome-expenses;
            String castedporl=String.valueOf(porl);
//            System.out.println(castedporl);
            msg=castedporl;
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String getYearlyProfitOrLoss(String year) {
         String msg="";
        String GRNPayment="";
        String ElectricityPayment="";
        String WaterPayment="";
        String StaffPayment="";
        String income="";
            
        String queryGRN="select SUM(payment) from grn where date like '%"+year+"%'";
        String queryStaff="select SUM(paid_amount) from staff_payments where year='"+year+"'";
        String queryElectricity="select SUM(amount) from electricitybill_payment where year='"+year+"'";
        String queryWater="select SUM(amount) from waterbill_payment where year='"+year+"'";
        String queryIncome="select SUM(payment) from invoice where date like '%"+year+"%'";
        
        try {
            Statement stmGRN=conn.createStatement();
            ResultSet rsGRN=stmGRN.executeQuery(queryGRN);
            while(rsGRN.next()){
             GRNPayment=rsGRN.getString("SUM(payment)");
//                System.out.println(GRNPayment);
            }
          
            
            Statement stmStaff=conn.createStatement();
            ResultSet rsStaff=stmStaff.executeQuery(queryStaff);
            while(rsStaff.next()){
             StaffPayment=rsStaff.getString("SUM(paid_amount)");
//                System.out.println(StaffPayment);
            }
            
            
            Statement stmElec=conn.createStatement();
            ResultSet rsElec=stmElec.executeQuery(queryElectricity);
            while(rsElec.next()){
             ElectricityPayment=rsElec.getString("SUM(amount)");
//                System.out.println(ElectricityPayment);
            }
            
            
            Statement stmWater=conn.createStatement();
            ResultSet rsWater=stmWater.executeQuery(queryWater);
            while(rsWater.next()){
             WaterPayment=rsWater.getString("SUM(amount)");
//                System.out.println(WaterPayment);
            }
            
            
            Statement stmIncome=conn.createStatement();
            ResultSet rsIncome=stmIncome.executeQuery(queryIncome);
            while(rsIncome.next()){
             income=rsIncome.getString("SUM(payment)");
//                System.out.println(income);
            }
            
            double dGRN=Double.parseDouble(GRNPayment);
            double dStaff=Double.parseDouble(StaffPayment);
            double dElectric=Double.parseDouble(ElectricityPayment);
            double dWater=Double.parseDouble(WaterPayment);
            double dincome=Double.parseDouble(income);
            
            double expenses=dGRN+dStaff+dElectric+dWater;
            double porl=dincome-expenses;
            String castedporl=String.valueOf(porl);
//            System.out.println(castedporl);
            msg=castedporl;
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }
    
    
    public String calculateStaffExpenses(String month,String year){
         String msg="";
        String StaffPayment="";
            
        String queryStaff="select SUM(paid_amount) from staff_payments where year='"+year+"' AND month='"+month+"'";
        
            try{
            Statement stmStaff=conn.createStatement();
            ResultSet rsStaff=stmStaff.executeQuery(queryStaff);
            while(rsStaff.next()){
             StaffPayment=rsStaff.getString("SUM(paid_amount)");
             msg=StaffPayment;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }
    
    public String calculateElectricityExpenses(String month,String year){
         String msg="";
        String ElectricityPayment="";
            
        String queryElectricity="select SUM(amount) from electricitybill_payment where year='"+year+"' AND month='"+month+"'";
        
        try {
            Statement stmElec=conn.createStatement();
            ResultSet rsElec=stmElec.executeQuery(queryElectricity);
            while(rsElec.next()){
             ElectricityPayment=rsElec.getString("SUM(amount)");
            msg=ElectricityPayment;
            }
          
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }
    
    public String calculateWaterExpenses(String month,String year){
         String msg="";
        String WaterPayment="";
            
        String queryWater="select SUM(amount) from waterbill_payment where year='"+year+"' AND month='"+month+"'";
        
        try {
            Statement stmWater=conn.createStatement();
            ResultSet rsWater=stmWater.executeQuery(queryWater);
            while(rsWater.next()){
             WaterPayment=rsWater.getString("SUM(amount)");
             msg=WaterPayment;
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }
    
    public String calculateProductsExpenses(String month,String year){
         String msg="";   
         String numMonth="";
        String GRNPayment="";
        
           if (month == "January") {
                numMonth="/ 01 /";
            } else if (month == "February") {
                numMonth="/ 02 /";
            } else if (month == "March") {
                numMonth="/ 03 /";
            } else if (month == "April") {
                numMonth="/ 04 /";
            } else if (month == "May") {
                numMonth="/ 05 /";
            } else if (month == "June") {
                numMonth="/ 06 /";
            } else if (month == "July") {
                numMonth="/ 07 /";
            } else if (month == "August") {
                numMonth="/ 08 /";
            } else if (month == "September") {
                numMonth="/ 09 /";
            } else if (month == "October") {
                numMonth="/ 10 /";
            } else if (month == "November") {
                numMonth="/ 11 /";
            } else if (month == "December") {
                numMonth="/ 12 /";
            }
           
           String createDate=numMonth+" "+year;
            
        String queryGRN="select SUM(payment) from grn where date like '%"+createDate+"%'";
        
        try {
            Statement stmGRN=conn.createStatement();
            ResultSet rsGRN=stmGRN.executeQuery(queryGRN);
            while(rsGRN.next()){
             GRNPayment=rsGRN.getString("SUM(payment)");
              msg=GRNPayment;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String calculateIncome(String month, String year) {
          String msg="";   
         String numMonth="";
        String income="";
        
           if (month == "January") {
                numMonth="/ 01 /";
            } else if (month == "February") {
                numMonth="/ 02 /";
            } else if (month == "March") {
                numMonth="/ 03 /";
            } else if (month == "April") {
                numMonth="/ 04 /";
            } else if (month == "May") {
                numMonth="/ 05 /";
            } else if (month == "June") {
                numMonth="/ 06 /";
            } else if (month == "July") {
                numMonth="/ 07 /";
            } else if (month == "August") {
                numMonth="/ 08 /";
            } else if (month == "September") {
                numMonth="/ 09 /";
            } else if (month == "October") {
                numMonth="/ 10 /";
            } else if (month == "November") {
                numMonth="/ 11 /";
            } else if (month == "December") {
                numMonth="/ 12 /";
            }
           
           String createDate=numMonth+" "+year;
            
        String queryIncome="select SUM(payment) from invoice where date like '%"+createDate+"%'";
        
        try {
            Statement stmIncome=conn.createStatement();
            ResultSet rsIncome=stmIncome.executeQuery(queryIncome);
            while(rsIncome.next()){
             income=rsIncome.getString("SUM(payment)");
              msg=income;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    
    
    
    
    public String calculateElectricityExpensesyearly(String monthlyYear) {
        String msg="";
        String ElectricityPayment="";
            
        String queryElectricity="select SUM(amount) from electricitybill_payment where year='"+monthlyYear+"'";
        
        try {
            Statement stmElec=conn.createStatement();
            ResultSet rsElec=stmElec.executeQuery(queryElectricity);
            while(rsElec.next()){
             ElectricityPayment=rsElec.getString("SUM(amount)");
            msg=ElectricityPayment;
            }
          
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String calculateWaterExpensesyearly(String monthlyYear) {
          String msg="";
        String WaterPayment="";
            
        String queryWater="select SUM(amount) from waterbill_payment where year='"+monthlyYear+"'";
        
        try {
            Statement stmWater=conn.createStatement();
            ResultSet rsWater=stmWater.executeQuery(queryWater);
            while(rsWater.next()){
             WaterPayment=rsWater.getString("SUM(amount)");
             msg=WaterPayment;
            }
            
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String calculateProductsExpensesyearly(String monthlyYear) {
          String msg="";   
        String GRNPayment="";
            
        String queryGRN="select SUM(payment) from grn where date like '%"+monthlyYear+"%'";
        
        try {
            Statement stmGRN=conn.createStatement();
            ResultSet rsGRN=stmGRN.executeQuery(queryGRN);
            while(rsGRN.next()){
             GRNPayment=rsGRN.getString("SUM(payment)");
              msg=GRNPayment;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String calculateStaffExpensesyearly(String monthlyYear) {
             String msg="";
        String StaffPayment="";
            
        String queryStaff="select SUM(paid_amount) from staff_payments where year='"+monthlyYear+"'";
        
            try{
            Statement stmStaff=conn.createStatement();
            ResultSet rsStaff=stmStaff.executeQuery(queryStaff);
            while(rsStaff.next()){
             StaffPayment=rsStaff.getString("SUM(paid_amount)");
             msg=StaffPayment;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }

    public String calculateIncomeyearly(String monthlyYear) {
          String msg="";   
        String income="";
            
        String queryIncome="select SUM(payment) from invoice where date like '%"+monthlyYear+"%'";
        
        try {
            Statement stmIncome=conn.createStatement();
            ResultSet rsIncome=stmIncome.executeQuery(queryIncome);
            while(rsIncome.next()){
             income=rsIncome.getString("SUM(payment)");
              msg=income;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
        
        return msg;
    }
}
