package sort;

public class ConCompare implements Compare {

    @Override
    public int compare(Object a, Object b) {
        int first = Integer.parseInt(a.toString());
        int second = Integer.parseInt(b.toString());
        if (first == second)  {
            return 0;
        }
        if (first < second) {
            return -1;
        } else {
            return 1;
        }
    }
}
