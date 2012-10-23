

public class Sqrt {
  private static double epsilon = 1e-9;      
  public static double sqrt(double x)
  {
    double a = 1;
    epsilon = x*epsilon ; 
    while (Math.abs((x-a*a)/x) > epsilon)
    {
      a = 0.5*(a + x/a);
    }
    return a; 
  }
}
