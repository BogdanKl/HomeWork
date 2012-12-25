package calc;
public class ElemList {
    protected String key;
    protected int num;
    
    ElemList(String k, int n)
    {
        key = k;
        num = n;
    } 
    
    public String getKey()
    {
        return key; 
    }
    
    public void setKey(String k)
    {
        key = k;
    }
    
    public int getNumber()
    {
        return num;
    }
    
    public void setNumber(int i)
    {
        num = i;
    }
}
