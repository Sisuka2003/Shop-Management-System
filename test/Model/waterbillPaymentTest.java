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
public class waterbillPaymentTest {
    
    public waterbillPaymentTest() {
    }
    
    /**
     * Test of loadWaterBillTable method, of class waterbillPayment.
     */
    @Test
    public void testLoadWaterBillTable() {
        System.out.println("loadWaterBillTable");
        String string = "june";
        DefaultTableModel dtm = null;
        waterbillPayment instance = new waterbillPayment();
        instance.loadWaterBillTable(string, dtm);
    }

    /**
     * Test of loadWaterBillTableOnYear method, of class waterbillPayment.
     */
    @Test
    public void testLoadWaterBillTableOnYear() {
        System.out.println("loadWaterBillTableOnYear");
        String string = "2021";
        DefaultTableModel dtm = null;
        waterbillPayment instance = new waterbillPayment();
        instance.loadWaterBillTableOnYear(string, dtm);
    }

    /**
     * Test of waterbill_register method, of class waterbillPayment.
     */
    @Test
    public void testWaterbill_register() {
        System.out.println("waterbill_register");
        String status = "july";
        String amount = "5000";
        String year = "2021";
        waterbillPayment instance = new waterbillPayment();
        String expResult = "Waterbill added successfully";
        String result = instance.waterbill_register(status, amount, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of waterbill_update method, of class waterbillPayment.
     */
    @Test
    public void testWaterbill_update() {
        System.out.println("waterbill_update");
        String status = "july";
        String amount = "5500";
        String id = "4";
        waterbillPayment instance = new waterbillPayment();
        String expResult = "Waterbill Payment update successfully";
        String result = instance.waterbill_update(status, amount, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of waterbill_delete method, of class waterbillPayment.
     */
    @Test
    public void testWaterbill_delete() {
        System.out.println("waterbill_delete");
        String id = "4";
        waterbillPayment instance = new waterbillPayment();
        String expResult = "Waterbill Payment deleted successfully";
        String result = instance.waterbill_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of priceRangerLoad method, of class waterbillPayment.
     */
    @Test
    public void testPriceRangerLoad() {
        System.out.println("priceRangerLoad");
        String value1 = "1000";
        String value2 = "100000";
        DefaultTableModel dtm2 = null;
        waterbillPayment instance = new waterbillPayment();
        instance.priceRangerLoad(value1, value2, dtm2);
    }

    /**
     * Test of loader method, of class waterbillPayment.
     */
    @Test
    public void testLoader() {
        System.out.println("loader");
        DefaultTableModel dtm3 = null;
        waterbillPayment instance = new waterbillPayment();
        instance.loader(dtm3);
    }
    
}
