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
public class supplierSectionTest {
    
    public supplierSectionTest() {
    }
    
    /**
     * Test of loadSupplierTable method, of class supplierSection.
     */
    @Test
    public void testLoadSupplierTable() {
        System.out.println("loadSupplierTable");
        String string = "Oak Raywood carving";
        DefaultTableModel dtm = null;
        supplierSection instance = new supplierSection();
        instance.loadSupplierTable(string, dtm);
    }

    /**
     * Test of loadCompanyTable method, of class supplierSection.
     */
    @Test
    public void testLoadCompanyTable() {
        System.out.println("loadCompanyTable");
        String string = "Oak Raywood carving";
        DefaultTableModel dtm = null;
        supplierSection instance = new supplierSection();
        instance.loadCompanyTable(string, dtm);
    }

    /**
     * Test of supplier_reg method, of class supplierSection.
     */
    @Test
    public void testSupplier_reg() {
        System.out.println("supplier_reg");
        String name = "Chamuditha Rajakaruna";
        String company = "1";
        String contact = "0713456473";
        supplierSection instance = new supplierSection();
        String expResult = "supplier added succesfully";
        String result = instance.supplier_reg(name, company, contact);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompanyID method, of class supplierSection.
     */
    @Test
    public void testGetCompanyID() {
        System.out.println("getCompanyID");
        String name = "Oak Raywood carving";
        supplierSection instance = new supplierSection();
        String expResult = "1";
        String result = instance.getCompanyID(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of supplier_update method, of class supplierSection.
     */
    @Test
    public void testSupplier_update() {
        System.out.println("supplier_update");
        String name = "Chamuditha Rajakaruna";
        String company = "2";
        String number = "0713456473";
        String id = "6";
        supplierSection instance = new supplierSection();
        String expResult = "supplier updated succesfully";
        String result = instance.supplier_update(name, company, number, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of supplier_delete method, of class supplierSection.
     */
    @Test
    public void testSupplier_delete() {
        System.out.println("supplier_delete");
        String id = "6";
        supplierSection instance = new supplierSection();
        String expResult = "supplier delete succesfully";
        String result = instance.supplier_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadSupplierTableName method, of class supplierSection.
     */
    @Test
    public void testLoadSupplierTableName() {
        System.out.println("loadSupplierTableName");
        String keyword = "Harendra de silva";
        DefaultTableModel dtm = null;
        supplierSection instance = new supplierSection();
        instance.loadSupplierTableName(keyword, dtm);
    }

    /**
     * Test of loadSupplierTableMobile method, of class supplierSection.
     */
    @Test
    public void testLoadSupplierTableMobile() {
        System.out.println("loadSupplierTableMobile");
        String keyword = "0774563452";
        DefaultTableModel dtm = null;
        supplierSection instance = new supplierSection();
        instance.loadSupplierTableMobile(keyword, dtm);
    }
    
}
