package interpretatore;

import Exception.UnCorrectExprException;
import Nodes.ExprType;
import Nodes.Expression;
import Nodes.FunCall;
import Nodes.FunDeff;
import Nodes.Let;
public class ActiveInterpretator extends Interpretator {
        @Override
    public Expression eval(Let l) throws Exception 
    {
        return eval(substitute(l.getExprR(), l.getName(), eval(l.getExprL())));
    }

    @Override
    Expression eval(FunCall fun) throws Exception
    {
        Expression f = eval(fun.getFun());
        if (f.getType() != ExprType.FUNDEFF)
        {
            throw new UnCorrectExprException("ожидалось описание функции");
        }
        FunDeff fund = (FunDeff) f;
        return eval(substitute(fund.getExpr(), fund.getName(), eval(fun.getArg())));
    }
    
}
