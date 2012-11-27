package cloudes;

import java.util.Random;

public class Daylight implements iDaylight {
    private Random r = new Random();
    @Override
    public Timeofday current() {
        Timeofday time;
        switch (r.nextInt(5))
        {
            case 1: time = Timeofday.MORNING; break;
            case 2: time = Timeofday.DAY; break;
            case 3: time = Timeofday.EVENING; break;
            default: time = Timeofday.NIGHT; break;
        }
        return time;
    }
    }
