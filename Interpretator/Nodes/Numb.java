package Nodes;

import Nodes.Expression;

public class Numb extends Expression {
    private int num;

    public Numb(int val) {
        this.num = val;
        type = ExprType.NUMBER;
    }
    public int getNum()
    {
        return num;
    }
    public void setNum(int n)
    {
        this.num = n;
    }
    @Override
    public Expression deepcopy()
    {
        return new Numb(num);
    }    
}