
package cloudes;

import org.jmock.Expectations;
import org.jmock.Mockery;
import static org.junit.Assert.*;
import org.junit.Test;


public class CloudsTest {
    Mockery context = new Mockery();
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
            Clouds cloud = new Clouds(day[i], sun[i], wind[i], new Magic());
            Animals result = cloud.create().getCreatureType();
            assertEquals(animal[i], result);
            System.out.println("Day: " + day[i] + " Sun: " + sun[i] + " Wind: " + wind[i] + " Result: " + result + " ExpResult: " + animal[i]);
        }
    }
    @Test
    public void testIternalCreateKitten(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(0));
            one(day).current();will(returnValue(Timeofday.DAY));
            one(sun).isShining();will(returnValue(false));
            one(magic).callStork(Animals.KITTEN);
        }});
        cloud.create();
        context.assertIsSatisfied();
    }
    @Test
    public void testIternalCreatePuppy(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(1));
            one(day).current();will(returnValue(Timeofday.MORNING));
            one(sun).isShining();will(returnValue(false));
            one(magic).callDaemon(Animals.PUPPY);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 
    @Test
    public void testIternalCreateHEDGEHOG(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(0));
            one(day).current();will(returnValue(Timeofday.MORNING));
            one(sun).isShining();will(returnValue(true));
            one(magic).callStork(Animals.HEDGEHOG);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 
    @Test
    public void testIternalCreateBear(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(2));
            one(day).current();will(returnValue(Timeofday.EVENING));
            one(sun).isShining();will(returnValue(true));
            one(magic).callDaemon(Animals.BEAR);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 
    @Test
    public void testIternalCreatePig(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(2));
            one(day).current();will(returnValue(Timeofday.DAY));
            one(sun).isShining();will(returnValue(false));
            one(magic).callDaemon(Animals.PIG);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 
    @Test
    public void testIternalCreateBat(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(3));
            one(day).current();will(returnValue(Timeofday.NIGHT));
            one(sun).isShining();will(returnValue(true));
            one(magic).callDaemon(Animals.BAT);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 
    @Test
    public void testIternalCreateBallon(){
        final IWind wind = context.mock(IWind.class);
        final IDaylight day = context.mock(IDaylight.class);
        final ILuminary sun = context.mock(ILuminary.class);
        final IMagic magic  = context.mock(IMagic.class);
        final Clouds cloud = new Clouds(day,sun,wind,magic);
        context.checking(new Expectations(){{
            one(wind).getPower();will(returnValue(5));
            one(day).current();will(returnValue(Timeofday.EVENING));
            one(sun).isShining();will(returnValue(true));
            one(magic).callStork(Animals.BALLON);
        }});
        cloud.create();
        context.assertIsSatisfied();
    } 

}
