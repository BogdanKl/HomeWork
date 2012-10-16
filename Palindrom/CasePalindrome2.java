
package palindrome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CasePalindrome2 extends IsPalindrome {

    @Override
    public boolean ispalindrome(String s) {
        s = s.toLowerCase();
       // throw new UnsupportedOperationException("Not supported yet.");
        String wrong ="[a-z||0-9]{1}[a-z||0-9]+";
        Pattern p = Pattern.compile(wrong);
        Matcher m = p.matcher(s);
        boolean flag = m.matches();
        if (flag == true)
        {
            int i = 0;
            int j = s.length()-1;
            while ((i<=j)&&(flag == true))
            {
                if (s.charAt(i) != s.charAt(j))
                {
                    flag = false;
                }     
                i++;
                j--;
            }
        }
        return flag;
     }
}
    
