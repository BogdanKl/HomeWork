package branches;

import org.junit.*;
import static org.junit.Assert.*;

public class IsCorrectTest {

    @Test
    public void testIsntcorrect1() {
        System.out.println("iscorrect");
        String s = "(aba]";
        IsCorrect instance = new IsCorrect();
        boolean expResult = false;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsntcorrect2() {
        System.out.println("iscorrect");
        String s = ")aa";
        IsCorrect instance = new IsCorrect();
        boolean expResult = false;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsntcorrect3() {
        System.out.println("iscorrect");
        String s = "<aba/]";
        IsCorrect instance = new IsCorrect();
        boolean expResult = false;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIsntcorrect4() {
        System.out.println("iscorrect");
        String s = "(<[])>";
        IsCorrect instance = new IsCorrect();
        boolean expResult = false;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIscorrect1() {
        System.out.println("iscorrect");
        String s = "(aba)";
        IsCorrect instance = new IsCorrect();
        boolean expResult = true;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIscorrect2() {
        System.out.println("iscorrect");
        String s = "[aba]";
        IsCorrect instance = new IsCorrect();
        boolean expResult = true;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIscorrect3() {
        System.out.println("iscorrect");
        String s = "<aba>";
        IsCorrect instance = new IsCorrect();
        boolean expResult = true;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIscorrect4() {
        System.out.println("iscorrect");
        String s = "<bhjghjg/>";
        IsCorrect instance = new IsCorrect();
        boolean expResult = true;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }

    @Test
    public void testIscorrect5() {
        System.out.println("iscorrect");
        String s = "(<[]>)";
        IsCorrect instance = new IsCorrect();
        boolean expResult = true;
        boolean result = instance.iscorrect(s);
        assertEquals(expResult, result);
    }
}

