package cloudes;

public class IsShining implements iLuminary{
    private boolean result;
    IsShining(boolean result)
    {
        this.result = result;
    }

    @Override
    public boolean isShining() {
        return result;
    }
    
}
