
package cloudes;
public class TWind implements IWind {
   private int power;
   TWind(int power){
       this.power = power;
   }
    @Override
    public int getPower() {
        return power;
    }
    
}
