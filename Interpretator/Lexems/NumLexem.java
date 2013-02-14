package Lexems;
public class NumLexem extends Lexeme {
    private int value;
    
    public NumLexem(int val)
    {
        super(LexemType.NUMBER);
        value = val;
    }
    
    public int getnum()
    {
        return value;
    }    
}