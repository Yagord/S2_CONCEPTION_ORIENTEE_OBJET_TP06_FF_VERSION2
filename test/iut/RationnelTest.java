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
public class RationnelTest {
    
    public RationnelTest() {
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
     * Test of toString method, of class Rationnel.
     */
    
    /*
    Correction de la méthode toString :
    On enlève l’espace entre le numérateur et le "/".
    */
    @Test
    public void testToString() {
        System.out.println("toString");
        Rationnel instance = new Rationnel(3, 5);
        String expResult = "3/5";
        String result = instance.toString();
        assertEquals(expResult, result);
        assertEquals("3/5", new Rationnel(30, 50).toString());
        assertEquals("5/1", new Rationnel(5).toString());
    }

    /**
     * Test of ajouter method, of class Rationnel.
     */
    
    /*
    Correction de la méthode ajouter :
    On écrit : this.dénominateur = this.dénominateur * r.dénominateur;
    Au lieu de : this.dénominateur = this.dénominateur * this.dénominateur;
    La valeur du dénominateur était égale à la valeur du dénominateur d'une des deux fractions au carré.
    */
    @Test
    public void testAjouter() {
        System.out.println("ajouter");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = new Rationnel(1, 4);
        instance.ajouter(r);
        String expResult = "3/4";
        String result = instance.toString();
        
        Rationnel r2 = new Rationnel(1, 4);
        Rationnel instance2 = new Rationnel(23, 4);
        instance2.ajouter(r2);
        String expResult2 = "6/1";
        String result2 = instance2.toString();
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of multiplier method, of class Rationnel.
     */
    @Test
    public void testMultiplier() {
        System.out.println("multiplier");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = new Rationnel(1, 4);
        instance.multiplier(r);
        String expResult = "1/8";
        String result = instance.toString();
        
        Rationnel r2 = new Rationnel(30, 10);
        Rationnel instance2 = new Rationnel(2, 3);
        instance2.multiplier(r2);
        String expResult2 = "2/1";
        String result2 = instance2.toString();
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of estEgal method, of class Rationnel.
     */
    @Test
    public void testEstEgal() {
        System.out.println("estEgal");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = new Rationnel(2, 4);
        boolean expResult = true;
        boolean result = instance.estEgal(r);
        assertEquals(expResult, result);
    }

    /**
     * Test of estInférieur method, of class Rationnel.
     */
    
    /*
    Correction de la méthode estInférieur :
    Question 4 : On écrit : return this.toDouble() < r.toDouble();
    Le numérateur et le dénominateur étant des entiers le résultat de la division était un entier.
    Ce qui peut poser problème.
    On utilise donc la méthode toDouble() pour caster le numérateur et le numérateur en double.
    
    Question 6 : On écrit : return (this.numérateur * r.dénominateur) < (this.dénominateur * r.numérateur);
    Il reste un problème car on fait une approximation avec un double.
    Donc on utilise un produit encroix avec des entiers.
    */
    @Test
    public void testEstInférieur() {
        System.out.println("estInf\u00e9rieur");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = new Rationnel(1, 4);
        boolean expResult = true;
        boolean result = instance.estInférieur(r);
        
        Rationnel r2 = new Rationnel(8, 4);
        Rationnel instance2 = new Rationnel(15, 3);
        boolean expResult2 = false;
        boolean result2 = instance2.estInférieur(r2);
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of toDouble method, of class Rationnel.
     */
    @Test
    public void testToDouble() {
        System.out.println("toDouble");
        Rationnel instance = new Rationnel(1, 2);
        double expResult = 1.0/2.0;
        double result = instance.toDouble();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of equals method, of class Rationnel.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = r;
        boolean expResult = true;
        boolean result = instance.equals(r);
        
        Rationnel r2 = new Rationnel(1, 2);
        Rationnel instance2 = new Rationnel(1, 2);
        boolean expResult2 = true;
        boolean result2 = instance2.equals(r2);
        
        Rationnel r3 = new Rationnel(1, 2);
        Rationnel instance3 = new Rationnel(1, 3);
        boolean expResult3 = false;
        boolean result3 = instance3.equals(r3);
        
        Rationnel r4 = new Rationnel(2, 2);
        double nb = 6.0;
        boolean expResult4 = false;
        boolean result4 = r4.equals(nb);
        
        
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
    }

    /**
     * Test of hashCode method, of class Rationnel.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Rationnel r = new Rationnel(1, 2);
        Rationnel instance = new Rationnel(1, 2);
        boolean expResult = true;
        
        Rationnel r2 = new Rationnel(1, 2);
        Rationnel instance2 = new Rationnel(1, 3);
        boolean expResult2 = false;
        
        assertEquals(expResult, r.hashCode() == instance.hashCode());
        assertEquals(expResult2, r2.hashCode() == instance2.hashCode());

    }
    
}
