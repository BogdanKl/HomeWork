package Nodes;

import Nodes.Expression;
import Lexems.Operation;
public class OP extends Expression {
    Operation op;
    Expression left;
    Expression right;
    
    public OP(Operation op, Expression left, Expression term) {
        this.op = op;
        this.left = left;
        this.right = term;
        type = ExprType.OPERATION;
    }
    
    public Operation getOp()
    {
        return op;
    }
    
    public Expression getLeft()
    {
        return left;
    }
    
    public Expression getRight()
    {
        return right;
    }
    
    public void setLeft(Expression l)
    {
        this.left = l;
    }
    
    public void setRight(Expression r)
    {
        this.right = r;
    }
    
    @Override
    public Expression deepcopy()
    {
        return new OP(op, (Expression)left.deepcopy(), (Expression)right.deepcopy());
    }
}