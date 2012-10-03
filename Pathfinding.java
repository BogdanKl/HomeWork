
public class Pathfinding {
	public static void pathfinding(int x, int y ,int n){
		int i = 0;
	     int j = 0;
	     int matrix[][] = new int[n][n];
	     for(i = 0; i < n; i++ )
	      {
	    	  matrix[i][0] = 1;
	    	  matrix[0][i] = 1;
	      }
	      for(i = 1; i < x; i++)
	      {
	    	  for(j = 1; j < y; j++)
	    	  {
	    		  matrix[i][j] = matrix[i-1][j] + matrix[i][j-1]; 
	    	  }
	      }
	      System.out.println(matrix[0][0]);
	      for (i = 1; i < Math.max(x, y); i++)
	      {
	    	  for(j=0; j < i; j++)
	    	  {
	    		  System.out.print(matrix[i][j]+" ");	
	    	  }
	    	  System.out.print(matrix[i][i]+" ");
	    	  for(j=i-1; j >=0 ; j--)
	    	  {
	    		  System.out.print(matrix[j][i]+" ");	
	    	  }
	    	  System.out.println("");
	      }
	      
	      System.out.println("(x,y)= "+ matrix[x-1][y-1]);
		
	}

}
