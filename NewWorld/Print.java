package worlds;
public class Print {
    public static void print(TAnimals an, Action act)
    {
        switch(act)
        {
            case eat:{ System.out.println(an + " "+ " is eating"); break; }
            case bite:{System.out.println(an +" "+"bite"); break;}
            case lookaround:{System.out.println(an+" "+"look around"); break; }
            case heard:{System.out.println(an+" "+"heard" ); break;}
            case noise:{System.out.println(an + " "+"make a noise"); break;}
            case goHome:{System.out.println(an+" "+"go home"); break;}
            case goOut:{System.out.println(an + " "+ "go out"); break;}
        }
    }
}
