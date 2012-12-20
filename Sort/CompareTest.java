package sort;
import org.junit.*;
import static org.junit.Assert.*;
public class CompareTest {
    private ConCompare c = new ConCompare();
    @Test
    public void testConCompare1() {
        System.out.println("compare");
        int result = c.compare(11, 10);
        assertEquals(1, result);
    }
        @Test
    public void testConCompare2() {
        System.out.println("compare");
        int result = c.compare(10, 10);
        assertEquals(0, result);
    }
            @Test
    public void testConCompare3() {
        System.out.println("compare");
        int result = c.compare(9, 10);
        assertEquals(-1, result);
    }
    @Test
    public void testSorting(){
        Object[] a = {10,1,2,7,4,19,100,18};
        Object[] exp ={1,2,4,7,10,18,19,100};
        Sorting s = new Sorting(a, new ConCompare());
        s.sort();
        assertEquals(exp, s.mass);        
    }
    @Test
    public void testSortingStr()
    {
        Object[] a = {111,11,1111,1};
        Object[] exp = {1,11,111,1111};
        Sorting s = new Sorting(a, new StrCompare());
        s.sort();
        assertEquals(exp, s.mass);
    }
}
