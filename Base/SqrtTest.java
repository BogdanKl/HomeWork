/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Я
 */
public class SqrtTest {
    
    @Test
     public void testSqrt1() {
        System.out.println("sqrt");
        double x = 9.0;
        double expResult = 3.0;
        double result = Sqrt.sqrt(x);
        assertEquals(expResult, result, 1e-6);
    }
}
