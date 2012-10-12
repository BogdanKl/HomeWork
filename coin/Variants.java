package coins;

public class Variants {
    public int variantspart(int i,int needs, int[] a)
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
       public int variants(int need, int[] coin){
        int leng = coin.length;
        if (need == 0)
        {
            return 1;
        }
        if (need < 0)
        {
            return 0;
        }
        if (leng == 0)
        {
            return 0;
        }    
        return (variantspart(1,need, coin) + variants(need - coin[0], coin));
        }
        
}
