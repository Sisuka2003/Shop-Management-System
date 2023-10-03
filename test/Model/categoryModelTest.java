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
public class categoryModelTest {
    
    public categoryModelTest() {
    }
    

    /**
     * Test of loadCategoryTable method, of class categoryModel.
     */
    @Test
    public void testLoadCategoryTable() {
        System.out.println("loadCategoryTable");
        String string = "Animal carvings";
        DefaultTableModel dtm = null;
        categoryModel instance = new categoryModel();
        instance.loadCategoryTable(string, dtm);
    }

    /**
     * Test of cat_reg method, of class categoryModel.
     */
    @Test
    public void testCat_reg() {
        System.out.println("cat_reg");
        String name = "Statue carvings";
        categoryModel instance = new categoryModel();
        String expResult = "cat added succesfully";
        String result = instance.cat_reg(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of cat_update method, of class categoryModel.
     */
    @Test
    public void testCat_update() {
        System.out.println("cat_update");
        String id = "1";
        String name = "Animal carving";
        categoryModel instance = new categoryModel();
        String expResult = "cat updated succesfully";
        String result = instance.cat_update(id, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of cat_delete method, of class categoryModel.
     */
    @Test
    public void testCat_delete() {
        System.out.println("cat_delete");
        String id = "1";
        categoryModel instance = new categoryModel();
        String expResult = "cat deleted succesfully";
        String result = instance.cat_delete(id);
        assertEquals(expResult, result);
    }
    
}
