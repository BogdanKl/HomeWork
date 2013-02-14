package interpretatore;

import Exception.UnCorrectExprException;
import Exception.UnCorrectNumException;
import Nodes.ExprType;
import Nodes.Expression;
import Nodes.FunCall;
import Nodes.FunDeff;
import Nodes.Indetificator;
import Nodes.Let;
import Nodes.Numb;
import Nodes.OP;

public abstract class Interpretator {
    private int counter;
    
    public Expression evalExpr(Expression e) throws Exception
    {
        counter = 0;
        return eval(e);
    }
    public Expression substitute(Expression left, String id, Expression right) throws Exception
    {
        switch(left.getType())
        {
            case OPERATION:
                OP o =(OP)left;
                o.setLeft(substitute(o.getLeft(),id, right));
                o.setRight(substitute(o.getRight(), id, right));
                return o;
            case LET:
                Let l = (Let)left;
                if(!(l.getName()).equals(id))
                {
                    l.setExprL(substitute(l.getExprL(), id, right));
                    l.setExprR(substitute(l.getExprR(), id, right));
                }
                return l;
            case NUMBER: 
                return left;
            case INDETIFICATOR:
                Indetificator i = (Indetificator) left;
                if ((i.getName()).equals(id))
                {
                    return (Expression)right.deepcopy();
                }
                return i;
            case FUNDEFF:
                FunDeff f = (FunDeff) left;
                if(!(f.getName().equals(id)))
                {
                    f.setExpr(substitute(f.getExpr(), id ,right));
                }
                return f;
            case FUNCALL:
                FunCall fc =(FunCall) left;
                fc.setFun(substitute(fc.getFun(),id, right));
                                fc.setArg(substitute(fc.getArg(), id, right));
                return fc;              
        }
        throw new Exception();
    }
    
    public Expression eval(Expression e) throws Exception
    {
        counter++;
        switch(e.getType())
        {
            case OPERATION: return eval((OP)e);
            case NUMBER: return eval((Numb)e);
            case LET: return eval((Let)e);
            case INDETIFICATOR: throw new UnCorrectExprException("отсутыует переменная");
            case FUNCALL: return eval((FunCall)e);
            case FUNDEFF: return eval((FunDeff)e);                
        }
        throw new Exception();
    }
    
    public Expression eval(Numb n)
    {
        return n;
    }
    
    public Expression eval(FunDeff f)
    {
        return f;
    }
    
    public Expression eval(Indetificator e) throws Exception
    {
        throw new Exception();
    }
    
    public Expression eval(OP o) throws Exception
    {
        Expression left = eval(o.getLeft());
        Expression right = eval(o.getRight());
        if (left.getType() != ExprType.NUMBER || right.getType() != ExprType.NUMBER)
        {
            throw new UnCorrectNumException();
        }
        switch(o.getOp())
        {
            case PLUS: 
                return new Numb(((Numb)left).getNum() + ((Numb)right).getNum());
            case MINUS: 
                return new Numb(((Numb)left).getNum() - ((Numb)right).getNum());
            case MULT: 
                return new Numb(((Numb)left).getNum() * ((Numb)right).getNum());
            case DIV:
                if(((Numb)right).getNum() == 0)
                {
                    throw new UnCorrectNumException();
                }
                else
                {
                    return new Numb(((Numb)left).getNum() / ((Numb)right).getNum());
                }
        }
        throw new Exception();
    }
    
    public int getCounter()
    {
        return counter;
    }
    abstract Expression eval(Let l) throws Exception;
    abstract Expression eval(FunCall fun)throws Exception;
}
