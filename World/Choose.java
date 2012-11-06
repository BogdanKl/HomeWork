package projectworld;
class Choose {
    public void choose(Animals an, Action act) throws Exception
    {
        Cat cat = new Cat();
        Maus maus = new Maus();
        Dog dog = new Dog();
        switch (an)
        {
            case CAT:{
                switch (act)
                {
                    case EATING:
                    {
                       cat.eating(); 
                    }
                    break;
                    case LOOKAROUND:
                    {
                        cat.lookround();
                    }
                    break;
                    case HEARD:
                    {
                        cat.heard();
                    }
                    break;
                    case BIT:
                    {
                        cat.bit();
                    }
                    break;
                    case CHANGESTATES:
                    {
                        cat.changestates();
                    }
                    break;
                    case SQUEK:
                    {
                        cat.squek();
                    }
                    break;
                    default:
                    {
                       System.out.println("Error in arguments ACTION");
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
                        maus.eating();
                    }
                    break;
                    case LOOKAROUND:
                    {
                        maus.lookround();
                    }
                    break;
                    case HEARD:
                    {
                        maus.heard();
                    }
                    break;
                    case BIT:
                    {
                        maus.bit();
                    }
                    break;
                    case CHANGESTATES:
                    {
                        maus.changestates();
                    }
                    break;
                    case SQUEK:
                    {
                        maus.squek();
                    }
                    break;
                    default:
                    {
                       System.out.println("Error in arguments ACTION");
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
                        dog.eating();
                    }
                    break;
                    case LOOKAROUND:
                    {
                        dog.lookround();
                    }
                    break;
                    case HEARD:
                    {
                        dog.heard();
                    }
                    break;
                    case BIT:
                    {
                        dog.bit();
                    }
                    break;
                    case CHANGESTATES:
                    {
                        dog.changestates();
                    }
                    break;
                    case SQUEK:
                    {
                        dog.squek();
                    }
                    break;
                    default:
                    {
                       System.out.println("Error in arguments ACTION");
                       throw new IllegalArgumentException();
                    }
                }
            }
            break;
            default:
            {
              System.out.println("Error in arguments ANIMALS");
              throw new IllegalArgumentException();
            }
        }
    }
}
