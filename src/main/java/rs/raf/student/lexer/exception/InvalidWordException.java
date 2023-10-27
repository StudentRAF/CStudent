package rs.raf.student.lexer.exception;

public class InvalidWordException extends RuntimeException {

    public InvalidWordException(String word) {
        super("Source cannot be lexed, word '" + word + "' cannot be assigned to the category!");
    }

}
