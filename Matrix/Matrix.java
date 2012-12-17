package matrix;

public class Matrix {

    private int length;
    private int height;
    private int[][] matr;
    
    Matrix()
    {

    }
    Matrix(int leng, int heig, int[][] matrix) {
        this.length = leng;
        this.height = heig;
        this.matr = matrix;
    }
    
    public void init()
    {
        matr = new int[this.length][this.height];
        for(int i = 0; i < this.length; i++ )
        {
            for(int j = 0; j < this.height; j++)
            {
                this.matr[i][j] = 0;
            }
        }
    }
    
    public int getLength()
    {
        return this.length;
    }
    
    public void setLength(int i)
    {
        length =i;
    }
    
    public int getElem(int i , int j)
    {
        return this.matr[i][j];
    }
    
    public int getHeight()
    {
        return this.height;
    }
    
    public void setHeight(int i)
    {
        this.height  = i;
    }
    
    public void setElem(int i, int j, int value)
    {
        this.matr[i][j] = value;
    }
    
    public int[] getLine(int j)
    {
        int[] result =new int[length];
        result = this.matr[j];
        return result;
    }
        public void transpose() {
        int[][] result =new int[this.length][this.height];
        int i, j;
        for (i = 0; i < this.length; i++) {
            for (j = 0; j < this.height; j++) {
                result[i][j] = matr[j][i]; 
            }
        }
        matr = result;
    }

    
}