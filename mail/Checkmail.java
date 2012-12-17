
package mail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Checkmail {
    public static boolean checkmail(String str){
    String name = "([a-zA-Z_]){1}[a-zA-Z|_|-|[0-9]]*[.]{0,1}[a-zA-Z|_|-|[0-9]]*";
    String name2 ="([a-zA-Z]{1}[a-zA-Z|_|-|[0-9]]*)";
    String adress = "(([a-z]{2,3})|name|info|asia|aero|coop|jobs|mobi|museum|travel)";	
    Pattern p = Pattern.compile(name + "@" + name2 + "." + adress);
    Matcher m = p.matcher(str);
    boolean result = m.matches();
    return (result);
    }
    
}
