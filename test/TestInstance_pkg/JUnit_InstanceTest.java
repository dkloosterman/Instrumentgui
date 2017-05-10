/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestInstance_pkg;

import Cartridge_pkg.Cartridge;
import Instrument_pkg.Instrument;
import JDBCqueries_pkg.JDBCqueries;
import java.sql.*;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author David Kloosterman
 */
public class JUnit_InstanceTest {

//    // JDBC driver name and database URL
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/sensodx_sql_db?useSSL=false";
//
//    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "rootMysql151";
//
//    Connection conn = null;
//    String sql = null;
//    Statement stmt = null;
//    ResultSet rs = null;

//    Instrument instrumentForCardiacWellness;
    static final String CARDIACWELLNESSINSTRUMENT = "2017040300001";

//    Instrument instrumentForOralCancer;
    static final String ORALCANCERINSTRUMENT = "2017040300002";

//    Cartridge cartridge1;
    static final String CARTRIDGE_ID = "20170501085526994";

    JDBCqueries queries = null;

    public JUnit_InstanceTest() {

        this.queries = new JDBCqueries();
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass");

    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass");
    }

    @Before
    public void setUp() {
        System.out.println("Before");
    }

    @After
    public void tearDown() {
        System.out.println("After");
    }

    /**
     * Test of processTest method, of class TestInstance.
     */
    @Test
    public void testProcessTest() {
        System.out.println("processTest");

        Instrument instrumentForCardiacWellness = new Instrument();
        Instrument instrumentForOralCancer = new Instrument();
        Cartridge cartridge1 = new Cartridge();

        TestInstance instance = new TestInstance();

        queries.getInstrumentMfgInfo(CARDIACWELLNESSINSTRUMENT, instrumentForCardiacWellness);
        queries.getInstrumentDeploymentInfo(CARDIACWELLNESSINSTRUMENT, instrumentForCardiacWellness);
        queries.getCartridgeMfgInfo(CARTRIDGE_ID, cartridge1);

        boolean expResult;
        boolean result;
        
        expResult = true;
        result = instance.processTest(instrumentForCardiacWellness, cartridge1);
        System.out.println("Test 1: " + result);
        System.out.println(cartridge1.toString());
        System.out.println(instrumentForCardiacWellness.toString());
        assertFalse(instance.processTest(instrumentForCardiacWellness, cartridge1));
        
       
//        expResult = false;
//        result = instance.processTest(instrumentForOralCancer, cartridge1);
//        System.out.println("Test 2: " + result);
//        assertTrue(instance.processTest(instrumentForOralCancer, cartridge1));
    }

}
