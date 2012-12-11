package worlds;
public abstract class Pets extends Animals {
    public int reserve;
    public int visibility(int opponent)
    {
        return ((opponent - reserve)/3*10); 
    }
   
}
