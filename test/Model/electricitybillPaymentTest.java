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
public class electricitybillPaymentTest {
    
    public electricitybillPaymentTest() {
    }
    
    /**
     * Test of loadElectricBillTable method, of class electricitybillPayment.
     */
    @Test
    public void testLoadElectricBillTable() {
        System.out.println("loadElectricBillTable");
        String string = "January";
        DefaultTableModel dtm = null;
        electricitybillPayment instance = new electricitybillPayment();
        instance.loadElectricBillTable(string, dtm);
    }

    /**
     * Test of loadElectricBillTableOnYear method, of class electricitybillPayment.
     */
    @Test
    public void testLoadElectricBillTableOnYear() {
        System.out.println("loadElectricBillTableOnYear");
        String string = "2021";
        DefaultTableModel dtm = null;
        electricitybillPayment instance = new electricitybillPayment();
        instance.loadElectricBillTableOnYear(string, dtm);
    }

    /**
     * Test of electricitybill_register method, of class electricitybillPayment.
     */
    @Test
    public void testElectricitybill_register() {
        System.out.println("electricitybill_register");
        String status = "december";
        String amount = "50";
        String year = "2021";
        electricitybillPayment instance = new electricitybillPayment();
        String expResult = "electricitybill added successfully";
        String result = instance.electricitybill_register(status, amount, year);
        assertEquals(expResult, result);
    }

    /**
     * Test of electricitybill_update method, of class electricitybillPayment.
     */
    @Test
    public void testElectricitybill_update() {
        System.out.println("electricitybill_update");
        String status = "September";
        String amount = "1000";
        String id = "4";
        electricitybillPayment instance = new electricitybillPayment();
        String expResult = "electricitybill Payment update successfully";
        String result = instance.electricitybill_update(status, amount, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of electricitybill_delete method, of class electricitybillPayment.
     */
    @Test
    public void testElectricitybill_delete() {
        System.out.println("electricitybill_delete");
        String id = "4";
        electricitybillPayment instance = new electricitybillPayment();
        String expResult = "electricity Payment deleted successfully";
        String result = instance.electricitybill_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of priceRangerLoad method, of class electricitybillPayment.
     */
    @Test
    public void testPriceRangerLoad() {
        System.out.println("priceRangerLoad");
        String value1 = "9000";
        String value2 = "200000";
        DefaultTableModel dtm2 = null;
        electricitybillPayment instance = new electricitybillPayment();
        instance.priceRangerLoad(value1, value2, dtm2);
    }

    /**
     * Test of loader method, of class electricitybillPayment.
     */
    @Test
    public void testLoader() {
        System.out.println("loader");
        DefaultTableModel dtm3 = null;
        electricitybillPayment instance = new electricitybillPayment();
        instance.loader(dtm3);
    }
    
}
