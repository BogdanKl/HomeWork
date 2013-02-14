package Nodes;

public abstract class Expression {
    protected ExprType type;
    abstract public Object deepcopy();
    public ExprType getType()
    {
        return type;
    }    
}