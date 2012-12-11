import org.junit.*;
import static org.junit.Assert.*;
public class SqrtTest {
    
    @Test
     public void testSqrt1() {
        System.out.println("sqrt");
        double x = 16.0;
        double expResult = 4.0;
        double result = Sqrt.sqrt(x);
        assertEquals(expResult, result, 6);
    }
    @Test
    public void testSqrtLong(){
        System.out.println("sqrtLong");
        double x = 9e50;
        double expResult = 3e25;
        double epsilon = expResult * 1e-9;
        double result = Sqrt.sqrt(x);
        assertEquals(expResult, result, epsilon);
    }
    @Test
    public void testSqrtSmall(){
        System.out.println("sqrtSmal");
        double x = 9e-50;
        double expResult = 3e-25;
        double epsilon = expResult * 1e-9;
        double result = Sqrt.sqrt(x);
        assertEquals(expResult, result, epsilon);
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
