
package cloudes;

import static org.junit.Assert.*;
import org.junit.Test;


public class CloudsTest {
   
    @Test
    public void testIternalCreate() {
        System.out.println("iternalCreate");
        Day[] day = {new Day(Timeofday.MORNING), new Day(Timeofday.DAY), new Day(Timeofday.MORNING),
            new Day(Timeofday.EVENING), new Day(Timeofday.DAY), new Day(Timeofday.NIGHT), new Day(Timeofday.EVENING)};
        IsShining[] sun = {new IsShining(false), new IsShining(false), new IsShining(true),
            new IsShining(true), new IsShining(false), new IsShining(true), new IsShining(true)};
        TWind[] wind = {new TWind(1), new TWind(0), new TWind(3), new TWind(3), new TWind(2), new TWind(5), new TWind(5)};
        Animals[] animal = {Animals.PUPPY, Animals.KITTEN, Animals.HEDGEHOG, Animals.BEAR, Animals.PIG, Animals.BAT, Animals.BALLON};
        for (int i = 0; i < 7; i++) {
            Clouds cloud = new Clouds(day[i], sun[i], wind[i]);
            Animals result = cloud.create().getCreatureType();
            assertEquals(animal[i], result);
            System.out.println("Day: " + day[i] + " Sun: " + sun[i] + " Wind: " + wind[i] + " Result: " + result + " ExpResult: " + animal[i]);
        }
    }

}
