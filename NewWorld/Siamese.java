package worlds;

import java.util.Random;

public class Siamese extends Pets {
    private static boolean placeHome;
    private static boolean sleep;
    private static boolean seeDog ;
    private static boolean seeMaus;
    private Random r = new Random(); 
    private static int hangry;
    public void setSiamese(boolean place, boolean dog, boolean maus, int h){
        placeHome = place;
        seeDog = dog;
        seeMaus = maus;
        hangry = h;
      }
    @Override
    public void getStatus() {
       System.out.println("\n"+"Cat");
       System.out.println("Sleep: "+sleep);
       System.out.println("Home: "+ placeHome);
       System.out.println("See dog"+ seeDog);
       System.out.println("See maus"+ seeMaus);
    }

    @Override
    public void eat() {
       if (hangry < 2)
       {
           hangry++;
           Choose.choose(TAnimals.Siamese, Action.noise);
       }
       if (hangry == 2)
       {
           sleep = true;
       }
    }

    @Override
    public void lookaround() {
        MauseVole maus = new MauseVole();
        if(maus.isHome() == placeHome && r.nextInt(10)<6)
        {
            
            seeMaus =true;
        }
        else
        {
            seeMaus = false;
        }
        Dog dog = new Dog();
        if(dog.isHome() == placeHome && r.nextInt(10)<9)
        {
            seeDog = true;
        }
        else
        {
            seeDog = false;
        }
    }

    @Override
    public void heard() {
        sleep =false;
        Choose.choose(TAnimals.Siamese, Action.lookaround);
    }

    @Override
    public void bite() {
        if(seeDog){
            seeMaus=false;
            if (placeHome)
            {
                placeHome = !placeHome;
               Choose.choose(TAnimals.Siamese,Action.goOut);
            }
            else
            {
                placeHome = !placeHome;
                Choose.choose(TAnimals.Siamese, Action.goHome);
            }
        }
        if(seeMaus)
        {
            Choose.choose(TAnimals.Siamese,Action.bite);
        }
        
    }

    @Override
    public boolean isHome() {
        return placeHome;
    }

    @Override
    public boolean isOut() {
        return (!placeHome);
    }

    @Override
    public int isHangry() {
        return hangry;
    }

    @Override
    public void noise() {
        Choose.choose(TAnimals.Dog, Action.heard);
        Choose.choose(TAnimals.MausVole, Action.heard);
    }
    
}
