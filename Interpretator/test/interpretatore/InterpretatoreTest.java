package interpretatore;

import Exception.UnCorrectExprException;
import Exception.UnCorrectTypeLexemException;
import Nodes.Expression;
import Nodes.Numb;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class InterpretatoreTest {

    @Test
    public void testMain() throws Exception {
        String[] s = {"let x = (2+3)*2+2 in x+2", "let y = 4 in 5*5+4*4", "(fun x -> x+3) 5"};
        int[] ans = {14, 41, 8};
        int i = 0;
        for (i = 0; i < 3; i++) {
            Parser p = new Parser();
            ActiveInterpretator l = new ActiveInterpretator();
            Expression n = p.parseExpr(s[i]);
            n = l.evalExpr((Expression) n);
            assertEquals(((Numb) n).getNum(), ans[i]);
        }
    }

    @Test
    public void testLazy() throws Exception {
        String[] s = {"let x = 1 in x+2", "let y = 4 in 5", "(fun x -> x+3) 5"};
        int[] ans = {3, 5, 8};
        int i = 0;
        for (i = 0; i < 3; i++) {
            Parser p = new Parser();
            LazyInterpretator l = new LazyInterpretator();
            Expression n = p.parseExpr(s[i]);
            n = l.evalExpr((Expression) n);
            assertEquals(((Numb) n).getNum(), ans[i]);
        }
    }

    @Test(expected = UnCorrectTypeLexemException.class)
    public void testError() throws Exception {
        String[] s = {"let x in x+2", "let x  4 in x * x", "let z = 7 z*2+1"};
        for (int i = 0; i < 3; i++) {
            Parser p = new Parser();
            LazyInterpretator l = new LazyInterpretator();
            Expression n = p.parseExpr(s[i]);
        }
    }

    @Test(expected = UnCorrectExprException.class)
    public void testExprError() throws Exception {
        String s = "let y = 4 in z +9";
        Parser p = new Parser();
        LazyInterpretator l = new LazyInterpretator();
        Expression n = p.parseExpr(s);
        n = l.evalExpr((Expression) n);
    }
}
