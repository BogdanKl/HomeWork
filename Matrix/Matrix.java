package matrix;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Matrix {

    private int lengtha;
    private int heighta;
    private int lengthb;
    private int heightb;

    public Matrix(int lena, int heia, int lenb, int heib) {
        lengtha = lena;
        heighta = heia;
        lengthb = lenb;
        heightb = heib;
    }

    private int[][] transpose(int[][] matrix) {
        int leng = matrix.length;
        int heig = matrix[0].length;
        int[][] result = new int[heig][leng];
        int i, j;
        for (i = 0; i < leng; i++) {
            for (j = 0; j < heig; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public int[][] mmatrix(int[][] matrixa, int[][] matrixb) {
        int i, j;
        if (heighta != lengthb) {
            System.out.println("Высота первой матрицы и длина второй матрицы должны совпадать");
            throw new IllegalArgumentException();
        }
        matrixb = transpose(matrixb);
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> res = new ArrayList<Future<Integer>>();
        int countera = 0;
        int counterb = 0;
        int r[][] = new int[lengtha][heightb];
        for (i = 0; i < lengtha; i++) {
            for (j = 0; j < heightb; j++) {
                Multmatrix Mult = new Multmatrix(matrixa[i], matrixb[j]);
                res.add(exec.submit(Mult));
            }
        }
        for (Future<Integer> f : res) {
            try {
                r[countera][counterb] = f.get();
                counterb++;
                if (counterb == heightb) {
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