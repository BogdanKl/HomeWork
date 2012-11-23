
package branches;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Branches {

    public static void main(String[] args) throws IOException {
       String s;
       IsCorrect cor = new IsCorrect();
       BufferedReader r = new BufferedReader( new InputStreamReader(System.in)); 
       s = r.readLine();
       if(cor.iscorrect(s))
       {
           System.out.println("Correct");
       }
       else
       {
           System.out.println("Isn.t correct");
       }
    }
}
