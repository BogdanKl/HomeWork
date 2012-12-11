package worlds;

import java.util.Random;

public class Rat extends Maus {

    private boolean placeHome;
    private boolean[] seeDog;
    private boolean[] seeMaus;
    private int hungry;
    private int reserve = 20;
    private Maus[] m = Worlds.maus;
    private int ml = Worlds.mauslen;
    private Dog[] d = Worlds.dog;
    private int dl = Worlds.doglen;
    private Random ran = new Random();
    public String name;
    public int vision = 60;

    Rat(String n, boolean place, int h) {
        name = n;
        placeHome = place;
        hungry = h;
    }

    @Override
    public void getStatus() {
        System.out.println("\n" + "Rat");
        System.out.println("Home: " + placeHome);
        System.out.println("See Dog" + seeDog);
        System.out.println("See Maus" + seeMaus);
    }

    @Override
    public void eat() {
        if (hungry < 3) {
            hungry++;
        }
    }

    @Override
    public void lookaround() {
        for (int i = 0; i < ml; i++) {
            if (placeHome == m[i].isHome() && ran.nextInt(100) < this.visibility(m[i].reserve)) {
                seeMaus[i] = true;
            } else {
                seeMaus[i] = false;
            }

        }
        for (int i = 0; i < dl; i++) {
            if (placeHome == m[i].isHome() && ran.nextInt(100) < this.visibility(d[i].reserve)) {
                seeDog[i] = false;
            } else {
                seeDog[i] = false;
            }
        }
    }

    @Override
    public void heard() {
        Choose.choose(this, Action.lookaround);
    }

    @Override
    public void bite() {
        for (int i = 0; i < ml; i++) {
            if (seeMaus[i]) {
                if (placeHome) {
                    Choose.choose(m[i], Action.goHome);
                } else {
                    Choose.choose(m[i], Action.goOut);
                }
            }
        }
    }

    @Override
    public void noise() {
        for (int i = 1; i < dl; i++) {
            Choose.choose(d[i], Action.heard);
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
    public void goHome() {
        placeHome = true;
        this.seeDog = null;
        this.seeMaus = null;
    }

    @Override
    public void goOut() {
        placeHome = false;
        this.seeDog = null;
        this.seeMaus = null;
    }

    @Override
    public String getName() {
        return name;
    }
}
