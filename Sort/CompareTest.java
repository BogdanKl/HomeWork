package sort;
import org.junit.*;
import static org.junit.Assert.*;
public class CompareTest {
    @Test
    public void testCompare() {
        System.out.println("compare");
        Element x = new Element("Vova", 18);
        Element y = new Element("Vova", 21);
        boolean expResult = false;
        boolean result = Compare.compare(x, y);
        assertEquals(expResult, result);
    }
    @Test
    public void testCompare1() {
        System.out.println("compare");
        Element x = new Element("Vova", 23);
        Element y = new Element("Vova", 21);
        boolean expResult = true;
        boolean result = Compare.compare(x, y);
        assertEquals(expResult, result);
    }
        @Test
    public void testCompare2() {
        System.out.println("compare");
        Element x = new Element("Zova", 18);
        Element y = new Element("Vova", 18);
        boolean expResult = true;
        boolean result = Compare.compare(x, y);
        assertEquals(expResult, result);
    }
    @Test
    public void testCompare3() {
        System.out.println("compare");
        Element x = new Element("Roma", 18);
        Element y = new Element("Vova", 18);
        boolean expResult = false;
        boolean result = Compare.compare(x, y);
        assertEquals(expResult, result);
    }
}
