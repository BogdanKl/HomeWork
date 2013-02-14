package Exception;
public class UnCorrectTypeLexemException extends Exception {
    public String s;
    public UnCorrectTypeLexemException(String str) {
        s = str;
    }    
}