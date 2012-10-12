package pathfinding;


public class Pathfinding {
	public static int[][] pathfinding(int x, int y ,int n){
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
            return matrix;
	    
         }

}
