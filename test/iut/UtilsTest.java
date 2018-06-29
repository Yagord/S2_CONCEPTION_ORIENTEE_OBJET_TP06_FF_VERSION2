/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iut;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc260533
 */
public class UtilsTest {
    
    public UtilsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pgcd method, of class Utils.
     */
    @Test
    public void testPgcd() {
        System.out.println("pgcd");
        int a = 10;
        int b = 30;
        int expResult = 10;
        int result = Utils.pgcd(a, b);
        assertEquals(expResult, result);
        assertEquals(1, Utils.pgcd(10, 1));
        assertEquals(1, Utils.pgcd(3, 5));
        assertEquals(50, Utils.pgcd(150, 250));
    }
    
}
