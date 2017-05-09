/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestInstance_pkg;

import Cartridge_pkg.Cartridge;
import Instrument_pkg.Instrument;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David Kloosterman
 */
public class JUnit_InstanceTest {
    
    public JUnit_InstanceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of processTest method, of class TestInstance.
     */
    @Test
    public void testProcessTest() {
        System.out.println("processTest");
        Instrument instrument = null;
        Cartridge cartridge = null;
        TestInstance instance = new TestInstance();
        boolean expResult = false;
        boolean result = instance.processTest(instrument, cartridge);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
