import org.junit.*;
import static org.junit.Assert.*;
public class SqrtTest {
    
    @Test
     public void testSqrt1() {
        System.out.println("sqrt");
        double x = 9.0;
        double expResult = 3.0;
        double result = Sqrt.sqrt(x);
        assertEquals(expResult, result, 1e-6);
    }
    @Test
    public void testSqrt(){
        System.out.println("sqrt");
        double x = -3.0;
        try{
            double result = Sqrt.sqrt(x);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("Error");
        }
    }
}
