package sort;
public class Element {
    protected String name;
    protected int age;
    Element(String s, int i)
    {
        name =s;
        age =i;
    }
    
    public void setName(String s)
    {
        name = s;
    }
    public void setAge(int i)
    {
        age = i;
    }
    
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    
}
