package worlds;
public abstract class Animals {
    public boolean placeHome;
    public String name;
    public abstract void getStatus();
    public abstract void eat();
    public abstract void lookaround();
    public abstract void heard();
    public abstract void bite();
    public abstract void noise();
    public abstract boolean isHome();
    public abstract boolean isOut();
    public abstract int isHungry();
    public abstract void goHome();
    public abstract void goOut();
    public abstract String getName(); 
    
}
