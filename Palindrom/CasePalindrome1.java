
package palindrome;

   
public class CasePalindrome1 extends IsPalindrome{

    @Override
    public boolean ispalindrome(char ch, char sh) {
        if (sh == ch)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

  }
