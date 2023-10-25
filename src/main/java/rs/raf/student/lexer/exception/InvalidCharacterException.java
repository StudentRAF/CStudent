package rs.raf.student.lexer.exception;

public class InvalidCharacterException extends RuntimeException {

    public InvalidCharacterException() {
        super("Source cannot be lexed, character cannot be assigned to category!");
    }

}
