package interpretatore;

import Nodes.Expression;
import Nodes.Numb;

public class Interpretatore {
    public static void main(String[] args) throws Exception {
        Parser p = new Parser();
        //LazyInterpretator l = new LazyInterpretator();
        ActiveInterpretator l = new ActiveInterpretator();
        Expression n = p.parseExpr("let y = 4 in x * x");
        n = l.evalExpr((Expression)n);
        System.out.print(((Numb)n).getNum());              
    }
}