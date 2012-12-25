package calc;

public class Parse {

    public int expr() {
        int operand1 = term();
        LexemType operation = Lexer.getLexem();
        while (operation == LexemType.PLUS || operation == LexemType.MINUS) {
            int operand2 = term();
            switch (operation) {
                case PLUS:
                    operand1 += operand2;
                    break;
                case MINUS:
                    operand1 -= operand2;
                    break;
            }
            operation = Lexer.getLexem();
        }
        return operand1;
    }

    private int term() {
        int operand1 = factor();
        LexemType operation = Lexer.getLexem();
        while (operation == LexemType.MULTIPLY || operation == LexemType.DIVISION) {
            int operand2 = factor();
            switch (operation) {
                case MULTIPLY:
                    operand1 *= operand2;
                    break;
                case DIVISION:
                    operand1 /= operand2;
                    break;
            }
            operation = Lexer.getLexem();
        }
        return operand1;
    }

    private int factor() {
        Lexer.getlexem();
        switch (Lexer.getLexem()) {
            case NUMBER: {
                int result = Lexer.getNumber();
                Lexer.getlexem();
                return result;
            }
            case OBRACE: {
                int result = expr();
                if (Lexer.getLexem() != LexemType.CBRACE) {
                    throw new IllegalArgumentException("пропущен закрывающая скобка");
                }
                Lexer.getlexem();
                return result;
            }
            case VARIABLE: {
                if (!Lexer.Found(Lexer.getVar())) {
                    throw new IllegalArgumentException("Не найдена переменная с таким именем в таблице");
                }
                int result = Lexer.getNumberTable(Lexer.getVar());
                Lexer.getlexem();
                return result;
            }
            case NOTHING: {
                return 1;
            }
            default: {
                return 0;
            }
        }
    }
}
