package Lexems;
public class OPLexem extends Lexeme {
    private Operation op;
    public OPLexem(Operation o)
    {
        super(LexemType.OPERATION);
        op = o;        
    }
    
    public Operation getop()
    {
        return op;
    }
}