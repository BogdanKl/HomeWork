//Klepach Bogdan
// ���������� ���������� ��������� ����� �� �����
//�� ������ ������� ������� + ����� � �������� �����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import pathfinding.Pathfinding;

public class Robot {
    public static void main (String args[]) throws IOException{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int x,y,n,i,j;
        System.out.print("x= ");
        x = Integer.parseInt(input.readLine());
        System.out.print("y= ");
        y = Integer.parseInt(input.readLine());
        n = Math.max(x,y);
        int[][] matrix = new int[n][n];
        matrix = Pathfinding.pathfinding(x,y,n);
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
