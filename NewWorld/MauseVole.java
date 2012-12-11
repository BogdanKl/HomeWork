package worlds;

import java.util.Random;

public class MauseVole extends Maus {

    private boolean placeHome;
    private boolean[] seeCat;
    private boolean[] seeRat;
    private int hungry;
    private Random ran = new Random();
    private Siamese[] s = Worlds.cat;
    private int sl = Worlds.catlen;
    private Rat[] r = Worlds.rat;
    private int rl = Worlds.ratlen;
    private int reserve = 33;
    public int vision = 45;
    public String name;

    MauseVole(String n, boolean home, int h) {
        name = n;
        placeHome = home;
        hungry = h;
    }

    @Override
    public void getStatus() {
        System.out.println("\n" + "Maus");
        System.out.println("Home: " + placeHome);
        System.out.println("Cat: " + seeCat);
        System.out.println("Rat: " + seeRat);
    }

    @Override
    public void eat() {
        for (int i = 0; i < rl; i++) {
            if (r[i].isHungry() == 3) {
                if (hungry < 2) {
                    hungry++;
                }
            }
        }
    }

    @Override
    public void lookaround() {
        for (int i = 0; i < sl; i++) {
            if (s[i].isHome() == placeHome && ran.nextInt(100) < this.visibility(s[i].vision)) {
                seeCat[i] = true;
            } else {
                seeCat[i] = false;
            }
        }
        for (int i = 0; i < rl; i++) {
            if (r[i].isHome() == placeHome && ran.nextInt(100) < this.visibility(r[i].vision)) {
                seeRat[i] = true;
            } else {
                seeRat[i] = false;
            }
        }
    }

    @Override
    public void heard() {
        Choose.choose(this, Action.lookaround);
    }

    @Override
    public void bite() {
    }

    @Override
    public void noise() {
        for (int i = 0; i < sl; i++) {
            Choose.choose(s[i], Action.heard);
        }
        for (int i = 0; i < rl; i++) {
            Choose.choose(r[i], Action.heard);
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
        this.seeCat = null;
        this.seeRat = null;
    }

    @Override
    public void goOut() {
        placeHome = true;
        this.seeCat = null;
        this.seeRat = null;
    }

    @Override
    public String getName() {
        return name;
    }
}
