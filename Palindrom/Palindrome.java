package palindrome;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindrome {

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s = input.readLine();
        IsPalindrome p = new CasePalindrome1();
        System.out.println(p.ispalindrome(s));
        p = new CasePalindrome2();
        System.out.println(p.ispalindrome(s));
    }
}
