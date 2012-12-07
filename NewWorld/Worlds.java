package worlds;
public class Worlds {
    public static void main(String[] args) {
          Choose.choose(TAnimals.Siamese, Action.eat);
          Choose.choose(TAnimals.Siamese, Action.getStatus);
          Choose.choose(TAnimals.Dog, Action.getStatus);
          Choose.choose(TAnimals.MausVole, Action.getStatus);
          Choose.choose(TAnimals.Rat, Action.getStatus);
    }
}
