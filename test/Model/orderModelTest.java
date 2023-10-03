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
public class orderModelTest {
    
    public orderModelTest() {
    }
    
    /**
     * Test of loadOrderTable method, of class orderModel.
     */
    @Test
    public void testLoadOrderTable() {
        System.out.println("loadOrderTable");
        String string = "1";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadOrderTable(string, dtm);
    }

    /**
     * Test of loadProductTable method, of class orderModel.
     */
    @Test
    public void testLoadProductTable() {
        System.out.println("loadProductTable");
        String string = "001";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadProductTable(string, dtm);
    }

    /**
     * Test of order_reg method, of class orderModel.
     */
    @Test
    public void testOrder_reg() {
        System.out.println("order_reg");
        String oid = "2";
        String id = "7";
        String company = "Laksala woods (PVT).LTD";
        String qty = "50";
        String uprice = "1200";
        String castedAmount = "12200";
        String name = "4";
        orderModel instance = new orderModel();
        String expResult = "order added succesfully";
        String result = instance.order_reg(oid, id, company, qty, uprice, castedAmount, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductName method, of class orderModel.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        String id = "4";
        orderModel instance = new orderModel();
        String expResult = "Fisherman carving";
        String result = instance.getProductName(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of order_update method, of class orderModel.
     */
    @Test
    public void testOrder_update() {
        System.out.println("order_update");
        String po = "4";
        String oid = "2";
        String pname = "4";
        String company = "Laksala woods (PVT).LTD";
        String qty = "10";
        String uprice = "1200";
        String castedAmount = "12000";
        String name = "Fisherman carving";
        orderModel instance = new orderModel();
        String expResult = "";
        String result = instance.order_update(po, oid, pname, company, qty, uprice, castedAmount, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductId method, of class orderModel.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        String name = "fisherman carving";
        orderModel instance = new orderModel();
        String expResult = "4";
        String result = instance.getProductId(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of order_delete method, of class orderModel.
     */
    @Test
    public void testOrder_delete() {
        System.out.println("order_delete");
        String oid = "6";
        orderModel instance = new orderModel();
        String expResult = "order deleting succesfully";
        String result = instance.order_delete(oid);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadOrderIdTable method, of class orderModel.
     */
    @Test
    public void testLoadOrderIdTable() {
        System.out.println("loadOrderIdTable");
        String string = "08 / 06 / 2021";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadOrderIdTable(string, dtm);
    }

    /**
     * Test of orderid_reg method, of class orderModel.
     */
    @Test
    public void testOrderid_reg() {
        System.out.println("orderid_reg");
        String date = "08 / 07 / 2021";
        orderModel instance = new orderModel();
        String expResult = "order id added succesfully";
        String result = instance.orderid_reg(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of orderid_update method, of class orderModel.
     */
    @Test
    public void testOrderid_update() {
        System.out.println("orderid_update");
        String id = "2";
        String date = "08 / 07 / 2020";
        orderModel instance = new orderModel();
        String expResult = "order id updating succesfully";
        String result = instance.orderid_update(id, date);
        assertEquals(expResult, result);
    }

    /**
     * Test of orderid_delete method, of class orderModel.
     */
    @Test
    public void testOrderid_delete() {
        System.out.println("orderid_delete");
        String id = "3";
        orderModel instance = new orderModel();
        String expResult = "order id deleted succesfully";
        String result = instance.orderid_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadOrderIDTableID method, of class orderModel.
     */
    @Test
    public void testLoadOrderIDTableID() {
        System.out.println("loadOrderIDTableID");
        String keyword = "";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadOrderIDTableID(keyword, dtm);
    }

    /**
     * Test of loadOrderedProductViewer method, of class orderModel.
     */
    @Test
    public void testLoadOrderedProductViewer() {
        System.out.println("loadOrderedProductViewer");
        String orderID = "";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadOrderedProductViewer(orderID, dtm);
    }

    /**
     * Test of loadTotalAmount method, of class orderModel.
     */
    @Test
    public void testLoadTotalAmount() {
        System.out.println("loadTotalAmount");
        String orderID = "";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        String expResult = "";
        String result = instance.loadTotalAmount(orderID, dtm);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadOrderedProductViewer2 method, of class orderModel.
     */
    @Test
    public void testLoadOrderedProductViewer2() {
        System.out.println("loadOrderedProductViewer2");
        String orderID = "";
        DefaultTableModel dtm = null;
        orderModel instance = new orderModel();
        instance.loadOrderedProductViewer2(orderID, dtm);
    }
    
}
