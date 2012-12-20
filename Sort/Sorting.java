package sort;

class Sorting {

    protected Object[] mass;
    protected Compare c;
    
    Sorting(Object[] a, Compare com)
    {
        mass =a;
        c = com;
    }

    private  void swap(int i, int j) {
        Object temp;
        temp = mass[i];
        mass[i] = mass[j];
        mass[j] = temp;
    }

    public void sort() {
        int leng = mass.length - 1;
        int i, j;
        for (i = 1; i <= leng; i++) {
            for (j = leng; j >= i; j--) {
                if (c.compare(mass[j], mass[j - 1]) == -1) {
                    swap(j - 1, j);
                }
            }
        }
    }

    public void print() {
        int l = mass.length;
        for (int i = 0; i < l; i++) {
            System.out.print(mass[i] + " ");
        }
    }
}
