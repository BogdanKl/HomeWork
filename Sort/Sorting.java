
package sort;
class Sorting {
   private static void swap(Element x, Element y){
        Element temp;
        temp = x;
        x = y;
        y = temp;
    }
    public static void sort(Element[] mass){
        int leng = 2;
        int i, j;
        for (i = leng; i >= 0; i--){
            for(j = i; j >= 0; j--)
            {
                if (Compare.compare(mass[j],mass[i]))
                        {
                            swap(mass[i],mass[j]);
                        }
            }
        }
        for (i = 0; i <= leng; i++)
        {
            System.out.println(mass[i].name+ " "+ " "+mass[i].age);
        }
    }
  }
