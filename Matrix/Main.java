
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

public class Main {
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
                matrixb[i][j] = Integer.parseInt(input.readLine());
            }
        }
    Matrix mb = new Matrix(lengthb, heightb, matrixb);
    Matrix ma = new Matrix(lengtha, heighta, matrixa); 
    Matrix result = MatrixOp.mul(ma,mb);
    MatrixOp.print(result);

 }
}
