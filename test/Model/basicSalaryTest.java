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
public class basicSalaryTest {
    
    public basicSalaryTest() {
    }

    /**
     * Test of loadSalaryTable method, of class basicSalary.
     */
    @Test
    public void testLoadSalaryTable() {
        System.out.println("loadSalaryTable");
        String string = "manager";
        DefaultTableModel dtm = null;
        basicSalary instance = new basicSalary();
        instance.loadSalaryTable(string, dtm);
    }

    /**
     * Test of loadJobRoleTable method, of class basicSalary.
     */
    @Test
    public void testLoadJobRoleTable() {
        System.out.println("loadJobRoleTable");
        String keyword = "manager";
        DefaultTableModel dtm2 = null;
        basicSalary instance = new basicSalary();
        instance.loadJobRoleTable(keyword, dtm2);
    }

    /**
     * Test of salary_register method, of class basicSalary.
     */
    @Test
    public void testSalary_register() {
        System.out.println("salary_register");
        String amount = "100000";
        String job = "1";
        basicSalary instance = new basicSalary();
        String expResult = "Basic sallary added successfully";
        String result = instance.salary_register(amount, job);
        assertEquals(expResult, result);
    }

    /**
     * Test of getJobId method, of class basicSalary.
     */
    @Test
    public void testGetJobId() {
        System.out.println("getJobId");
        String s4 = "manager";
        basicSalary instance = new basicSalary();
        String expResult = "2";
        String result = instance.getJobId(s4);
        assertEquals(expResult, result);
    }

    /**
     * Test of salary_update method, of class basicSalary.
     */
    @Test
    public void testSalary_update() {
        System.out.println("salary_update");
        String id = "1";
        String amount = "40000";
        String job = "2";
        basicSalary instance = new basicSalary();
        String expResult = "basic salary updated successfully";
        String result = instance.salary_update(id, amount, job);
        assertEquals(expResult, result);
    }

    /**
     * Test of salary_delete method, of class basicSalary.
     */
    @Test
    public void testSalary_delete() {
        System.out.println("salary_delete");
        String id = "1";
        basicSalary instance = new basicSalary();
        String expResult = "basic salary deleted successfully";
        String result = instance.salary_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadSalaryTableAmount method, of class basicSalary.
     */
    @Test
    public void testLoadSalaryTableAmount() {
        System.out.println("loadSalaryTableAmount");
        String keyword = "40000";
        DefaultTableModel dtm = null;
        basicSalary instance = new basicSalary();
        instance.loadSalaryTableAmount(keyword, dtm);
    }
    
}
