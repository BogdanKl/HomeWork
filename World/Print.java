package projectworld;
public class Print {
    public void print(Animals an, Action act, Animals other)
    {
        switch (an)
        {
            case CAT:{
                switch (act)
                {
                    case EATING:
                    {
                        System.out.println("Cat is eating");
                    }
                    break;
                    case LOOKAROUND:
                    {
                        System.out.println(an + " found" + other);
                    }
                    break;
                    case HEARD:
                    {
                        System.out.println(an + " heard" + other);
                    }
                    break;
                    case BIT:
                    {
                        System.out.println(an + " kill maus");
                    }
                    break;
                    case CHANGESTATES:
                    {

                            System.out.println (an + " changestate");
                    }
                    case UNUSEFULL:
                    {
                      System.out.println(an + " nothing usefull");  
                    }
                    break;
                    case SQUEK:
                    {
                        System.out.println(an + " squek");
                    }
                    break;
                    default:
                    {
                       System.out.println(" Error in arguments ACTION");
                       throw new IllegalArgumentException();
                    }
                }
            }
            break;
            case MAUS:{
                switch (act)
                {
                    case EATING:
                    {
                        System.out.println(an + " eating");
                    }
                    break;
                    case LOOKAROUND:
                    {
                      System.out.println(an + " found" + other);  
                    }
                    break;
                    case HEARD:
                    {
                      System.out.println(an + " heard" + other);  
                    }
                    break;
                    case BIT:
                    {
                       System.out.println("Really?! =D") ;
                    }
                    break;
                    case CHANGESTATES:
                    {
                        Maus maus = new Maus();
                        if (maus.isinhome())
                        {
                            System.out.println (an + " come home");
                        }
                        else
                        {
                            System.out.println (an + " come street");
                        }
                    }
                    case UNUSEFULL:
                    {
                      System.out.println(an + " nothing usefull");  
                    }
                    break;
                    case SQUEK:
                    {
                        System.out.println(an + " squek");
                    }
                    break;
                    default:
                    {
                       System.out.println(" Error in arguments ACTION");
                       throw new IllegalArgumentException();
                    }
                }
            }
            break;
            case DOG:{
                switch (act)
                {
                    case EATING:
                    {
                        System.out.println(an + " is eating");
                    }
                    break;
                    case LOOKAROUND:
                    {
                        System.out.println(an + " found" + other);
                    }
                    break;
                    case HEARD:
                    {
                        System.out.println(an + " heard" + other);
                    }
                    break;
                    case BIT:
                    {
                        System.out.println(an + " is bit cat");
                    }
                    break;
                    case CHANGESTATES:
                    {
                        Dog dog = new Dog();
                        if (dog.isinhome())
                        {
                            System.out.println (an + " come home");
                        }
                        else
                        {
                            System.out.println (an + " come street");
                        }
                    }
                    case UNUSEFULL:
                    {
                      System.out.println(an + "nothing usefull");  
                    }
                    break;
                    case SQUEK:
                    {
                        System.out.println(an + " squek");
                    }
                    break;
                    default:
                    {
                       System.out.println(" Error in arguments ACTION");
                       throw new IllegalArgumentException();
                    }
                }
            }
            break;
            default:
            {
              System.out.println(" Error in arguments ANIMALS");
              throw new IllegalArgumentException();
            }
        }
    }
    
}
