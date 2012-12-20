package cloudes;
public class Day implements IDaylight{
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
