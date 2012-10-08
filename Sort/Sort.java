
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {

    public static void main(String[] args) throws IOException {
        //Object[] mass = new Object[100];
        int i,n;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
       /* n= Integer.parseInt(input.readLine());
        for (i = 0; i < n; i++)
        {
          mass[i] = Integer.parseInt(input.readLine());  
        }
        * 
        */
        Object[] mass = {5, 2, 1, 7};
        Sorting.sort(mass);
    }
}
