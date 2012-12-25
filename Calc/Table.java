package calc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Table {

    private int size;
    private List<List<ElemList>> htable = new ArrayList();

    public Table(int sizeHash) {
        size = sizeHash;
        for (int i = 0; i < size; i++) {
            htable.add(new ArrayList<ElemList>());
        }
    }

    private int HashCode(String s) {
        int leng = s.length();
        int result = 0;
        int p = 17;
        int acc = 1;
        for (int j = 0; j < leng; j++) {
            result += (((int) s.charAt(j)) * acc);
            acc *= p;
            result = Math.abs(result % size);
        }
        return result;
    }

    public void put(String s, int n) {
        if (s != null) {
            int hash = HashCode(s);
            List<ElemList> list;
            list = htable.get(hash);
            list.add(new ElemList(s, n));
        }
    }

    public ElemList get(String s) {
        if (s != null) {
            int hash = HashCode(s);
            List<ElemList> list;
            list = htable.get(hash);

            if (list == null) {
                return null;
            } else {
                for (ElemList e : list) {
                    if (s.equals(e.getKey())) {
                        return e;
                    }
                }
            }

        }
        return null;
    }

    public boolean IsFound(String s) {
        if (get(s) == null) {
            return false;
        } else {
            return true;
        }
    }

    public void delete(String s) {
        if (s != null) {
            int hash = HashCode(s);
            List<ElemList> list;
            list = htable.get(hash);

            if (!list.isEmpty()) {
                Iterator i = list.iterator();
                ElemList e;
                while (i.hasNext()) {
                    e = (ElemList) i.next();
                    if (s.equals(e.getKey())) {
                        i.remove();
                        return;
                    }
                }
            }
        }
    }

    public void clean() {
        if (!htable.isEmpty()) {
            htable.clear();
        }
    }

    public void print() {
        List<ElemList> list;
        for (int i = 0; i < size; i++) {
            list = htable.get(i);
            for (ElemList e : list) {
                System.out.println(e.getKey() + " " + e.getNumber());
            }
        }
    }
}
