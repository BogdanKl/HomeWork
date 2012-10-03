<<<<<<< HEAD
//Klepach Bogdan
// нахождение количество возможных путей до точки
=======
>>>>>>> c5f3dc16474adca62284b9b2222a3daf95834ccf
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot {
	public static void main (String args[]) throws IOException{
	  BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	  System.out.println("write a size of field");
	  int n =Integer.parseInt(input.readLine());
	  System.out.println(n);
      int matrix[][] = new int[n][n];
      int i = 0;
      int j = 0;
      int x,y;
      x = Integer.parseInt(input.readLine());
      y = Integer.parseInt(input.readLine());
      for(i = 0; i < n; i++ )
      {
    	  matrix[i][0] = 1;
    	  matrix[0][i] = 1;
      }
      for(i = 1; i < x; i++){
<<<<<<< HEAD
    	  for(j = 1; j < y; j++){
=======
    	  for(j = 1; i < y; j++){
>>>>>>> c5f3dc16474adca62284b9b2222a3daf95834ccf
    		  matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]; 
    	  }
      }
      System.out.println( matrix[x-1][y-1]);
    }
}
