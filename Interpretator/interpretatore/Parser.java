package interpretatore;

import Exception.UnCorrectTypeLexemException;
import Lexems.Operation;
import Lexems.IDLexem;
import Lexems.LexemType;
import Lexems.Lexer;
import Lexems.Lexeme;
import Lexems.NumLexem;
import Lexems.OPLexem;
import Nodes.*;

class Parser {

    private Lexer lexer;
    private Lexeme currlexem;

    public Parser() {
    }

    private void nextlexem() {
        this.currlexem = lexer.nextLexeme();
    }

    public Expression parseExpr(String s) throws Exception {
        lexer = new Lexer(s);
        nextlexem();
        Expression result = parse();
        if (currlexem.getType() != LexemType.END) {
            throw new UnCorrectTypeLexemException("");
        }
        return result;
    }

    private Expression parse() throws Exception {
        switch (currlexem.getType()) {
            case LET:
                return parseLet();
            case FUN:
                return parseFun();
            default:
                return expr();
        }
    }

    private Expression parseFun() throws Exception {
        nextlexem();
        if (currlexem.getType() != LexemType.ID) {
            throw new UnCorrectTypeLexemException("ожидался индетефикатор");
        }
        String id = ((IDLexem) currlexem).getname();
        nextlexem();
        if (currlexem.getType() != LexemType.ARROW) {
            throw new UnCorrectTypeLexemException("ожидалась");
        }
        nextlexem();
        return new FunDeff(id, parse());
    }

    private Expression parseLet() throws Exception {
        nextlexem();
        if (currlexem.getType() != LexemType.ID) {
            //error
        }
        String id = ((IDLexem) currlexem).getname();
        nextlexem();
        if (currlexem.getType() != LexemType.EQUALLY) {
            throw new UnCorrectTypeLexemException("ожидалось =");
        }
        nextlexem();
        Expression exprL = parse();
        if (currlexem.getType() != LexemType.IN) {
            throw new UnCorrectTypeLexemException("ожидался in");
        }
        nextlexem();
        Expression exprR = parse();
        return new Let(id, exprL, exprR);
    }

    private Expression expr() throws Exception {
        Expression left = term();
        if (currlexem.getType() == LexemType.OPERATION) {
            Operation op = ((OPLexem) currlexem).getop();
            if (op == Operation.PLUS || op == Operation.MINUS) {
                nextlexem();
                return new OP(op, left, expr());
            }
        }
        return left;
    }

    private Expression term() throws Exception {
        Expression left = factor();
        if (currlexem.getType() == LexemType.OPERATION) {
            Operation op = ((OPLexem) currlexem).getop();
            if (op == Operation.MULT || op == Operation.DIV) {
                nextlexem();
                return new OP(op, left, term());
            }
        }
        return left;
    }

    private Expression factor() throws Exception {
        return funcall();
    }

    private Expression funcall() throws Exception {
        Expression n = primary();
        while (currlexem.getType() == LexemType.ID || currlexem.getType() == LexemType.NUMBER || currlexem.getType() == LexemType.OBRACE) {
            n = new FunCall(n, primary());
        }
        return n;
    }

    private Expression primary() throws Exception {
        switch (currlexem.getType()) {
            case NUMBER:
                return Number();
            case ID:
                return Indet();
            case OBRACE:
                return Brace();
        }
        throw new Exception();
    }

    private Expression Number() {
        int val = ((NumLexem) currlexem).getnum();
        nextlexem();
        return new Numb(val);
    }

    private Expression Indet() {
        String id = ((IDLexem) currlexem).getname();
        nextlexem();
        return new Indetificator(id);
    }

    private Expression Brace() throws Exception {
        nextlexem();
        Expression n = parse();
        if (currlexem.getType() != LexemType.CBRACE) {
            throw new UnCorrectTypeLexemException("ожидалась закрытая скобка");
        }
        nextlexem();
        return n;
    }
}
