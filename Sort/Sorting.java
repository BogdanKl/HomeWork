
package sort;
class Sorting {
   private static void swap(Object[] mass, int x, int y){
        Object  temp;
        temp = mass[x];
        mass[x] = mass[y];
        mass[y] = temp;
    }
    public static void sort(Object[] mass){
        int leng = mass.length - 1;
        int i, j;
        for (i = leng; i >= 0; i++){
            for(j = i; j >= 0; i++)
            {
                if (Compare.compare(mass[j],mass[i]))
                        {
                            swap(mass,i ,j);
                        }
            }
        }
        for (i = 0; i <= leng; i++)
        {
            System.out.print(mass[i]+ " ");
        }
    }
  }
