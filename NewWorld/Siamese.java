package worlds;

import java.util.Random;

public class Siamese extends Pets {

    private boolean placeHome;
    private boolean sleep;
    private boolean[] seeDog;
    private boolean[] seeMaus;
    private Random r = new Random();
    private int hungry;
    private static Dog[] d;
    private static int dl;
    private static Maus[] m;
    private static int ml;
    public int vision = 65;
    public String name;

    Siamese(String n, boolean home, int h) {
        name = n;
        placeHome = home;
        hungry = h;
    }

    static void set() {
        d = Worlds.dog;
        dl = Worlds.doglen;
        m = Worlds.maus;
        ml = Worlds.mauslen;
    }

    @Override
    public void getStatus() {
        System.out.println("\n" + "Cat");
        System.out.println("Sleep: " + sleep);
        System.out.println("Home: " + placeHome);
        System.out.println("See dog" + seeDog);
        System.out.println("See maus" + seeMaus);
    }

    @Override
    public void eat() {
        if (hungry < 2) {
            hungry++;
            Choose.choose(this, Action.noise);
        }
        if (hungry == 2) {
            sleep = true;
        }
    }

    @Override
    public void lookaround() {
        for (int i = 0; i < ml; i++) {
            if (m[i].isHome() == placeHome && r.nextInt(100) < this.visibility(m[i].reserve)) {

                seeMaus[i] = true;
            } else {
                seeMaus[i] = false;
            }
        }
        for (int i = 0; i < dl; i++) {
            if (d[i].isHome() == placeHome && r.nextInt(100) < this.visibility(d[i].visibility(d[i].reserve))) {
                seeDog[i] = true;
            } else {
                seeDog[i] = false;
            }
        }
    }

    @Override
    public void heard() {
        sleep = false;
        Choose.choose(this, Action.lookaround);
    }

    @Override
    public void bite() {
        for (int i = 0; i < dl; i++) {
            if (seeDog[i]) {
                seeMaus[i] = false;
                if (placeHome) {
                    placeHome = !placeHome;
                    Choose.choose(this, Action.goOut);
                } else {
                    placeHome = !placeHome;
                    Choose.choose(this, Action.goHome);
                }
            }
        }
        for (int i = 0; i < ml; i++) {
            if (seeMaus[i]) {
                Choose.choose(m[i], Action.goOut);
            }
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
    public void noise() {
        for (int i = 0; i < dl; i++) {
            Choose.choose(d[i], Action.heard);
        }
        for (int i = 0; i < ml; i++) {
            Choose.choose(m[i], Action.heard);
        }
    }

    @Override
    public void goHome() {
        placeHome = true;
        this.seeMaus = null;
        this.seeDog = null;
    }

    @Override
    public void goOut() {
        placeHome = true;
        this.seeMaus = null;
        this.seeDog = null;
    }

    @Override
    public String getName() {
        return name;
    }
}
