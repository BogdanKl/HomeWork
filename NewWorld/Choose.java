package worlds;
public class Choose {
    public static void  choose(Animals an, Action act)
    {
        Print.print(an, act);
        switch (act)
        {
            case getStatus :{
                an.getStatus();
                break;
            }
            case eat:{
                an.eat();
                break;
            }
            case bite:{
                an.bite();
                break;
            }
            case lookaround:{
                an.lookaround();
                break;
            }
            case heard:{
                an.heard();
                break;
            }
            case noise:{
                an.noise();
                break;               
            }
            case goHome:{
                an.goHome();
            }
            case goOut:{
                an.goOut();
            }
        }
    }
    
}
