package hashtable;
public class ElemList {
    protected String element;
    protected int count;

    ElemList(String s, int i) {
        element =s;
        count = i;
    }
    
    public void setElement(String e)
    {
        element = e;
    }
    
    public String getElement()
    {
        return element;
    }
    
    public int getCounter()
    {
        return count;
    }
    
    public void incCounter()
    {
        count++;
    }
}
