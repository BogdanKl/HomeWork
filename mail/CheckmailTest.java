
package mail;

import org.junit.*;
import static org.junit.Assert.*;
public class CheckmailTest {
    @Test
    public void testCheckmail() {
        System.out.println("checkmail");
        String str = " s";
        boolean expResult = false;
        boolean result = Checkmail.checkmail(str);
        assertEquals(expResult, result);
     }
     @Test
     public void testCheckmail1() {
        System.out.println("checkmail");
        String str = "Checkmail";
        boolean expResult = false;
        boolean result = Checkmail.checkmail(str);
        assertEquals(expResult, result);
     }
     @Test
     public void testCheckmail2() {
        System.out.println("checkmail");
        String str = "Chekmail@mail.k";
        boolean expResult = false;
        boolean result = Checkmail.checkmail(str);
        assertEquals(expResult, result);
     }@Test
      public void testCheckmail3() {
        System.out.println("checkmail");
        String str = "otevet@otevet.com";
        boolean expResult = true;
        boolean result = Checkmail.checkmail(str);
        assertEquals(expResult, result);
     }
}
