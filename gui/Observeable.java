package gui2;
public interface Observeable {
    public void registerObserver(Observe o);
    public void removeObserver(Observe o);
    public void notifyObservers();
}
