package hashtable;

import java.io.*;

public class HashTable {

    public static void main(String[] args) throws IOException {
        String s = "input.txt";
        try {
            BufferedReader file = new BufferedReader(new FileReader(s));
            int ch = file.read();
            Hash h = new Hash(613);
            while (ch != -1) {
                String acc = "";
                while (Character.isDigit(ch) || ch == '-' || Character.isLetter(ch)) {
                    acc = acc.concat(Character.toString((char) ch));
                    ch = file.read();
                }
                h.put(acc);
                ch = file.read();
            }
            file.close();
            h.print();
            h.printStatictic();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }
}
