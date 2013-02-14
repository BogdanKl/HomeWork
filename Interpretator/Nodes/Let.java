package Nodes;
import Nodes.Expression;
public class Let extends Expression {
    private String name;
    private Expression exprL;
    private Expression exprR;

    public Let(String id, Expression exprL, Expression exprR) {
        this.name = id;
        this.exprL = exprL;
        this.exprR = exprR;
        type = ExprType.LET;
    }
    
    public String getName()
    {
        return name;
    }
    public Expression getExprL()
    {
        return exprL;
    }
    public Expression getExprR()
    {
        return exprR;
    }
    public void setExprL(Expression l)
    {
        this.exprL = l;
    }
    public void setExprR(Expression r)
    {
        this.exprR = r;
    }
    @Override
    public Expression deepcopy()
    {
        return new Let(name, (Expression) exprL.deepcopy(), (Expression) exprR.deepcopy());
    }    
}