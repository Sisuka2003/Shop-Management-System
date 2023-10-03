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
public class jobModelTest {
    
    public jobModelTest() {
    }

    /**
     * Test of loadJobRoleTable method, of class jobModel.
     */
    @Test
    public void testLoadJobRoleTable() {
        System.out.println("loadJobRoleTable");
        String keyword = "manager";
        DefaultTableModel dtm2 = null;
        jobModel instance = new jobModel();
        instance.loadJobRoleTable(keyword, dtm2);
    }

    /**
     * Test of job_reg method, of class jobModel.
     */
    @Test
    public void testJob_reg() {
        System.out.println("job_reg");
        String name = "HR manager";
        jobModel instance = new jobModel();
        String expResult = "job added succesfully";
        String result = instance.job_reg(name);
        assertEquals(expResult, result);
    }

    /**
     * Test of job_update method, of class jobModel.
     */
    @Test
    public void testJob_update() {
        System.out.println("job_update");
        String id = "4";
        String name = "stock keepers";
        jobModel instance = new jobModel();
        String expResult = "job updated succesfully";
        String result = instance.job_update(id, name);
        assertEquals(expResult, result);
    }

    /**
     * Test of job_delete method, of class jobModel.
     */
    @Test
    public void testJob_delete() {
        System.out.println("job_delete");
        String id = "6";
        jobModel instance = new jobModel();
        String expResult = "job deleted succesfully";
        String result = instance.job_delete(id);
        assertEquals(expResult, result);
    }
    
}
