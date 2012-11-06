package projectworld;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cat extends Reaction {
    private static boolean sleep = true;
    private static boolean inhome = true;
    private static boolean founddog = false;
    private static boolean foundmaus = false;
    Choose ch = new Choose();
    Print p = new Print();
    @Override
    public void eating() {
        if (inhome)
        {
            sleep = false;
            p.print(Animals.CAT, Action.EATING, Animals.NULL);
            try {
                ch.choose(Animals.CAT, Action.SQUEK);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
           sleep = false;
            try {
                ch.choose(Animals.CAT, Action.CHANGESTATES);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
           p.print(Animals.CAT, Action.CHANGESTATES, Animals.NULL);
            try {
                ch.choose(Animals.DOG, Action.HEARD);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ch.choose(Animals.CAT, Action.EATING);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void lookround() {
        Dog dog = new Dog();
        if (inhome == dog.isinhome())
        {
            p.print(Animals.CAT, Action.LOOKAROUND, Animals.DOG);
            founddog = true;
            try {
                ch.choose(Animals.CAT, Action.CHANGESTATES);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        Maus maus = new Maus();
        if (inhome == maus.isinhome())
        {
            foundmaus = true; 
            try {
                ch.choose(Animals.CAT, Action.BIT);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
            p.print(Animals.CAT, Action.LOOKAROUND, Animals.MAUS);
        }
    }

    @Override
    public void heard() {
       if( foundmaus)
       {
            try {
                ch.choose(Animals.CAT, Action.BIT);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
           p.print(Animals.CAT, Action.HEARD, Animals.MAUS);
       }
       if (founddog)
       {
            try {
                ch.choose(Animals.CAT, Action.CHANGESTATES);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
           p.print(Animals.CAT, Action.HEARD, Animals.DOG);
       }
    }

    @Override
    public void bit() {
        Maus maus = new Maus();
        if(inhome == maus.isinhome())
        {
            p.print(Animals.CAT, Action.BIT, Animals.MAUS);
            try {
                ch.choose(Animals.MAUS, Action.KILL);
            } catch (Exception ex) {
                Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void changestates() {
        if (sleep == true)
        {
            sleep = false;
        }
        if (inhome == true)
        {
            inhome =false;
        }
        else
        {
            inhome = true;
        }
        p.print(Animals.CAT, Action.CHANGESTATES, Animals.NULL);
    }
    @Override
    public void squek(){
        Random r = new Random();
        int counter = r.nextInt(4);
        Dog dog = new Dog();
        if(inhome == dog.isinhome())
        {
            p.print(Animals.CAT, Action.SQUEK, Animals.NULL);
            if (counter<=4)
            {
                try {
                    ch.choose(Animals.DOG, Action.HEARD);
                } catch (Exception ex) {
                    Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        Maus maus = new Maus();
        if(inhome == maus.isinhome())
        {
            p.print(Animals.CAT, Action.SQUEK, Animals.NULL);
            if (counter == 0)
            {
               try {
                    ch.choose(Animals.MAUS, Action.HEARD);
                } catch (Exception ex) {
                    Logger.getLogger(Cat.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public boolean isSleep()
    {
        return sleep;
    }
    public boolean isinhome()
    {
        return inhome;
    }
    
}
