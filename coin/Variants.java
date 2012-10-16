package coins;

public class Variants {
    public int variants(int i,int needs, int[] a)
    {
        if (needs == 0)
        {
            return 1;
        }
        if ((i == (a.length-1))||(needs < 0))
        {
            return 0;       
        }
        return(variants(i+1, needs, a)+variants(i, needs - a[i], a));
        
     }      
}
