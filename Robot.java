//Klepach Bogdan
// нахождение количество возможных путей до точки
//на выходе матрица искомая + ответ в заданной точке
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot {
	public static void main (String args[]) throws IOException{
	  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	  System.out.print("write a size of field= ");
	  int n =Integer.parseInt(input.readLine());
	  //System.out.println(n);
      int x,y;
      System.out.print("x= ");
      x = Integer.parseInt(input.readLine());
      System.out.print("y= ");
      y = Integer.parseInt(input.readLine());
      Pathfinding.pathfinding(x,y,n);
    }
}
