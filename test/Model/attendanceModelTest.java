/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.swing.table.DefaultTableModel;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class attendanceModelTest {
    
    public attendanceModelTest() {
    }
    /**
     * Test of loadAttendanceTable method, of class attendanceModel.
     */
    @Test
    public void testLoadAttendanceTable() {
        System.out.println("loadAttendanceTable");
        String keyword = "Sisuka Weerasinghe";
        DefaultTableModel dtm = null;
        attendanceModel instance = new attendanceModel();
        instance.loadAttendanceTable(keyword, dtm);
    }

    /**
     * Test of loadStaffTable method, of class attendanceModel.
     */
    @Test
    public void testLoadStaffTable() {
        System.out.println("loadStaffTable");
        String keyword = "Sisuka Weerasinghe";
        DefaultTableModel dtm = null;
        attendanceModel instance = new attendanceModel();
        instance.loadStaffTable(keyword, dtm);
    }

    /**
     * Test of getStaffID method, of class attendanceModel.
     */
    @Test
    public void testGetStaffID() {
        System.out.println("getStaffID");
        String s4 = "200325300856";
        attendanceModel instance = new attendanceModel();
        String expResult = "1";
        String result = instance.getStaffID(s4);
        assertEquals(expResult, result);
    }

    /**
     * Test of attendance_register method, of class attendanceModel.
     */
    @Test
    public void testAttendance_register() {
        System.out.println("attendance_register");
        String name = "Sisuka Weerasinghe";
        String date = "7 / 14 / 2021";
        String status = "present";
        String month = "July";
        String checkin = "08:05:00";
        String checkout = "05:02:03";
        attendanceModel instance = new attendanceModel();
        String expResult = "attendance added succesfully";
        String result = instance.attendance_register(name, date, status, month);
        assertEquals(expResult, result);
    }

    /**
     * Test of attendance_update method, of class attendanceModel.
     */
    @Test
    public void testAttendance_update() {
        System.out.println("attendance_update");
        String name = "Sisuka Weerasinghe";
        String date = "7 / 14 / 2021";
        String status = "present";
        String id = "31";
        String month = "July";
        String checkin = "08:05:00";
        String checkout = "05:02:03";
        attendanceModel instance = new attendanceModel();
        String expResult = "Attendance Update Success";
        String result = instance.attendance_update(name, date, id, month);
        assertEquals(expResult, result);
    }

    /**
     * Test of attendance_delete method, of class attendanceModel.
     */
    @Test
    public void testAttendance_delete() {
        System.out.println("attendance_delete");
        String id = "31";
        attendanceModel instance = new attendanceModel();
        String expResult = "attendance deleted succesfully";
        String result = instance.attendance_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadAttendanceTableNIC method, of class attendanceModel.
     */
    @Test
    public void testLoadAttendanceTableNIC() {
        System.out.println("loadAttendanceTableNIC");
        String keyword = "200325300856";
        DefaultTableModel dtm = null;
        attendanceModel instance = new attendanceModel();
        instance.loadAttendanceTableNIC(keyword, dtm);
    }

    /**
     * Test of loadAttendanceTableDATE method, of class attendanceModel.
     */
    @Test
    public void testLoadAttendanceTableDATE() {
        System.out.println("loadAttendanceTableDATE");
        String keyword = "7 / 14 / 2021";
        DefaultTableModel dtm = null;
        attendanceModel instance = new attendanceModel();
        instance.loadAttendanceTableDATE(keyword, dtm);
    }
    
}
