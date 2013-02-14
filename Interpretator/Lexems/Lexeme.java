package Lexems;

public class Lexeme {
    private LexemType type;
    
    public Lexeme(LexemType t)
    {
        type = t;
    }

    public LexemType getType() {
        return type;
    }    
}