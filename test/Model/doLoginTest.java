/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DELL
 */
public class doLoginTest {
    
    public doLoginTest() {
    }
    

    /**
     * Test of doLogin method, of class doLogin.
     */
    @Test
    public void testDoLogin() {
        System.out.println("doLogin");
        String username = "Lanka Carvings";
        String password = "lk1234";
        doLogin instance = new doLogin();
        String expResult = "Logged In Successfully";
        String result = instance.doLogin(username, password);
        assertEquals(expResult, result);
    }
    
}
