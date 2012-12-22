package branches;

import java.util.Stack;

public class IsCorrect {
    protected Stack stac =new Stack(); 
    public boolean iscorrect(String s)
    {
        int leng = s.length();
        int i = 0;
        while (i < leng)
        {
            if (s.charAt(i) == '(' || s.charAt(i) == '[')
            {
                stac.push(s.charAt(i));
            }
            if (s.charAt(i) == '<')
            {
                stac.push(s.charAt(i));
                i++;
                if (s.charAt(i) == '/')
                {
                    i++;
                }
                String name ="";
                while (Character.isLetter(s.charAt(i)))
                {
                    name += s.charAt(i);
                    i++;
                }
                stac.push(name);
            }
            switch (s.charAt(i))
            {
                case ')':{
                    if(stac.isEmpty())
                    {
                        return false;
                    }
                    Object n =  stac.pop();
                    if (!n.equals('('))
                    {
                        return false;
                    } 
                    break;
                }
                case ']' :
                {
                    if(stac.isEmpty())
                    {
                        return false;
                    }
                    Object n =  stac.pop();
                    if (!n.equals('['))
                    {
                        return false;
                    }
                    break;
                }
                case '>':
                {
                    if(stac.isEmpty())
                    {
                        return false;
                    }
                    Object nm = stac.pop();
                    Object n =  stac.pop();
                    int temp = i;
                    i--;
                    String str = "";
                    while( Character.isLetter(s.charAt(i)) )
                    {
                        str = s.charAt(i) + str;
                        i--;
                    }
                    i = temp;
                    if (!n.equals('<') && !nm.equals(str))
                    {
                        return false;
                    }
                    break;
                }
            }
            i++;    
        }
        return stac.isEmpty();
    }
}
