package worlds;

import java.util.Random;

public class Dog extends Pets{
        private static boolean placeHome;
        private static boolean seeCat;
        private static boolean seeRat;
        private static int hangry;
        private Random ran = new Random();


    @Override
    public void getStatus() {
       System.out.println("\n"+"Dog");
       System.out.println("Home: "+ placeHome);
       System.out.println("See cat:"+ seeCat);
       System.out.println("See rat: "+ seeRat);
    }

    @Override
    public void eat() {
        if(hangry < 2)
        {
            hangry++;
        }
    }

    @Override
    public void lookaround() {
        Siamese cat = new Siamese();
        if(cat.isHome() == placeHome && ran.nextInt(10)<6)
        {
            seeCat =true;
        }
        Rat rat = new Rat();
        {
            if(rat.isHome() == placeHome && ran.nextInt(10)<5)
            {
                seeRat = true;
            }
        }
    }

    @Override
    public void heard() {
        Choose.choose(TAnimals.Dog, Action.lookaround);
    }

    @Override
    public void bite() {
        if(seeCat)
        {
            Choose.choose(TAnimals.Dog, Action.bite);
        }
        else
        {
            if(seeRat)
            {
                
                Choose.choose(TAnimals.Dog, Action.bite);
            }
        }
    }

    @Override
    public void noise() {
        Choose.choose(TAnimals.Siamese, Action.heard);
        Choose.choose(TAnimals.Rat, Action.heard);
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
        public static void setDog(boolean place, boolean cat, boolean rat, int h){
        placeHome = place;
        seeCat = cat;
        seeRat = rat;
        hangry = h;
      }
    
}
