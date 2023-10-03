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
public class invoiceModelTest {
    
    public invoiceModelTest() {
    }

    /**
     * Test of loadCustomerTable method, of class invoiceModel.
     */
    @Test
    public void testLoadCustomerTable() {
        System.out.println("loadCustomerTable");
        String string = "0773616815";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadCustomerTable(string, dtm);
    }

    /**
     * Test of loadInvoiceTable method, of class invoiceModel.
     */
    @Test
    public void testLoadInvoiceTable() {
        System.out.println("loadInvoiceTable");
        String string = "12 / 07 / 2021";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadInvoiceTable(string, dtm);
    }

    /**
     * Test of loadInvoiceTableCustomer method, of class invoiceModel.
     */
    @Test
    public void testLoadInvoiceTableCustomer() {
        System.out.println("loadInvoiceTableCustomer");
        String string = "Sisuka";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadInvoiceTableCustomer(string, dtm);
    }

    /**
     * Test of priceRangerLoad method, of class invoiceModel.
     */
    @Test
    public void testPriceRangerLoad() {
        System.out.println("priceRangerLoad");
        String value1 = "50000";
        String value2 = "100000";
        DefaultTableModel dtm2 = null;
        invoiceModel instance = new invoiceModel();
        instance.priceRangerLoad(value1, value2, dtm2);
    }

    /**
     * Test of invoice_reg method, of class invoiceModel.
     */
    @Test
    public void testInvoice_reg() {
        System.out.println("invoice_reg");
        String date = " 10 / 07 / 2021";
        String pay = "1000";
        String customer = "1";
        String month = "august";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice added successfully";
        String result = instance.invoice_reg(date, pay, customer, month);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadProductTable method, of class invoiceModel.
     */
    @Test
    public void testLoadProductTable() {
        System.out.println("loadProductTable");
        String string = "001";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadProductTable(string, dtm);
    }

    /**
     * Test of loadInvoiceItemTable method, of class invoiceModel.
     */
    @Test
    public void testLoadInvoiceItemTable() {
        System.out.println("loadInvoiceItemTable");
        String string = "12";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadInvoiceItemTable(string, dtm);
    }

    /**
     * Test of loadInvoiceItemTableOnProduct method, of class invoiceModel.
     */
    @Test
    public void testLoadInvoiceItemTableOnProduct() {
        System.out.println("loadInvoiceItemTableOnProduct");
        String string = "Elephant Carving";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadInvoiceItemTableOnProduct(string, dtm);
    }

    /**
     * Test of loadInvoiceItemsOnID method, of class invoiceModel.
     */
    @Test
    public void testLoadInvoiceItemsOnID() {
        System.out.println("loadInvoiceItemsOnID");
        String orderID = "12";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        instance.loadInvoiceItemsOnID(orderID, dtm);
    }

    /**
     * Test of loadTotalQty method, of class invoiceModel.
     */
    @Test
    public void testLoadTotalQty() {
        System.out.println("loadTotalQty");
        String orderID = "12";
        DefaultTableModel dtm = null;
        invoiceModel instance = new invoiceModel();
        String expResult = "27";
        String result = instance.loadTotalQty(orderID, dtm);
        assertEquals(expResult, result);
    }

    /**
     * Test of invoice_item_reg method, of class invoiceModel.
     */
    @Test
    public void testInvoice_item_reg() {
        System.out.println("invoice_item_reg");
        String qty = "1";
        String pid = "4";
        String invid = "12";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice item added successfully";
        String result = instance.invoice_item_reg(qty, pid, invid);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductId method, of class invoiceModel.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        String name = "Fisherman carving";
        invoiceModel instance = new invoiceModel();
        String expResult = "4";
        String result = instance.getProductId(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of invoice_update method, of class invoiceModel.
     */
    @Test
    public void testInvoice_update() {
        System.out.println("invoice_update");
        String date = "12 / 07 / 2021";
        String pay = "70600";
        String id = "12";
        String customer = "1";
        String month = "july";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice updated successfully";
        String result = instance.invoice_update(date, pay, id, customer, month);
        assertEquals(expResult, result);
    }

    /**
     * Test of invoice_item_update method, of class invoiceModel.
     */
    @Test
    public void testInvoice_item_update() {
        System.out.println("invoice_item_update");
        String qty = "9";
        String pid = "1";
        String invid = "12";
        String id = "20";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice item updated successfully";
        String result = instance.invoice_item_update(qty, pid, invid, id);
        assertEquals(expResult, result);
    }

    /**
     * Test of invoice_delete method, of class invoiceModel.
     */
    @Test
    public void testInvoice_delete() {
        System.out.println("invoice_delete");
        String id = "13";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice deleted successfully";
        String result = instance.invoice_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of invoice_cancel method, of class invoiceModel.
     */
    @Test
    public void testInvoice_cancel() {
        System.out.println("invoice_cancel");
        String id = "14";
        invoiceModel instance = new invoiceModel();
        String expResult = "invoice Canceled successfully";
        String result = instance.invoice_cancel(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomerID method, of class invoiceModel.
     */
    @Test
    public void testGetCustomerID() {
        System.out.println("getCustomerID");
        String valueOf = "Sisuka";
        invoiceModel instance = new invoiceModel();
        String expResult = "1";
        String result = instance.getCustomerID(valueOf);
        assertEquals(expResult, result);
    }
    
}
