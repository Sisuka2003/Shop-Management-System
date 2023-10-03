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
public class customerModelTest {
    
    public customerModelTest() {
    }

    /**
     * Test of loadCustomerTable method, of class customerModel.
     */
    @Test
    public void testLoadCustomerTable() {
        System.out.println("loadCustomerTable");
        String string = "0773616815";
        DefaultTableModel dtm = null;
        customerModel instance = new customerModel();
        instance.loadCustomerTable(string, dtm);
    }

    /**
     * Test of loadCustomerTableLname method, of class customerModel.
     */
    @Test
    public void testLoadCustomerTableLname() {
        System.out.println("loadCustomerTableLname");
        String string = "Weerasinghe";
        DefaultTableModel dtm = null;
        customerModel instance = new customerModel();
        instance.loadCustomerTableLname(string, dtm);
    }

    /**
     * Test of loadCustomerTableFname method, of class customerModel.
     */
    @Test
    public void testLoadCustomerTableFname() {
        System.out.println("loadCustomerTableFname");
        String string = "Sisuka";
        DefaultTableModel dtm = null;
        customerModel instance = new customerModel();
        instance.loadCustomerTableFname(string, dtm);
    }

    /**
     * Test of customer_reg method, of class customerModel.
     */
    @Test
    public void testCustomer_reg() {
        System.out.println("customer_reg");
        String fname = "Sithira";
        String lname = "Mihan";
        String mobile = "0701597176";
        customerModel instance = new customerModel();
        String expResult = "customer added successfully";
        String result = instance.customer_reg(fname, lname, mobile);
        assertEquals(expResult, result);
    }

    /**
     * Test of customer_update method, of class customerModel.
     */
    @Test
    public void testCustomer_update() {
        System.out.println("customer_update");
        String id = "2";
        String fname = "Damsith";
        String lname = "Dissanayake";
        String mobile = "0701597170";
        customerModel instance = new customerModel();
        String expResult = "customer updated successfully";
        String result = instance.customer_update(id, fname, lname, mobile);
        assertEquals(expResult, result);
    }

    /**
     * Test of customer_delete method, of class customerModel.
     */
    @Test
    public void testCustomer_delete() {
        System.out.println("customer_delete");
        String id = "3";
        customerModel instance = new customerModel();
        String expResult = "customer deleted successfully";
        String result = instance.customer_delete(id);
        assertEquals(expResult, result);
    }
    
}
