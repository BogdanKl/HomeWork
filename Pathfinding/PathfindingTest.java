package pathfinding;
import org.junit.*;
import static org.junit.Assert.*;

public class PathfindingTest {
    
    @Test
    public void testPathfinding() {
        System.out.println("pathfinding");
        int x = 2;
        int y = 2;
        int n = 2;
        int expResult =2;
        int[][] result = Pathfinding.pathfinding(x, y, n);
        assertEquals(expResult, result[1][1]);
      }
    @Test
    public void testPathfinding1() {
        System.out.println("pathfinding");
        int x = 3;
        int y = 2;
        int n = 3;
        int expResult =3;
        int[][] result = Pathfinding.pathfinding(x, y, n);
        assertEquals(expResult, result[2][1]);
      }
     @Test
     public void testPathfinding2() {
        System.out.println("pathfinding");
        int x = 2;
        int y = 3;
        int n = 3;
        int expResult =3;
        int[][] result = Pathfinding.pathfinding(x, y, n);
        assertEquals(expResult, result[1][2]);
     }

}
