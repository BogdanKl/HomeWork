package coins;
//count the number of options
public class Variants {
    private int variantspart(int i,int needs, int[] a)
    {
        if (needs == 0)
        {
            return 1;
        }
        if ((i == (a.length-1))||(needs < 0))
        {
            return 0;       
        }
        return(variantspart(i+1, needs, a)+variantspart(i, needs - a[i], a));
        
     }
    public int variants(int need, int[] a )
    {
        if (need != 0)
        {
            return (variantspart(0, need, a));
        }
        else
        {
            return 0;
        }
    }
}
