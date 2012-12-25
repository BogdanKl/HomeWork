package calc;

public class Lexer {

    protected static LexemType curlexem;
    protected static String str;
    protected static int num;
    protected static int p;
    protected static String var;
    protected static Table htable;

    Lexer() {
        htable = new Table(150);
    }

    public static int getNumber() {
        return num;
    }

    public static String getVar() {
        return var;
    }

    public static LexemType getLexem() {
        return curlexem;
    }

    public static boolean Found(String s) {
        return htable.IsFound(s);
    }

    public int start(String s) {
        str = s;
        p = 0;
        return execute();
    }

    public static int getNumberTable(String s) {
        return htable.get(s).getNumber();
    }

    public int execute() {
        Parse parse = new Parse();
        getlexem();
        if (getnextlexem() == LexemType.EQUALITY) {
            getlexem();
            int result = parse.expr();
            if (curlexem != LexemType.NOTHING) {
                throw new IllegalArgumentException(" ошибка в выражение, возможно прпузен знак операции");
            }
            htable.put(var, result);
            str = "";
            return result;
        } else {
            p = 0;
            int result = parse.expr();
            str = "";
            return result;
        }

    }

    public static void getlexem() {
        try {
            while (str.charAt(p) == ' ') {
                p++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            curlexem = LexemType.NOTHING;
            return;
        }
        char t = str.charAt(p);
        switch (t) {
            case '+':
                curlexem = LexemType.PLUS;
                p++;
                break;
            case '-':
                curlexem = LexemType.MINUS;
                p++;
                break;
            case '*':
                curlexem = LexemType.MULTIPLY;
                p++;
                break;
            case '/':
                curlexem = LexemType.DIVISION;
                p++;
                break;
            case '(':
                curlexem = LexemType.OBRACE;
                p++;
                break;
            case ')':
                curlexem = LexemType.CBRACE;
                p++;
                break;
            case '=':
                curlexem = LexemType.EQUALITY;
                p++;
                break;
            default:
                if (Character.isDigit(t)) {
                    String number = "";
                    try {
                        while (Character.isDigit(str.charAt(p))) {
                            number += str.charAt(p);
                            p++;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                    }
                    num = Integer.parseInt(number);
                    curlexem = LexemType.NUMBER;
                }
                if (Character.isLetter(t)) {
                    String v = "";
                    try {
                        while (Character.isLetter(str.charAt(p))) {
                            v += str.charAt(p);
                            p++;
                        }
                    } catch (StringIndexOutOfBoundsException e) {
                    }
                    var = v;
                    curlexem = LexemType.VARIABLE;

                }

        }
    }

    public static LexemType getnextlexem() {
        int r_point = p;
        int r_num = num;
        String r_var = var;
        LexemType r_lexem = curlexem;
        getlexem();
        LexemType nextlexem = curlexem;
        p = r_point;
        curlexem = r_lexem;
        num = r_num;
        var = r_var;
        return nextlexem;
    }
}

