package worlds;

import java.util.Random;

public class Rat extends Maus{
    private static boolean placeHome;
    private static boolean seeDog;
    private static boolean seeMaus;
    private static int hangry;
    private Random ran = new Random();
    public void setRat(boolean place, boolean dog, boolean maus, int h){
        placeHome = place;
        seeDog = dog;
        seeMaus = maus;
        hangry = h;
      }
    @Override
    public void getStatus() {
       System.out.println("\n"+"Rat"); 
       System.out.println("Home: "+ placeHome);
       System.out.println("See Dog" + seeDog);
       System.out.println("See Maus"+ seeMaus);
    }

    @Override
    public void eat() {
        if (hangry < 2)
        {
            hangry++;
        }
    }

    @Override
    public void lookaround() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void heard() {
        Choose.choose(TAnimals.Rat, Action.lookaround);
    }

    @Override
    public void bite() {
        if (seeMaus)
        {
            if (placeHome)
            {
                Choose.choose(TAnimals.MausVole, Action.goHome);
            }
            else
            {
                Choose.choose(TAnimals.MausVole, Action.goOut);
            }
        }
    }

    @Override
    public void noise() {
        Choose.choose(TAnimals.Dog, Action.heard);
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
    
}
