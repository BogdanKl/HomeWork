package cloudes;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Clouds {

    protected IDaylight daylight = new Daylight();
    protected ILuminary luminary = new Luminary();
    protected IWind wind = new Wind();
    protected IMagic magic = new Magic();
    private int power;
    private boolean sun;
    private Timeofday day;

    Clouds(IDaylight d, ILuminary l, IWind w, IMagic m){ 
        daylight = d;
        luminary = l;
        wind = w;
        magic =m;
      }

    public Creature iternalCreate() {
        power = wind.getPower();
        sun = luminary.isShining();
        day = daylight.current();
        if (sun) {
            if (((0 <= power) && power <= 4) && day == Timeofday.MORNING) {
                return new Creature(Animals.HEDGEHOG);
            }
            if ((1 <= power && power <= 4) && day == Timeofday.EVENING) {
                return new Creature(Animals.BEAR);
            }
            if ((2 <= power && power <= 7) && day == Timeofday.NIGHT) {
                return new Creature(Animals.BAT);
            }
            if ((4 <= power && power <= 6) && day == Timeofday.EVENING) {
                return new Creature(Animals.BALLON);
            }
            throw new NotImplementedException();
        } else {
            if ((0 <= power && power <= 2) && day == Timeofday.MORNING) {
                return new Creature(Animals.PUPPY);
            }
            if (0 == power && day == Timeofday.DAY) {
                return new Creature(Animals.KITTEN);
            }
            if ((1 <= power && power <= 3) && day == Timeofday.DAY) {
                return new Creature(Animals.PIG);
            }
            throw new NotImplementedException();

        }
    }

    public Creature create() {
        Creature creature = iternalCreate();
        switch (creature.getCreatureType()) {
            case KITTEN:
            case BALLON:
            case HEDGEHOG:
                magic.callStork(creature.getCreatureType());
                break;
            default:
                magic.callDaemon(creature.getCreatureType());
        }

        return creature;
    }

}
