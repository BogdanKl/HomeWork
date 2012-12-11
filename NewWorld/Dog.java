package worlds;

import java.util.Random;

public class Dog extends Pets{
          
        private boolean placeHome;
        private boolean[] seeCat;
        private boolean[] seeRat;
        private int hungry;
        private Random ran = new Random();
        private Siamese[] s = Worlds.cat;
        private int sl = Worlds.catlen;
        private Rat[] r = Worlds.rat;
        private int rl = Worlds.ratlen;
        public int vision =55;
        public int reserve = 10;
        public String name;
        Dog(String n, boolean home, int h)
        {
            name = n;
            placeHome = home;
            hungry =h;
        }

    @Override
    public void getStatus() {
       System.out.println("\n"+"Dog");
       System.out.println("Home: "+ placeHome);
       System.out.println("See cat:"+ seeCat);
       System.out.println("See rat: "+ seeRat);
    }

    @Override
    public void eat() {
        if(hungry < 2)
        {
            hungry++;
        }
    }

    @Override
    public void lookaround() {
        for (int i =0; i < sl; i++)
        {
            if (placeHome == s[i].isHome() && ran.nextInt(100)< this.visibility(s[i].vision))
            {
                seeCat[i] = true;
            }
            else
            {
                seeCat[i] = false;
            }
        }
        for(int j =0; j < rl; j++)
        {
            if(placeHome == r[j].isHome() && ran.nextInt(100) < this.visibility(r[j].vision))
            {
                seeRat[j] = true;
            }
            else
            {
                seeRat[j] = false;
            }
        }
    }

    @Override
    public void heard() {
        Choose.choose(this, Action.lookaround);
    }

    @Override
    public void bite() {
        for(int i = 0; i < sl; i++)
        {
        if(seeCat[i])
        {
            Choose.choose(s[i], Action.goHome);
            break;
        }
        else
        {
            for(int j = 0; j < rl; j++)
            {
            if(seeRat[j])
            {
                
                Choose.choose(r[j], Action.goHome);
                break;
            }
            }
        }
        }
    }

    @Override
    public void noise() {
        for(int i = 0; i < sl; i++)
        {
          Choose.choose(s[i], Action.heard);
        }
        for(int j = 0; j < rl; j++)
        {
            Choose.choose(r[j], Action.heard);
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
    public int isHungry() {
        return hungry;
    }
    
    @Override
    public void goHome()
    {
        placeHome = true;
        this.seeCat = null;
        this.seeRat = null;
    }
    
    @Override
    public void goOut()
    {
        placeHome =false;
        this.seeCat = null;
        this.seeRat = null;
    }
    
    @Override
    public String getName()
    {
        return name;
    }
   
}


