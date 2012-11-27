package cloudes;

import java.util.Random;

public class Luminary implements iLuminary{
    private Random r = new Random();
    @Override
    public boolean isShining() {
        return r.nextBoolean();
    }

}
