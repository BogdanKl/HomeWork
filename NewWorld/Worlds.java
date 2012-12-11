package worlds;
public class Worlds {
    public static MauseVole[] maus;
    public static int mauslen;
    public static Siamese[] cat;
    public static int catlen;
    public static Rat[] rat;
    public static int ratlen;
    public static Dog[] dog;
    public static int doglen;
    public static void main(String[] args) {
          Rat jora = new Rat("jore", true,0);
          Rat goha = new Rat("goha", true, 1);
          Rat[] ratmas={jora,goha};
          Siamese sima = new Siamese("sima", true, 0);
          Siamese[] catmas = {sima};
          MauseVole[] mausmas = null;
          Dog[] dogmas = null;
          Siamese.set();
          Choose.choose(jora, Action.eat);
          Choose.choose(sima, Action.heard);
    }
}
