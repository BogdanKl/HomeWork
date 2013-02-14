package Nodes;

import Nodes.Expression;
public class FunCall extends Expression {
    private Expression arg;
    private Expression fun;
    public FunCall(Expression f, Expression a) {
        this.arg = a;
        this.fun = f;
        type = ExprType.FUNCALL;
    }
    public Expression getArg()
    {
        return arg;
    }
    public Expression getFun()
    {
        return fun;
    }
    public void setArg(Expression a)
    {
        this.arg = a;
    }
    public void setFun(Expression f)
    {
        this.fun = f;
    }
    @Override
    public Expression deepcopy()
    {
        return new FunCall((Expression) arg.deepcopy(), (Expression) fun.deepcopy());
    }    
}