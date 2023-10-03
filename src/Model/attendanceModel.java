/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import GUI.login;
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
public class attendanceModel {
    
    static Logger log = Logger.getLogger(attendanceModel.class.getName());
    Connection conn;
    
    public attendanceModel(){
     conn=db.dbConnection.getConnection();
    }
    
    public void loadAttendanceTable(String keyword, DefaultTableModel dtm) {
              String query="select * from staff join staff_attendance on staff.id_staff =staff_attendance.staff_id_staff where date LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String atid= rs.getString("id_attendance");
            String name=rs.getString("full_name");
            String nic=rs.getString("nic");
            String date=rs.getString("date");
           String attendace= rs.getString("attend_status");
           String checkin= rs.getString("check_in");
           String checkout= rs.getString("check_out");
             dataRow = new String[7];
             dataRow[0] = atid;
             dataRow[1] = nic;
             dataRow[2] = name;
             dataRow[3]=checkin;
             dataRow[4]=checkout;
             dataRow[5] = date;
             dataRow[6] = attendace;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }
    
    public void loadAttendanceTableOnName(String keyword, String dates,DefaultTableModel dtm) {
              String query="select * from staff join staff_attendance on staff.id_staff =staff_attendance.staff_id_staff where staff.full_name like '%"+keyword+"%' AND staff_attendance.date ='"+dates+"'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String atid= rs.getString("id_attendance");
            String name=rs.getString("full_name");
            String nic=rs.getString("nic");
            String date=rs.getString("date");
           String attendace= rs.getString("attend_status");
           String checkin= rs.getString("check_in");
           String checkout= rs.getString("check_out");
             dataRow = new String[7];
             dataRow[0] = atid;
             dataRow[1] = nic;
             dataRow[2] = name;
             dataRow[3]=checkin;
             dataRow[4]=checkout;
             dataRow[5] = date;
             dataRow[6] = attendace;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }
    
       public void loadStaffTable(String keyword, DefaultTableModel dtm) {
      String query="select id_staff,full_name,mobile,nic,role_name from staff join staff_job_role on staff.id_role = staff_job_role.id_role WHERE staff.full_name LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String staffid= rs.getString("id_staff");
            String name=rs.getString("full_name");
            String mobile=rs.getString("mobile");
            String nic=rs.getString("nic");
           String role= rs.getString("role_name");
             dataRow = new String[5];
             dataRow[0] = staffid;
             dataRow[1] = name;
             dataRow[2] = mobile;
             dataRow[3] = nic;
             dataRow[4] = role;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }
       
       
    public String getStaffID(String s4) {
     String msg="";
     String query="SELECT id_staff FROM staff where nic LIKE '%"+s4+"%'";
       try {
            Connection connection=db.dbConnection.getConnection();
            Statement stm = connection.createStatement();
            ResultSet rs= stm.executeQuery(query);
            while(rs.next()){
           String staffid= rs.getString("id_staff");
            msg=staffid;
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }   
       return msg;
    }

    public String attendance_register(String name, String date, String status,String month) {
        String msg="";
        String query="INSERT INTO staff_attendance(date,month,attend_status,staff_id_staff,check_in,check_out)VALUES(?,?,?,?,now(),?)";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            
            psm.setString(1,date);
            psm.setString(2,month);
            psm.setString(3,status);
            psm.setString(4,name);
            psm.setString(5,null);
            psm.execute();
            msg="attendance added succesfully";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        msg="attendance adding error";
        }
       return msg;
    }
    
    
    
    
    
    
    public String attendance_update(String name, String date, String id,String month) {
    String msg="";
    String query="UPDATE staff_attendance SET date=?,month=?,staff_id_staff=? WHERE id_attendance=?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,date);
            psm.setString(2,month);
            psm.setString(3,name);
            psm.setString(4,id);
            psm.execute();
           msg="Attendance Update Success"; 
        } catch (Exception e) {
            e.printStackTrace();
        log.debug(e.getMessage());
            msg="Attendace update Failed";
        }
        return msg;
    }

    public String attendance_delete(String id) {
       String msg="";
       String query="DELETE FROM staff_attendance WHERE id_attendance =?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1, id);
            psm.execute();
            msg="attendance deleted succesfully";
        } catch (Exception e) {
            e.printStackTrace();
        log.debug(e.getMessage());
            msg="attendance deleting error";
        }
        return msg;
    }

    public void loadAttendanceTableNIC(String keyword,String dates, DefaultTableModel dtm) {
      String query="select * from staff join staff_attendance on staff.id_staff =staff_attendance.staff_id_staff where staff.full_name like '%"+keyword+"%' AND staff_attendance.date ='"+dates+"'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String atid= rs.getString("id_attendance");
            String name=rs.getString("full_name");
            String nic=rs.getString("nic");
            String checkin=rs.getString("check_in");
            String checkout=rs.getString("check_out");
            String date=rs.getString("date");
           String attendace= rs.getString("attend_status");
             dataRow = new String[7];
              dataRow[0] = atid;
             dataRow[1] = nic;
             dataRow[2] = name;
             dataRow[3]=checkin;
             dataRow[4]=checkout;
             dataRow[5] = date;
             dataRow[6] = attendace;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }

    public void loadAttendanceTableDATE(String keyword, DefaultTableModel dtm) {
              String query="select * from staff join staff_attendance on staff.id_staff =staff_attendance.staff_id_staff where staff_attendance.date LIKE '%"+keyword+"%'";
      dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs= stm.executeQuery(query);
            String[] dataRow;
            while(rs.next()){
           String atid= rs.getString("id_attendance");
            String name=rs.getString("full_name");
            String nic=rs.getString("nic");
            String checkin=rs.getString("check_in");
            String checkout=rs.getString("check_out");
            String date=rs.getString("date");
           String attendace= rs.getString("attend_status");
             dataRow = new String[7];
              dataRow[0] = atid;
             dataRow[1] = nic;
             dataRow[2] = name;
             dataRow[3]=checkin;
             dataRow[4]=checkout;
             dataRow[5] = date;
             dataRow[6] = attendace;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }

    public String check_out_attendance(String name, String date) {
    String msg="";
    String query="update staff_attendance set check_out = now() where date=? AND staff_id_staff=?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,date);
            psm.setString(2,name);
            psm.execute();
            msg="check out success";
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
            msg="check out error";
        }
    return msg;
    }

    public String attendance_search(String name, String date) {
      String msg="";
      String query="select ROUND(TIMESTAMPDIFF(minute,check_in,check_out)/60,2) AS FractHours from staff_attendance where date='"+date+"' AND staff_id_staff='"+name+"'";
        try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            Double timeDiff=Double.parseDouble(rs.getString("FractHours"));
                System.out.println(timeDiff);
            String sts="";
            if(timeDiff==4){
            sts="Half Day";
                System.out.println("half day");
            }else if(timeDiff<4){
            sts="Absent";
                System.out.println("Absent");
            }else if(timeDiff >= 8){
            sts="Present";
                    System.out.println("present");
            }
            msg=sts;
            } 
        } catch (Exception e) {
    e.printStackTrace();
            System.out.println("error");
    log.debug(e.getMessage());
        }
      return msg;
    }

    
    public String getCheckInTime(String name, String date) {
       String msg="";
       String query="select ROUND(check_in/60,2) AS CheckTime from staff_attendance where date ='"+date+"' AND staff_id_staff='"+name+"'";
          try {
            Statement stm=conn.createStatement();
            ResultSet rs=stm.executeQuery(query);
            while(rs.next()){
            Double checkDiff=Double.parseDouble(rs.getString("CheckTime"));
                System.out.println(checkDiff);
            String sts="";
            if(checkDiff>8.5){
                System.out.println(checkDiff);
            sts="Late comer";
                System.out.println("Late comer");
            }
            msg=sts;
            } 
        } catch (Exception e) {
    e.printStackTrace();
    log.debug(e.getMessage());
        }
        return msg;
    }
    
    public void attendance_late_comers(String name, String date,String latecomers) {
       String query="update staff_attendance set attend_status=? where staff_id_staff=? AND date =?";
       
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,latecomers);
            psm.setString(2,name);
            psm.setString(3,date);
            psm.execute();
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }

    public void update_attendance(String name, String date, String result2) {
     String query="update staff_attendance set attend_status=? where staff_id_staff=? AND date=?";
        try {
            PreparedStatement psm=conn.prepareStatement(query);
            psm.setString(1,result2);
            psm.setString(2,name);
            psm.setString(3,date);
            psm.execute();
        } catch (Exception e) {
        e.printStackTrace();
        log.debug(e.getMessage());
        }
    }

    public void dateRangeLoader(String val1, DefaultTableModel dtm) {
           String query = "SELECT * FROM staff_attendance join staff on staff_attendance.staff_id_staff =staff.id_staff  WHERE staff_attendance.month = '"+val1+"'";
        dtm.setRowCount(0);
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            String[] dataRow;
            while (rs.next()) {
                 String atid= rs.getString("id_attendance");
            String name=rs.getString("full_name");
            String nic=rs.getString("nic");
            String date=rs.getString("date");
           String attendace= rs.getString("attend_status");
           String checkin= rs.getString("check_in");
           String checkout= rs.getString("check_out");
             dataRow = new String[7];
             dataRow[0] = atid;
             dataRow[1] = nic;
             dataRow[2] = name;
             dataRow[3]=checkin;
             dataRow[4]=checkout;
             dataRow[5] = date;
             dataRow[6] = attendace;
             dtm.addRow(dataRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }


}
