package rs.raf.student;

import rs.raf.student.lexer.Lexer;
import rs.raf.student.lexer.model.Word;

public class Main {

    public static void main(String[] args) {
        System.out.println("CStudent | Main");

        for (Word word : new Lexer("RelationalOperators.csl").words())
            System.out.println(word.toString());
    }

}
