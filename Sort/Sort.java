
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {

    public static void main(String[] args) throws IOException {
        Object[] mass ={121,11,47,2};
        Sorting s = new Sorting(mass, new ConCompare());
        s.sort();
        s.print();
    }
}
