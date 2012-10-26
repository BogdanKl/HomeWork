
package palindrome;

import org.junit.*;
import static org.junit.Assert.*;

public class CasePalindrome1Test {
    
    @Test
    public void testIspalindrome() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'A';
        CasePalindrome1 instance = new CasePalindrome1();
        boolean expResult = false;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
    }
    @Test
    public void testIspalindrome1() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'a';
        CasePalindrome1 instance = new CasePalindrome1();
        boolean expResult = true;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
     }
     @Test
    public void testIspalindrome2() {
        System.out.println("ispalindrome");
        char ch = 'a';
        char sh = 'b';
        CasePalindrome1 instance = new CasePalindrome1();
        boolean expResult = false;
        boolean result = instance.ispalindrome(ch, sh);
        assertEquals(expResult, result);
     }
}

