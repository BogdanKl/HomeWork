package gui2;
public class Controllers {
    Models m;
    public Controllers(Models m)
    {
        this.m = m;
    }
    public void changeisMade(String s, String val)
    {
        switch (s)
        {
            case "RUB": m.setState(FieldType.RUB, val); break;
            case "DOL": m.setState(FieldType.DOL, val); break;
        }
    }
    public void register(Observe o)
    {
        m.registerObserver(o);
    }
    
}
