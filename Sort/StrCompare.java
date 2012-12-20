package sort;

public class StrCompare implements Compare {

    @Override
    public int compare(Object a, Object b) {
        int first = a.toString().length();
        int second = b.toString().length();
        if (first == second) {
            return 0;
        }
        if (first > second) {
            return 1;
        } else {
            return -1;
        }
    }
}
