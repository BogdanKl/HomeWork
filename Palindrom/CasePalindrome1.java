
package palindrome;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CasePalindrome1 extends IsPalindrome{
    @Override
    public boolean ispalindrome(String s) {
        //throw new UnsupportedOperationException("Not supported yet.");
        String wrong ="[a-zA-Z||0-9]+";
        Pattern p = Pattern.compile(wrong);
        Matcher m = p.matcher(s);
        boolean flag = m.matches();
        if (flag)
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
