package coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coins {
    public static void main(String[] args) throws IOException {
        int need;
        int n, i;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        need = Integer.parseInt(input.readLine());
        n = Integer.parseInt(input.readLine());
        int[] coin = new int[n];
        for(i = 0; i < n; i++)
        {
            coin[i] = Integer.parseInt(input.readLine());
        }
        
        //int[] coin = {1, 5, 10};
        Variants var = new Variants();
        System.out.println( var.variants(need, coin));
    }
}
