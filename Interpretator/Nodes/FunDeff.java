package Nodes;

import Nodes.Expression;

public class FunDeff extends Expression {
    private String name;
    private Expression expr;

    public FunDeff(String id, Expression expr) {
        this.name = id;
        this.expr = expr;
        type = ExprType.FUNDEFF;
    }
    public String getName()
    {
        return name;
    }
    public Expression getExpr()
    {
        return expr;
    }
    public void setName(String s)
    {
        this.name = s;
    }
    public void setExpr(Expression e)
    {
        this.expr = e;
    }
    @Override
    public Expression deepcopy()
    {
        return new FunDeff(name, (Expression) expr.deepcopy());
    }    
}