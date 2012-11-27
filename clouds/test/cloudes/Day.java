package cloudes;
public class Day implements iDaylight{
    private Timeofday day;
    Day(Timeofday day)
    {
        this.day = day;
    }
    @Override
    public Timeofday current() {
        return day;
    }
}
