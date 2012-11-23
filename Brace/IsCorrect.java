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
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '<')
            {
                stac.push(s.charAt(i));
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
                    Object n =  stac.pop();
                    if (!n.equals('<'))
                    {
                        return false;
                    }
                    break;
                }
                case '/':
                {
                    i++;
                    if (s.charAt(i) == '>')
                    {
                        if(stac.isEmpty())
                        {
                            return false;
                        }
                        Object n =  stac.pop();
                        if (!n.equals('<'))
                        {
                            return false;
                        }
                    }
                    break;
                }
            }
            i++;    
        }
        if (stac.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
