package projectworld;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Dog extends Reaction {
    private static boolean inhome = true;
    private static boolean foundcat = false;
    Choose ch = new Choose();
    Print p = new Print();
    @Override
    public void eating() {
        p.print(Animals.DOG, Action.EATING, Animals.NULL);
        try {
            ch.choose(Animals.DOG, Action.SQUEK);
        } catch (Exception ex) {
            Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void lookround() {
        Cat cat = new Cat();
        if (cat.isinhome() == inhome)
        {
            foundcat = true;
            p.print(Animals.DOG, Action.LOOKAROUND, Animals.CAT);
            try {
                ch.choose(Animals.DOG, Action.BIT);
            } catch (Exception ex) {
                Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void heard() {
        if (foundcat)
        {
            p.print(Animals.DOG, Action.HEARD, Animals.CAT);
            try {
                ch.choose(Animals.DOG, Action.CHANGESTATES);
            } catch (Exception ex) {
                Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            p.print(Animals.DOG, Action.UNUSEFULL, Animals.NULL);
            try {
                ch.choose(Animals.DOG, Action.LOOKAROUND);
            } catch (Exception ex) {
                Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void bit() {
        Cat cat = new Cat();
        if(inhome == cat.isinhome())
        {
            p.print(Animals.DOG, Action.BIT, Animals.CAT);
            try {
                ch.choose(Animals.CAT, Action.CHANGESTATES);
            } catch (Exception ex) {
                Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void changestates() {
      p.print(Animals.DOG, Action.CHANGESTATES, Animals.NULL);
      inhome = !inhome;
    }
    @Override
    public void squek(){
        p.print(Animals.DOG, Action.SQUEK, Animals.NULL);
        try {
            ch.choose(Animals.CAT,Action.HEARD);
        } catch (Exception ex) {
            Logger.getLogger(Dog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isinhome() {
        return inhome;
    }
}
