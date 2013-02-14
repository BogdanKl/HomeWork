package Exception;
public class UnCorrectExprException extends Exception {
    private String s; 
    public UnCorrectExprException(String str) {
        s = str;
    }    
}