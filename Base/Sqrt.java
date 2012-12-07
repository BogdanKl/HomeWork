

public class Sqrt {
  private static final double epsilon = 1e-9;      
  public static double sqrt(double x)
  {
    if (x < 0)
    {
        throw new IllegalArgumentException("х не может быть отрицательным");
    }
    if (x == 0.0)
    {
        return 0;
    }
    double a = 1;
    while (Math.abs((x-a*a)/x) > epsilon)
    {
      a = 0.5*(a + x/a);
    }
    return a; 
  }
}
