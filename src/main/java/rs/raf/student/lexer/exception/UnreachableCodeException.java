package rs.raf.student.lexer.exception;

public class UnreachableCodeException extends RuntimeException {

    public UnreachableCodeException() {
        super("This exception should never be thrown!");
    }

}
