package worlds;
public abstract class Maus extends Animals {
    public int reserve;
    public int visibility(int opponent)
    {
        return ((opponent - reserve)/2*10); 
    }
}
