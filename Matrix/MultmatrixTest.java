/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package matrix;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Я
 */
public class MultmatrixTest {
 
    @Test
    public void testCall() throws Exception {
        System.out.println("call");
        int[] a = {1,2};
        int[] b = {1,2};
        Multmatrix instanse= new Multmatrix(a,b);
        Integer expResult = 5;
        Integer result = instanse.call();
        assertEquals(expResult, result);
   }
     @Test
    public void testCall1() throws Exception {
        System.out.println("call");
        int[] a = {1,1,1};
        int[] b = {1,1,1};
        Multmatrix instanse= new Multmatrix(a,b);
        Integer expResult = 3;
        Integer result = instanse.call();
        assertEquals(expResult, result);
   }
}
