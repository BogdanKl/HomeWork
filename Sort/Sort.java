
package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {

    public static void main(String[] args) throws IOException {
        Element[] mass = new Element[3];
        mass[0] = new Element("Vovs", 18);
        mass[1] = new Element("Kate", 21);
        mass[2] = new Element("Vova", 21);
        Sorting.sort(mass);
    }
}
