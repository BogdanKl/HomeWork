package interpretatore;

import Exception.UnCorrectExprException;
import Nodes.ExprType;
import Nodes.Expression;
import Nodes.FunCall;
import Nodes.FunDeff;
import Nodes.Let;

public class LazyInterpretator extends Interpretator{

    public LazyInterpretator() {
    }

    @Override
    public Expression eval(Let l) throws Exception 
    {
        return eval(substitute(l.getExprR(), l.getName(), l.getExprL()));
    }

    @Override
    Expression eval(FunCall fun) throws Exception
    {
        Expression f = eval(fun.getFun());
        if (f.getType() != ExprType.FUNDEFF)
        {
            throw new UnCorrectExprException("");
        }
        FunDeff fund = (FunDeff) f;
        return eval(substitute(fund.getExpr(), fund.getName(), fun.getArg()));
    }    
}