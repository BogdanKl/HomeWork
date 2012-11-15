
package matrix;
//Klepach Bogdan


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Matrix {
    public static void main(String[] args) throws Exception {
        int lengtha,lengthb, heighta, heightb;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        lengtha = Integer.parseInt(input.readLine());
        heighta = Integer.parseInt(input.readLine());
        lengthb = Integer.parseInt(input.readLine());
        heightb = Integer.parseInt(input.readLine());
        //System.out.println(lengtha + " "+ heighta + " " + lengthb + " " + heightb);
        if (heighta != lengthb)
        {
            System.out.println("Высота первой матрицы и длина второй матрицы должны совпадать");
            throw new IllegalArgumentException();
        }
        int i,j;
        int[][] matrixa = new int [lengtha][heighta];
        int[][] matrixb = new int [heightb][lengthb];
        for(i = 0; i < lengtha ; i++)
        {
            for(j = 0; j < heighta; j++)
            {
                matrixa[i][j] = Integer.parseInt(input.readLine());
            }
        }
        for(i = 0; i < lengthb ; i++)
        {
            for(j = 0; j < heightb; j++)
            {
                matrixb[j][i] = Integer.parseInt(input.readLine());
            }
        }
      ExecutorService exec = Executors.newCachedThreadPool();
      ArrayList<Future<Integer>> res = new ArrayList<Future<Integer>>();  
      int countera = 0;
      int counterb = 0;
      int r[][] = new int[lengtha][heightb];
      for( i =0; i < lengtha ;i++)
      {
          for( j = 0; j < heightb; j++)
          {
            Multmatrix Mult = new Multmatrix( matrixa[i], matrixb[j]);
            res.add(exec.submit(Mult));
          }
      }
      for(Future<Integer> f:res)
      {
          try{
              r[countera][counterb]=f.get();
              counterb++;
              if (counterb == heightb)
              {
                  countera++;
                  counterb = 0;
                          
              }
      }catch(InterruptedException e){
          System.out.println(e);
          return;
      }catch(ExecutionException e)
      {
          System.out.println(e);
      }finally{
          exec.shutdown();
      }
          
      }
    for( i =0 ; i < lengtha; i++)
    {
        for( j =0; j <heightb; j++)
        {
           System.out.print(r[i][j]+" "); 
        }
        System.out.println();
    }
 }
}
