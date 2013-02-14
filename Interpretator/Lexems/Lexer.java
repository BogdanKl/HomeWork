package Lexems;

import Exception.UnIndetifyLexemException;
import Lexems.Lexeme;
import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private List<Lexeme> Lexems;
    private int point;
    private String expr;
    private boolean EndOfLine;
    private int curlexem;

    public Lexer(String s) throws Exception {
        Lexems = new ArrayList<>();
        point = 0;
        expr = s;
        EndOfLine = false;
        recognition();
        curlexem = 0;
    }

    public Lexeme nextLexeme() {
        Lexeme l = Lexems.get(curlexem);
        if (curlexem < expr.length() - 1) {
            curlexem++;
        }
        return l;
    }

    private void recognition() throws Exception {
        while (!EndOfLine) {
            Lexeme l = readlexem();
            Lexems.add(l);
        }
        if (Lexems.get(Lexems.size() - 1).getType() != LexemType.END) {
            Lexems.add(new EndLexem());
        }
    }

    private Lexeme readlexem() throws Exception {
        if (point > expr.length() - 1) {
            EndOfLine = true;
        }
        while (!EndOfLine && expr.charAt(point) == ' ') {
            point++;
            if (point > expr.length() - 1) {
                EndOfLine = true;
            }
        }
        if (!EndOfLine) {
            switch (expr.charAt(point)) {
                case '+':
                    point++;
                    return new OPLexem(Operation.PLUS);
                case '*':
                    point++;
                    return new OPLexem(Operation.MULT);
                case '/':
                    point++;
                    return new OPLexem(Operation.DIV);
                case '-':
                    point++;
                    if (point < expr.length() - 1 && expr.charAt(point) == '>') {
                        point++;
                        return new ArrowsLexem();
                    } else {
                        return new OPLexem(Operation.MINUS);
                    }
                case '=':
                    point++;
                    return new EQLexem();
                case '(':
                    point++;
                    return new OBraceLexem();
                case ')':
                    point++;
                    return new CBraceLexem();
                default:
                    if (Character.isDigit(expr.charAt(point))) {
                        int begin = point;
                        String num = "";
                        while (!EndOfLine && Character.isDigit(expr.charAt(point))) {
                            point++;
                            if (point > expr.length() - 1) {
                                EndOfLine = true;
                            }
                            num += expr.charAt(point - 1);
                        }
                        try {
                            int numb = Integer.parseInt(num);
                            return new NumLexem(numb);
                        } catch (NumberFormatException e) {
                        }

                    }
                    if (Character.isLetter(expr.charAt(point))) {
                        int begin = point;
                        String var = "";
                        while (!EndOfLine && Character.isLetter(expr.charAt(point))) {
                            point++;
                            if (point > expr.length() - 1) {
                                EndOfLine = true;
                            }
                            var += expr.charAt(point - 1);
                        }
                        switch (var.toLowerCase()) {
                            case "let":
                                return new LetLexem();
                            case "fun":
                                return new FunLexem();
                            case "in":
                                return new InLexem();
                            default:
                                return new IDLexem(var);
                        }
                    } else {
                        throw new UnIndetifyLexemException();
                    }
            }
        }
        return new EndLexem();
    }
}