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
public class grnModelTest {
    
    public grnModelTest() {
    }
    
    /**
     * Test of loadSupplierTable method, of class grnModel.
     */
    @Test
    public void testLoadSupplierTable() {
        System.out.println("loadSupplierTable");
        String string = "Oak Raywood carving";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.loadSupplierTable(string, dtm);
    }

    /**
     * Test of companyTableLoad method, of class grnModel.
     */
    @Test
    public void testCompanyTableLoad() {
        System.out.println("companyTableLoad");
        String string = "Oak Raywood carving";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.companyTableLoad(string, dtm);
    }

    /**
     * Test of loadGrnTable method, of class grnModel.
     */
    @Test
    public void testLoadGrnTable() {
        System.out.println("loadGrnTable");
        String string = "14 / 07 / 2021";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.loadGrnTable(string, dtm);
    }

    /**
     * Test of grn_register method, of class grnModel.
     */
    @Test
    public void testGrn_register() {
        System.out.println("grn_register");
        String date = "14 / 07 / 2021";
        String payment = "200000";
        String supplier = "4";
        String company = "2";
        grnModel instance = new grnModel();
        String expResult = "GRN added Successfully";
        String result = instance.grn_register(date, payment, supplier, company);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadSuppilerNameRelatedCompany method, of class grnModel.
     */
    @Test
    public void testLoadSuppilerNameRelatedCompany() {
        System.out.println("loadSuppilerNameRelatedCompany");
        String s1 = "Harendra de silva";
        DefaultTableModel dtm3 = null;
        grnModel instance = new grnModel();
        instance.loadSuppilerNameRelatedCompany(s1, dtm3);
    }

    /**
     * Test of loadGrnItemTable method, of class grnModel.
     */
    @Test
    public void testLoadGrnItemTable() {
        System.out.println("loadGrnItemTable");
        String string = "4";
        DefaultTableModel dtm2 = null;
        grnModel instance = new grnModel();
        instance.loadGrnItemTable(string, dtm2);
    }

    /**
     * Test of getProductId method, of class grnModel.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        String product_name = "Elephant Carving";
        grnModel instance = new grnModel();
        String expResult = "1";
        String result = instance.getProductId(product_name);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadCategoryTable method, of class grnModel.
     */
    @Test
    public void testLoadCategoryTable() {
        System.out.println("loadCategoryTable");
        String string = "Animal carving";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.loadCategoryTable(string, dtm);
    }

    /**
     * Test of product_register method, of class grnModel.
     */
    @Test
    public void testProduct_register() {
        System.out.println("product_register");
        String pname = "peacock carving";
        String barcode = "004";
        String sell_price = "1300";
        String bprice = "1200";
        String qty = "500";
        String category = "1";
        String grn_no = "4";
        grnModel instance = new grnModel();
        String expResult = "";
        String result = instance.product_register(pname, barcode, sell_price, bprice, qty, category, grn_no);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select_grn_payments method, of class grnModel.
     */
    @Test
    public void testSelect_grn_payments() {
        System.out.println("select_grn_payments");
        String grn_no = "4";
        double payment = 0.0;
        grnModel instance = new grnModel();
        String expResult = "update success";
        String result = instance.select_grn_payments(grn_no, payment);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update_grn_payment method, of class grnModel.
     */
    @Test
    public void testUpdate_grn_payment() {
        System.out.println("update_grn_payment");
        String grn_no = "5";
        String payment = "1000";
        grnModel instance = new grnModel();
        String expResult = "update success";
        String result = instance.update_grn_payment(grn_no, payment);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadProductTable method, of class grnModel.
     */
    @Test
    public void testLoadProductTable() {
        System.out.println("loadProductTable");
        String string = "Elephant Carving";
        DefaultTableModel dtm4 = null;
        grnModel instance = new grnModel();
        instance.loadProductTable(string, dtm4);
    }

    /**
     * Test of getqty method, of class grnModel.
     */
    @Test
    public void testGetqty() {
        System.out.println("getqty");
        String pid = "1";
        grnModel instance = new grnModel();
        String expResult = "460";
        String result = instance.getqty(pid);
        assertEquals(expResult, result);
    }

    /**
     * Test of update_product_details method, of class grnModel.
     */
    @Test
    public void testUpdate_product_details() {
        System.out.println("update_product_details");
        String pname = "Fisherman carving";
        String sell_price = "1200";
        String bprice = "1250";
        String qty = "370";
        String category = "2";
        String grn_no = "4";
        String castedQty = "350";
        String pid = "4";
        grnModel instance = new grnModel();
        String expResult = "item added successfully";
        String result = instance.update_product_details(pname, sell_price, bprice, qty, category, grn_no, castedQty, pid);
        assertEquals(expResult, result);
    }

    /**
     * Test of grn_delete method, of class grnModel.
     */
    @Test
    public void testGrn_delete() {
        System.out.println("grn_delete");
        String grn_id = "4";
        grnModel instance = new grnModel();
        String expResult = "grn deleted successfully";
        String result = instance.grn_delete(grn_id);
        assertEquals(expResult, result);
    }

    /**
     * Test of loadGrnCompanyTable method, of class grnModel.
     */
    @Test
    public void testLoadGrnCompanyTable() {
        System.out.println("loadGrnCompanyTable");
        String keyword = "Oak Raywood carving";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.loadGrnCompanyTable(keyword, dtm);
    }

    /**
     * Test of loadGrnSupplierTable method, of class grnModel.
     */
    @Test
    public void testLoadGrnSupplierTable() {
        System.out.println("loadGrnSupplierTable");
        String keyword = "Surendra wickramasinghe";
        DefaultTableModel dtm = null;
        grnModel instance = new grnModel();
        instance.loadGrnSupplierTable(keyword, dtm);
    }

    /**
     * Test of loadGrnItemTableOnProduct method, of class grnModel.
     */
    @Test
    public void testLoadGrnItemTableOnProduct() {
        System.out.println("loadGrnItemTableOnProduct");
        String keyword ="Elephant Carving";
        DefaultTableModel dtm2 = null;
        grnModel instance = new grnModel();
        instance.loadGrnItemTableOnProduct(keyword, dtm2);
    }

    /**
     * Test of loadGrnItemTableOnCategory method, of class grnModel.
     */
    @Test
    public void testLoadGrnItemTableOnCategory() {
        System.out.println("loadGrnItemTableOnCategory");
        String keyword = "400";
        DefaultTableModel dtm2 = null;
        grnModel instance = new grnModel();
        instance.loadGrnItemTableOnCategory(keyword, dtm2);
    }

    /**
     * Test of loadGrnItemTableOnID method, of class grnModel.
     */
    @Test
    public void testLoadGrnItemTableOnID() {
        System.out.println("loadGrnItemTableOnID");
        String string = "4";
        DefaultTableModel dtm2 = null;
        grnModel instance = new grnModel();
        instance.loadGrnItemTableOnID(string, dtm2);
    }

    /**
     * Test of loadProductData method, of class grnModel.
     */
    @Test
    public void testLoadProductData() {
        System.out.println("loadProductData");
        String barcode = "001";
        grnModel instance = new grnModel();
        String expResult = "Elephant Carving";
        String result = instance.loadProductData(barcode);
        assertEquals(expResult, result);
    }

    /**
     * Test of grn_update method, of class grnModel.
     */
    @Test
    public void testGrn_update() {
        System.out.println("grn_update");
        String id = "6";
        String date = "14 / 07 / 2021";
        String payment = "500";
        String supplier = "3";
        String company = "1";
        grnModel instance = new grnModel();
        String expResult = "GRN updated Successfully";
        String result = instance.grn_update(id, date, payment, supplier, company);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSuppID method, of class grnModel.
     */
    @Test
    public void testGetSuppID() {
        System.out.println("getSuppID");
        String valueOf = "Surendra wickramasinghe";
        grnModel instance = new grnModel();
        String expResult = "4";
        String result = instance.getSuppID(valueOf);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCompanyID method, of class grnModel.
     */
    @Test
    public void testGetCompanyID() {
        System.out.println("getCompanyID");
        String name = "Oak Raywood carving";
        grnModel instance = new grnModel();
        String expResult = "1";
        String result = instance.getCompanyID(name);
        assertEquals(expResult, result);
    }
    
}
