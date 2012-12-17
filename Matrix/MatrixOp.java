
package matrix;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixOp {
    

    
     public static void print(Matrix a)
    {
        for(int i = 0; i < a.getLength(); i++)
        {
             for(int j = 0; j < a.getHeight(); j++)
            {
              System.out.print(a.getElem(i, j) + " ");
            }
            System.out.println();
        }
    }
     
         public static Matrix mul(Matrix ma, Matrix mb) {
        int i, j;
        ma.transpose();
        int ma_leng = ma.getLength();
        int ma_height = ma.getHeight();
        int mb_leng = mb.getLength();
        int mb_height = mb.getHeight();
        if (mb_leng!= ma_height) {
            System.out.println("Высота первой матрицы и длина второй матрицы должны совпадать");
            throw new IllegalArgumentException();
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> res = new ArrayList<Future<Integer>>();
        int countera = 0;
        int counterb = 0;
        Matrix r = new Matrix();
        r.setLength(ma_leng);
        r.setHeight(mb_height);
        r.init();
        for (i = 0; i < ma_leng; i++) {
            for (j = 0; j < mb_height; j++) {
                Multmatrix Mult = new Multmatrix(ma.getLine(i), mb.getLine(j));
                res.add(exec.submit(Mult));
            }
        }
        for (Future<Integer> f : res) {
            try {
                r.setElem(countera, counterb, f.get());
                counterb++;
                if (counterb == mb_height) {
                    countera++;
                    counterb = 0;

                }
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
            }
        }

        return r;
    }
}
