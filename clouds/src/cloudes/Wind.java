package cloudes;

import java.util.Random;

public class Wind implements IWind{
    private Random r = new Random();
    @Override
    public int getPower() {
        return r.nextInt(11);
    }

}
