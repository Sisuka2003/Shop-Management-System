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
public class productModelTest {
    
    public productModelTest() {
    }
    /**
     * Test of loadProductTable method, of class productModel.
     */
    @Test
    public void testLoadProductTable() {
        System.out.println("loadProductTable");
        String string = "001";
        DefaultTableModel dtm = null;
        productModel instance = new productModel();
        instance.loadProductTable(string, dtm);
    }

    /**
     * Test of loadProductTableOnCategory method, of class productModel.
     */
    @Test
    public void testLoadProductTableOnCategory() {
        System.out.println("loadProductTableOnCategory");
        String string = "Animal Carvings";
        DefaultTableModel dtm = null;
        productModel instance = new productModel();
        instance.loadProductTableOnCategory(string, dtm);
    }

    /**
     * Test of priceRangerLoad method, of class productModel.
     */
    @Test
    public void testPriceRangerLoad() {
        System.out.println("priceRangerLoad");
        String value1 = "1000";
        String value2 = "7000";
        DefaultTableModel dtm2 = null;
        productModel instance = new productModel();
        instance.priceRangerLoad(value1, value2, dtm2);
    }

    /**
     * Test of loadCategoryTable method, of class productModel.
     */
    @Test
    public void testLoadCategoryTable() {
        System.out.println("loadCategoryTable");
        String string = "Animal carvings";
        DefaultTableModel dtm2 = null;
        productModel instance = new productModel();
        instance.loadCategoryTable(string, dtm2);
    }

    /**
     * Test of product_register method, of class productModel.
     */
    @Test
    public void testProduct_register() {
        System.out.println("product_register");
        String name = "peacock carving";
        String barcode = "0025";
        String sell = "1200";
        String buy = "1000";
        String qty = "200";
        String category = "1";
        productModel instance = new productModel();
        String expResult = "product updated succesfully";
        String result = instance.product_register(name, barcode, sell, buy, qty, category);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryId method, of class productModel.
     */
    @Test
    public void testGetCategoryId() {
        System.out.println("getCategoryId");
        String valueOf = "Animal carving";
        productModel instance = new productModel();
        String expResult = "1";
        String result = instance.getCategoryId(valueOf);
        assertEquals(expResult, result);
    }

    /**
     * Test of product_update method, of class productModel.
     */
    @Test
    public void testProduct_update() {
        System.out.println("product_update");
        String id = "4";
        String name = "Fisherman carving";
        String sell = "1200";
        String buy = "1250";
        String qty = "349";
        String category = "2";
        productModel instance = new productModel();
        String expResult = "product updated succesfully";
        String result = instance.product_update(id, name, sell, buy, qty, category);
        assertEquals(expResult, result);
    }

    /**
     * Test of product_delete method, of class productModel.
     */
    @Test
    public void testProduct_delete() {
        System.out.println("product_delete");
        String id = "4";
        productModel instance = new productModel();
        String expResult = "product delete succesfully";
        String result = instance.product_delete(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of product_existance method, of class productModel.
     */
    @Test
    public void testProduct_existance() {
        System.out.println("product_existance");
        String barcode = "001";
        productModel instance = new productModel();
        String expResult = "product have";
        String result = instance.product_existance(barcode);
        assertEquals(expResult, result);
    }
    
}
