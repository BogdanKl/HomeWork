package hashtable;
//add(E e)
//Добавляет указанный элемент до конца этого списка.

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hash {

    private int size;
    private int primary;
    private int[] number;
    private List<List<ElemList>> htable = new ArrayList();

    public Hash(int sizeHash) {
        size = sizeHash;
        number = new int[sizeHash];
        for (int i = 0; i < size; i++) {
            htable.add(new ArrayList<ElemList>());
            number[i] = 0;
        }
    }

    private int HashCode(String s) {
        int leng = s.length();
        int result = 0;
        int p = 41;
        int q = 29;
        int acc = 1;
        for (int j = 0; j < leng; j++) {
            result += (((int) s.charAt(j)) * acc * q);
            acc *= p;
            result = Math.abs(result % size);
        }
        return result;
    }

    public void put(String s) {
        if (s != null) {
            int hash = HashCode(s);
            List<ElemList> list;
            list = htable.get(hash);
            if (htable.get(hash).isEmpty()) {
                list.add(new ElemList(s, 1));
                number[hash]++;
            } else {
                for (ElemList e : list) {
                    if (s.equals(e.getElement())) {
                        e.incCounter();
                        return;
                    }
                }
                list.add(new ElemList(s, 1));
                number[hash]++;
            }
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
                    if (s.equals(e.getElement())) {
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
                    if (s.equals(e.getElement())) {
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

    public void print() throws FileNotFoundException {
        List<ElemList> list;
        try {
            PrintWriter out = new PrintWriter(new File("result.txt").getAbsoluteFile());
            try {
                for (int i = 0; i < size; i++) {
                    out.println("Hashcode= " + i + " " + " number: " + number[i]);
                    list = htable.get(i);
                    for (ElemList e : list) {
                        out.println(e.getElement() + " " + e.getCounter());
                    }
                }
            } finally {
                out.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void printStatictic() throws FileNotFoundException {
        List<ElemList> list;
        int min = number[0];
        int max = number[0];
        double sum = 0.0;
        double ssum = 0.0;
        try {
            PrintWriter out = new PrintWriter(new File("Statictic.txt").getAbsoluteFile());
            try {
                for (int i = 0; i < size; i++) {
                    out.println("Hashcode= " + i + " " + "количество уникальных строк: "+ number[i]);
                    max = Math.max(max, number[i]);
                    min = Math.min(min, number[i]);
                    sum += (number[i]);
                    ssum += (number[i]) * (number[i]);
                }
                out.println("минимум = " + min);
                out.println("максимум = " + max);
                out.println("амплитуда = " + (max - min));
                out.println("среднее значение = " + (sum / size));
                out.println("среднее квадратичное = " + (ssum / (size * size)));
            } finally {
                out.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        public void printStaticticOut()  {
        List<ElemList> list;
        int min = number[0];
        int max = number[0];
        double sum = 0.0;
        double ssum = 0.0;

                for (int i = 0; i < size; i++) {
                    System.out.println("Hashcode= " + i + " " + "количество уникальных строк: "+ number[i]);
                    max = Math.max(max, number[i]);
                    min = Math.min(min, number[i]);
                    sum += (number[i]);
                    ssum += (number[i]) * (number[i]);
                }
                System.out.println("минимум = " + min);
                System.out.println("максимум = " + max);
                System.out.println("амплитуда = " + (max - min));
                System.out.println("среднее значение = " + (sum / size));
                System.out.println("среднее квадратичное = " + (ssum / (size * size)));

}


}
