
package projectworld;

public class ProjectWorld {

    public static void main(String[] args) throws Exception {
        Action act = Action.LOOKAROUND;
        Animals an = Animals.CAT;
        Choose ch = new Choose();
        ch.choose(an,act);       
    }
}
