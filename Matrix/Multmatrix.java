
package matrix;

import java.util.concurrent.Callable;

class Multmatrix implements Callable<Integer> {

   private int[] linea ;
   private int[] columnb;

   Multmatrix(int[] a,int[] b){
       linea =a;
       columnb =b;
   } 

    @Override
    public Integer call() throws Exception {
        int leng = linea.length;
        int i;
        int result=0;
        for(i = 0; i < leng; i++ )
        {
               result+= linea[i]*columnb[i] ;         
        }
        return result;
    }
  
}
