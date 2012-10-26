
package palindrome;

import java.util.regex.Pattern;

public class CasePalindrome2 extends IsPalindrome {

    @Override
    public boolean ispalindrome(char ch, char sh) {
        ch = Character.toLowerCase(ch);
        sh = Character.toLowerCase(sh);
        return(ch == sh);
    }


}
    
