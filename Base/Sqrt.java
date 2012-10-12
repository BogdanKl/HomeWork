

public class Sqrt {
  private static double epsilon;      
  public static double sqrt(double x)
  {
    double a = 1;
    epsilon = x/1e9 ; 
    while (Math.abs((x - a*a)) > epsilon)
    {
      a = 0.5*(a + x/a);
    }
    return a; 
  }
}
