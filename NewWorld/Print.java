package worlds;
public class Print {
    public static void print(Animals an, Action act)
    {
        switch(act)
        {
            case eat:{ System.out.println(an.getName() + " "+ " is eating"); break; }
            case bite:{System.out.println(an.getName() +" "+"bite"); break;}
            case lookaround:{System.out.println(an.getName()+" "+"look around"); break; }
            case heard:{System.out.println(an.getName()+" "+"heard" ); break;}
            case noise:{System.out.println(an.getName() + " "+"make a noise"); break;}
            case goHome:{System.out.println(an.getName()+" "+"go home"); break;}
            case goOut:{System.out.println(an.getName()+ " "+ "go out"); break;}
        }
    }
}
