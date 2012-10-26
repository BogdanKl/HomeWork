package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {
    
    private static  boolean palindrom(String s){
      int j = s.length()-1;
      int i = 0;
      IsPalindrome p;
      p = new CasePalindrome2();
      char ch_b = s.charAt(i);
      char ch_e = s.charAt(j);
      while (i < j){
          while (!(('a' <= ch_b && ch_b <= 'z') || ('A' <= ch_b && ch_b <= 'Z') || Character.isDigit(ch_b))){
              i++;
              ch_b = s.charAt(i);
          } 
          while (!(('a' <= ch_e && ch_e <= 'z') || ('A' <= ch_e && ch_e <= 'Z') || Character.isDigit(ch_e))){
              j--;
              ch_e = s.charAt(j);
          }
          if (p.ispalindrome(ch_b, ch_e))
          {
              i++;
              ch_b = s.charAt(i);
              j--;
              ch_e = s.charAt(j);
          }
          else
          {
              return false;
          }
      }
      return true; 
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        if (palindrom(s)){
            System.out.println("Yes");
        }
        else
        {
            System.out.println("no");
        }
//        IsPalindrome p = new CasePalindrome2();
  //      System.out.println(palindrom(s,p));
    }
}
