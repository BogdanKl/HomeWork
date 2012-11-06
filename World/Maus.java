package projectworld;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Maus extends Reaction{
    private static boolean inhome = true;
    private static boolean foundcat = false;
    private static boolean alive =true; 
    Choose ch = new Choose();
    Print p = new Print();

    @Override
    public void eating() {
        if (alive)
        {
            p.print(Animals.MAUS, Action.EATING, Animals.NULL);
            try {
                ch.choose(Animals.MAUS, Action.SQUEK);
            } catch (Exception ex) {
                Logger.getLogger(Maus.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void lookround() {
        if (alive)
        {
            Cat cat = new Cat();
            if (cat.isinhome() == inhome) {
                foundcat = true;
                p.print(Animals.MAUS, Action.LOOKAROUND, Animals.NULL);
            }
        }
    }

    @Override
    public void heard() {
        if (alive)
        {
            if (foundcat) {
                p.print(Animals.MAUS, Action.HEARD, Animals.CAT);
                try {
                    ch.choose(Animals.MAUS, Action.CHANGESTATES);
                } catch (Exception ex) {
                    Logger.getLogger(Maus.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public void bit() {
        p.print(Animals.MAUS, Action.BIT ,Animals.NULL);
    }

    @Override
    public void changestates() {
        if (alive)
        {
            inhome = !inhome;
            p.print(Animals.MAUS, Action.CHANGESTATES, Animals.NULL);
        }
    }
    @Override
    public void squek(){
        if (alive)
        {
            Cat cat = new Cat();
            Random r = new Random();
            int counter = r.nextInt(4);
            if (inhome == cat.isinhome()) {
                p.print(Animals.MAUS, Action.SQUEK, Animals.NULL);
                if (counter <= 3) {
                    try {
                        ch.choose(Animals.CAT, Action.HEARD);
                    } catch (Exception ex) {
                        Logger.getLogger(Maus.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    public boolean isinhome() {
        return inhome;
    }

    public void kill() {
       alive = false;
    }
}
