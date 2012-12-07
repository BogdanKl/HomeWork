package worlds;

import java.util.Random;

public class MauseVole extends Maus {
    private static boolean placeHome;
    private static boolean seeCat;
    private static boolean seeRat;
    private static int hangry;
    private Random ran = new Random(); 
    public void setMauseVole(boolean place, boolean cat, boolean rat, int h){
        placeHome = place;
        seeCat = cat;
        seeRat = rat;
        hangry = h;
      }
    @Override
    public void getStatus() {
       System.out.println("\n"+"Maus");
       System.out.println("Home: "+ placeHome);
       System.out.println("Cat: "+ seeCat);
       System.out.println("Rat: "+seeRat);
    }

    @Override
    public void eat() {
        Rat rat = new Rat();
        if (rat.isHangry()==2)
        {
            if(hangry <2)
            {
                hangry++;
            }
        }
    }

    @Override
    public void lookaround() {
        Siamese cat = new Siamese();
        Rat rat = new Rat();
        if (cat.isHome() == placeHome && ran.nextInt(10)<8)
        {
            seeCat = true;
        }
        if (rat.isHome() == placeHome && ran.nextInt(10)<7)
        {
            seeRat = true;
        }
    }

    @Override
    public void heard() {
        Choose.choose(TAnimals.MausVole, Action.lookaround);
    }

    @Override
    public void bite() {
        
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
    
}
