package sort;
public class Compare {
    public static boolean compare (Element x, Element y){
        if (x.name.compareTo(y.name)>0)
        {
            return true;
        }
        if (x.name.equals(y.name) && (x.age > y.age))
        {
            return true;
        }
        else
        {
            return false;
        }   
    }    
}
