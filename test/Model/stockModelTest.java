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
public class stockModelTest {
    
    public stockModelTest() {
    }

    /**
     * Test of loadStockTable method, of class stockModel.
     */
    @Test
    public void testLoadStockTable() {
        System.out.println("loadStockTable");
        String keyword = "Animal Carving";
        DefaultTableModel dtm = null;
        stockModel instance = new stockModel();
        instance.loadStockTable(keyword, dtm);
    }

    /**
     * Test of loadCategoryTable method, of class stockModel.
     */
    @Test
    public void testLoadCategoryTable() {
        System.out.println("loadCategoryTable");
        String string = "Animal Carving";
        DefaultTableModel dtm2 = null;
        stockModel instance = new stockModel();
        instance.loadCategoryTable(string, dtm2);
    }

    /**
     * Test of loadTotalStocks method, of class stockModel.
     */
    @Test
    public void testLoadTotalStocks() {
        System.out.println("loadTotalStocks");
        String s1 = "1";
        stockModel instance = new stockModel();
        String expResult = "530";
        String result = instance.loadTotalStocks(s1);
        assertEquals(expResult, result);
    }

    /**
     * Test of stock_reg method, of class stockModel.
     */
    @Test
    public void testStock_reg() {
        System.out.println("stock_reg");
        String name = "11";
        String stocks = "1";
        stockModel instance = new stockModel();
        String expResult = "stock added succesfully";
        String result = instance.stock_reg(name, stocks);
        assertEquals(expResult, result);
    }

    /**
     * Test of stock_update method, of class stockModel.
     */
    @Test
    public void testStock_update() {
        System.out.println("stock_update");
        String id = "4";
        String name = "www";
        String stocks = "12";
        stockModel instance = new stockModel();
        String expResult = "stock updating succesfully";
        String result = instance.stock_update(id, name, stocks);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCategoryID method, of class stockModel.
     */
    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        String name = "Animal carivng";
        stockModel instance = new stockModel();
        String expResult = "1";
        String result = instance.getCategoryID(name);
        assertEquals(expResult, result);
    }
    
}
