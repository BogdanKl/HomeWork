package worlds;
public class Choose {
    private static MauseVole maus = new MauseVole();
    private static Dog dog = new Dog();
    private static Rat rat = new Rat();
    private static Siamese cat = new Siamese();
    Choose()
    {
     dog.setDog(true,false,false,0);
     rat.setRat(true,false,false,0);
     cat.setSiamese(true,false,false,0);
     maus.setMauseVole(true,false,false,0);
    }
    public static void  choose(TAnimals anim, Action act)
    {
        Animals an = null;
        Print.print(anim, act);
        switch (anim)
        {
            case Siamese:{
              an = cat;
              break;
            }
            case Dog:{
                an = dog;
                break;
            }
            case MausVole:{
                an = maus;
                break;
            }
            case Rat:{
                an = rat;
                break;
            }
            default:{
                throw new IllegalArgumentException("не сущестыует такого животного");
            }
        }
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
                an.placeHome = true;
            }
            case goOut:{
                an.placeHome = false;
            }
        }
    }
    
}
