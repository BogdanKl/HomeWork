package Lexems;
public class IDLexem extends Lexeme{
    private String name;
    public IDLexem(String n)
    {
        super(LexemType.ID);
        name = n;
    }
    public String getname()
    {
        return name;
    }    
}