/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author Я
 */
public class CasePalindrome2Test {
    
      
    @Test
    public void testIspalindrome() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'A';
        CasePalindrome2 instance = new CasePalindrome2();
        boolean expResult = true;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
    }
    @Test
    public void testIspalindrome1() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'a';
        CasePalindrome2 instance = new CasePalindrome2();
        boolean expResult = true;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
     }
     @Test
     public void testIspalindrome2() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'B';
        CasePalindrome2 instance = new CasePalindrome2();
        boolean expResult = false;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
     }
}
