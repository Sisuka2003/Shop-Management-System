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
public class companyModelTest {
    
    public companyModelTest() {
    }
    

    /**
     * Test of companyTableLoad method, of class companyModel.
     */
    @Test
    public void testCompanyTableLoad() {
        System.out.println("companyTableLoad");
        String string = "Oak Raywood carvings";
        DefaultTableModel dtm = null;
        companyModel instance = new companyModel();
        instance.companyTableLoad(string, dtm);
    }

    /**
     * Test of company_reg method, of class companyModel.
     */
    @Test
    public void testCompany_reg() {
        System.out.println("company_reg");
        String name = "Laksal woods (PVT).LTD";
        String address = "Buthgamuwa Rd, IDH";
        String contact = "01134526333";
        companyModel instance = new companyModel();
        String expResult = "company added succesfully";
        String result = instance.company_reg(name, address, contact);
        assertEquals(expResult, result);
    }

    /**
     * Test of company_update method, of class companyModel.
     */
    @Test
    public void testCompany_update() {
        System.out.println("company_update");
        String id = "1";
        String name = "Oak Raywood carving";
        String address = "Rajagiriya";
        String contact = "0773616815";
        companyModel instance = new companyModel();
        String expResult = "company updated succesfully";
        String result = instance.company_update(id, name, address, contact);
        assertEquals(expResult, result);
    }

    /**
     * Test of company_delete method, of class companyModel.
     */
    @Test
    public void testCompany_delete() {
        System.out.println("company_delete");
        String id = "2";
        companyModel instance = new companyModel();
        String expResult = "company deleted succesfully";
        String result = instance.company_delete(id);
        assertEquals(expResult, result);
    }
    
}
