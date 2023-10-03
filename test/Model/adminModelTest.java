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
public class adminModelTest {
    
    public adminModelTest() {
    }
    /**
     * Test of loadAdminTable method, of class adminModel.
     */
    @Test
    public void testLoadAdminTable() {
        System.out.println("loadAdminTable");
        String keyword = "manager";
        DefaultTableModel dtm =null;
        adminModel instance = new adminModel();
        instance.loadAdminTable(keyword, dtm);
    }

    /**
     * Test of loadJobRoleTable method, of class adminModel.
     */
    @Test
    public void testLoadJobRoleTable() {
        System.out.println("loadJobRoleTable");
        String keyword = "manager";
        DefaultTableModel dtm2 = null;
        adminModel instance = new adminModel();
        instance.loadJobRoleTable(keyword, dtm2);
    }

    /**
     * Test of getJobId method, of class adminModel.
     */
    @Test
    public void testGetJobId() {
        System.out.println("getJobId");
        String s4 = "manager";
        adminModel instance = new adminModel();
        String expResult = "2";
        String result = instance.getJobId(s4);
        assertEquals(expResult, result);
    }

    /**
     * Test of admin_register method, of class adminModel.
     */
    @Test
    public void testAdmin_register() {
        System.out.println("admin_register");
        String name = "aaa";
        String pswd = "112233";
        String job = "2";
        adminModel instance = new adminModel();
        String expResult = "admin added succesfully";
        String result = instance.admin_register(name, pswd, job);
        assertEquals(expResult, result);
    }

    /**
     * Test of admin_update method, of class adminModel.
     */
    @Test
    public void testAdmin_update() {
        System.out.println("admin_update");
        String id = "9";
        String name = "aa123";
        String pswd = "123";
        String job = "3";
        adminModel instance = new adminModel();
        String expResult = "admin updated succesfully";
        String result = instance.admin_update(id, name, pswd, job);
        assertEquals(expResult, result);
    }

    /**
     * Test of admin_delete method, of class adminModel.
     */
    @Test
    public void testAdmin_delete() {
        System.out.println("admin_delete");
        String id = "9";
        adminModel instance = new adminModel();
        String expResult = "admin deleted succesfully";
        String result = instance.admin_delete(id);
        assertEquals(expResult, result);
    }
    
}
