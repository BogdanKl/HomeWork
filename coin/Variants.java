package coins;

public class Variants {
    public void copy(int [] a, int i, int[] b, int j ,int l){
        for(int t = 0; t < l; t++ )
        {
            b[j+t] = a[i+t];
        }
    }
    public int leng = 0;
    public int variants(int need, int[] coin){
        leng = coin.length;
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
        int[] temp = new int[leng-1];
        copy(coin, 1, temp, 0, leng-1);
        return (variants(need, temp) + variants(need - coin[0], coin));
        }
        
}
