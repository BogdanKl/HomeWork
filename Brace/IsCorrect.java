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
            if (s.charAt(i) == '<' && s.charAt(i+1) != '/')
            {
               stac.push(s.charAt(i));
               i++;
               while (i < leng && s.charAt(i) == ' ')
               {
                   i++;
               }
               String name = "";
               while (i < leng && (Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i))))
               {
                   name += s.charAt(i);
                   i++;
               }
               stac.push(name);
               while (s.charAt(i) != '>' && (i < leng))
               {
                   i++;
               }
               if (i == leng && s.charAt(i) != '>' )
               {
                   System.out.println("Error");
                   return false;
               }
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
                case '<':
                {
                    i++;
                    if (s.charAt(i)=='/')
                    {
                        i++;
                        if (!">".equals(stac.pop().toString()))
                        {
                            return false;
                        }
                        while (i < leng && s.charAt(i) == ' ')
                        {
                            i++;
                        }
                        String n = "";
                        while (i < leng && Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))
                        {
                            n += s.charAt(i);
                            i++;
                        }
                        while (i < leng && s.charAt(i) != '>')
                        {
                            i++;
                        }
                        if(i == leng && s.charAt(i) != '>')
                        {
                            System.out.println("Error");
                            return false;
                        }
                        String name = (String) stac.pop();
                        if (!name.equals(n))
                        {
                            return false;
                        }
                        if (!"<".equals(stac.pop().toString()))
                        {
                            return false;
                        }
                    }
                }
            }
            i++;    
        }
        return stac.isEmpty();
    }
}
