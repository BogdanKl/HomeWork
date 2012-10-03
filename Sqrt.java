

public class Sqrt {
  private static double epsilon =0.000000000001;      
  public static double sqrt(double x)
  {
    double a = 1;
    while (Math.abs((x - a*a)) > epsilon)
    {
      a = 0.5*(a + x/a);
    }
    return a; 
  }
}
