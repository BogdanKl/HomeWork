package calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        Lexer calc = new Lexer();
        while (!("stop".equals(s))) {
            System.out.println(calc.start(s));
            s = input.readLine();
        }
    }
}
