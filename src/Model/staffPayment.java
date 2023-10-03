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
public class staffPayment {

    static Logger log = Logger.getLogger(staffPayment.class.getName());
    Connection conn;

    public staffPayment() {
        conn = db.dbConnection.getConnection();
    }

    public void loadPaymentTable(String string, DefaultTableModel dtm) {
        String query = "select id_payments,month,paid_amount,role_name,full_name from staff_payments \n"
                + "join staff on staff_payments.staff_id_staff = staff.id_staff\n"
                + "join staff_job_role on staff_payments.id_role = staff_job_role.id_role \n"
                + "where staff.full_name LIKE '%" + string + "%' ";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_payments");
                String name = rs.getString("full_name");
                String role = rs.getString("role_name");
                String month = rs.getString("month");
                String paid_amount = rs.getString("paid_amount");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = role;
                dataRow[3] = month;
                dataRow[4] = paid_amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadJobRoleTable(String keyword, DefaultTableModel dtm2) {
        String query = "select * from staff_job_role WHERE staff_job_role.role_name LIKE '%" + keyword + "%'";
        dtm2.setRowCount(0);
        try {
            Connection connection = db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String roleid = rs.getString("id_role");
                String role = rs.getString("role_name");
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
        String msg = "";
        String query = "SELECT id_role FROM staff_job_role where role_name LIKE '%" + s4 + "%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String roleid = rs.getString("id_role");
                msg = roleid;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public void loadStaffTable(String keyword, DefaultTableModel dtm3) {
        String query = "select id_staff,full_name,mobile,nic,role_name from staff join staff_job_role on staff.id_role = staff_job_role.id_role WHERE staff.full_name LIKE '%" + keyword + "%'";
        dtm3.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String staffid = rs.getString("id_staff");
                String name = rs.getString("full_name");
                String mobile = rs.getString("mobile");
                String nic = rs.getString("nic");
                String role = rs.getString("role_name");
                dataRow = new String[5];
                dataRow[0] = staffid;
                dataRow[1] = name;
                dataRow[2] = mobile;
                dataRow[3] = nic;
                dataRow[4] = role;
                dtm3.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String getStaffId(String s4) {
        String msg = "";
        String query = "SELECT id_staff FROM staff where full_name LIKE '%" + s4 + "%'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String roleid = rs.getString("id_staff");
                msg = roleid;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String staff_payment_update(String status, String amount, String job, String name, String id,String year) {
        String msg = "";
        String query = "update staff_payments set month=?,paid_amount=?,id_role=?,staff_id_staff=?,year=? where id_payments = ?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, status);
            psm.setString(2, amount);
            psm.setString(3, job);
            psm.setString(4, name);
            psm.setString(5, year);
            psm.setString(6, id);
            psm.execute();
            msg = "payment updated successfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "payment updated error";
        }
        return msg;
    }

    public String staff_payment_delete(String id) {
        String msg = "";
        String query = "delete from staff_payments where id_payments=?";

        try {
            PreparedStatement psm = conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg = "payment deleted succesfully";
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
            msg = "payment deleting error";
        }
        return msg;
    }

    public void loadPaymentTableJob(String keyword, DefaultTableModel dtm) {
        String query = "select id_payments,month,paid_amount,role_name,full_name from staff_payments \n"
                + "join staff on staff_payments.staff_id_staff = staff.id_staff\n"
                + "join staff_job_role on staff_payments.id_role = staff_job_role.id_role \n"
                + "where staff_job_role.role_name LIKE '%" + keyword + "%' ";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_payments");
                String name = rs.getString("full_name");
                String role = rs.getString("role_name");
                String month = rs.getString("month");
                String paid_amount = rs.getString("paid_amount");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = role;
                dataRow[3] = month;
                dataRow[4] = paid_amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadPaymentTableMonth(String keyword, DefaultTableModel dtm) {
        String query = "select id_payments,month,paid_amount,role_name,full_name from staff_payments \n"
                + "join staff on staff_payments.staff_id_staff = staff.id_staff\n"
                + "join staff_job_role on staff_payments.id_role = staff_job_role.id_role \n"
                + "where staff_payments.month LIKE '%" + keyword + "%' ";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_payments");
                String name = rs.getString("full_name");
                String role = rs.getString("role_name");
                String month = rs.getString("month");
                String paid_amount = rs.getString("paid_amount");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = role;
                dataRow[3] = month;
                dataRow[4] = paid_amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public void loadPaymentTablePay(String keyword, DefaultTableModel dtm) {
        String query = "select id_payments,month,paid_amount,role_name,full_name from staff_payments \n"
                + "join staff on staff_payments.staff_id_staff = staff.id_staff\n"
                + "join staff_job_role on staff_payments.id_role = staff_job_role.id_role \n"
                + "where staff_payments.paid_amount LIKE '%" + keyword + "%' ";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_payments");
                String name = rs.getString("full_name");
                String role = rs.getString("role_name");
                String month = rs.getString("month");
                String paid_amount = rs.getString("paid_amount");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = role;
                dataRow[3] = month;
                dataRow[4] = paid_amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    public String staff_payment_register(String status, String paid, String job, String name,String year) {
        String msg = "";
        String result = loadAbsentDays(name, status, paid, job,year);
        msg = result;
//       String query="insert into staff_payments(month,paid_amount,id_role,staff_id_staff)values(?,?,?,?)";
//       
//        try {
//            PreparedStatement psm=conn.prepareStatement(query);
//            psm.setString(1,status);
//            psm.setString(2,paid);
//            psm.setString(3,job);
//            psm.setString(4,name);
//            psm.execute();
//            msg="payment added successfully";
//        } catch (Exception e) {
//            e.printStackTrace();
//            msg="payment added error";
//        }
        return msg;
    }

    public String loadAbsentDays(String name, String month, String paid, String job,String year) {
        String msg = "";
        int days = getAbsentDays(name, month);
        int updateddate = days - 1;
        double castedpaid = Double.parseDouble(paid);

        if (days > 1) {
            double monthlyValue = castedpaid / 30;
            double absentamount = monthlyValue * updateddate;
            double finalamount = castedpaid - absentamount;
            String castedfinalamount = String.valueOf(finalamount);
            String query = "insert into staff_payments(month,paid_amount,id_role,staff_id_staff,year)values(?,?,?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, month);
                psm.setString(2, castedfinalamount);
                psm.setString(3, job);
                psm.setString(4, name);
                psm.setString(5, year);
                psm.execute();
                msg = "payment added successfully";
            } catch (Exception e) {
                e.printStackTrace();
                log.debug(e.getMessage());
                msg = "payment added error";
            }
        } else {
            String query = "insert into staff_payments(month,paid_amount,id_role,staff_id_staff,year)values(?,?,?,?,?)";

            try {
                PreparedStatement psm = conn.prepareStatement(query);
                psm.setString(1, month);
                psm.setString(2, paid);
                psm.setString(3, job);
                psm.setString(4, name);
                psm.setString(5, year);
                psm.execute();
                msg = "payment added successfully";
            } catch (Exception e) {
                e.printStackTrace();
                log.debug(e.getMessage());
                msg = "payment added error";
            }
        }
        return msg;
    }

    private int getAbsentDays(String staff_id, String month) {
        int msg = 0;
        String status = "absent";
        String query = "select * from staff_attendance where staff_id_staff='" + staff_id + "' AND month='" + month + "' AND attend_status='" + status + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            int days = 0;
            while (rs.next()) {
                days = days + 1;
                msg = days;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String loadbasicPayment(String s1) {
        String msg = "";
        String query = "select * from staff_salaries where id_role='" + s1 + "'";
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            while (rs.next()) {
                String payment = rs.getString("amount");
                msg = payment;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }

    public String getPaymentYear(String resultf) {
    String msg="";
    String query="select * from staff_payments where id_payments ='"+resultf+"'";
    
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            String year=rs.getString("year");
            msg=year;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
        return msg;
    }
    
    
    public void loadPaymentTableYear(String keyword, DefaultTableModel dtm) {
        String query = "select id_payments,month,paid_amount,role_name,full_name from staff_payments \n"
                + "join staff on staff_payments.staff_id_staff = staff.id_staff\n"
                + "join staff_job_role on staff_payments.id_role = staff_job_role.id_role \n"
                + "where staff_payments.year = '" + keyword + "' ";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                String id = rs.getString("id_payments");
                String name = rs.getString("full_name");
                String role = rs.getString("role_name");
                String month = rs.getString("month");
                String paid_amount = rs.getString("paid_amount");
                dataRow = new String[5];
                dataRow[0] = id;
                dataRow[1] = name;
                dataRow[2] = role;
                dataRow[3] = month;
                dataRow[4] = paid_amount;
                dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }
}
