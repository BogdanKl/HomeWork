package Nodes;

import Nodes.Expression;

public class Indetificator extends Expression {
    private String name;

    public Indetificator(String id) {
        this.name = id;
        type = ExprType.INDETIFICATOR;
    }
    public String getName()
    {
        return name;
    }
    public void setname(String id)
    {
        this.name = id;
    }
    @Override
    public Expression deepcopy()
    {
        return new Indetificator(name);
    }    
}