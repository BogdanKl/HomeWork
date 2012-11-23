//Klepach Bogdan
//square root of the number

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base {
     public static void main(String[] args) throws IOException {
        double x = 0;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));        
        x=Double.parseDouble(input.readLine());
        System.out.print(Sqrt.sqrt(x));
    }
}
