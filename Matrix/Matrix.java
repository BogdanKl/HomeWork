package matrix;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Matrix {

    private int lengthb;
    private int heightb;
    private int[][] matrixb;

    public Matrix(int leng, int heig, int[][] matrix) {
        lengthb = leng;
        heightb = heig;
        matrixb = matrix;
    }

    private void transpose() {
        int[][] result = new int[heightb][lengthb];
        int i, j;
        for (i = 0; i < lengthb; i++) {
            for (j = 0; j < heightb; j++) {
                result[j][i] = matrixb[i][j];
            }
        }
        matrixb = result;
    }

    public int[][] mmatrix(int lengtha, int heighta, int[][] matrixa) {
        int i, j;
        this.transpose();
        if (heighta != lengthb) {
            System.out.println("Высота первой матрицы и длина второй матрицы должны совпадать");
            throw new IllegalArgumentException();
        }
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