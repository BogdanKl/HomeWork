
package coins;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VariantsTest {
   
    @Test
    public void testVariants(){
        System.out.println("variants");
        int need = 40;
        int[] a = {1,5,10,100};
        Variants instance = new Variants();
        int expResult = 25;
        int result = instance.variants(need, a);
        assertEquals(expResult, result);  
    }
    
    @Test
    public void testVariants1(){
        System.out.println("variants");
        int need = 0;
        int[] a = {1,5,10,100};
        Variants instance = new Variants();
        int expResult = 0;
        int result = instance.variants(need, a);
        assertEquals(expResult, result);  
    }
    @Test
    public void testVariants2(){
        System.out.println("variants");
        int need = 40;
        int[] a = {100};
        Variants instance = new Variants();
        int expResult = 0;
        int result = instance.variants(need, a);
        assertEquals(expResult, result);  
    }
    
}
