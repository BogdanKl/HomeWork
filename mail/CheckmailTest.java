
package mail;

import org.junit.*;
import static org.junit.Assert.*;
public class CheckmailTest {
    @Test
    public void testCheckmailTrue() {
        System.out.println("checkmail");
        String[] str ={"a@b.cc","victor.polozov@mail.ru","my@domain.info","coins@hermitage.museum","_.1@mail.com"};
        boolean expResult = true;
        for( int i = 0; i <5; i++)
        {
          System.out.println(str[i]);
          boolean result = Checkmail.checkmail(str[i]);
          assertEquals(expResult, result);
        }
     }
     @Test
     public void testCheckmailfail() {
        System.out.println("checkmail");
        String[] str = {"Checkmail","a..b@mail.ru","a@b.c",".a@mail.ru","yo@domain.domain"};
        boolean expResult = false;
        for(int i =0 ; i < 5; i++)
        {
            System.out.println(str[i]);
            boolean result = Checkmail.checkmail(str[i]);
            assertEquals(expResult, result);
        }
     }
}
