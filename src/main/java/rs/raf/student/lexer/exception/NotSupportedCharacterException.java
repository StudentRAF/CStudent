package rs.raf.student.lexer.exception;

import java.text.MessageFormat;

public class NotSupportedCharacterException extends RuntimeException {

    public NotSupportedCharacterException(char character) {
        super(MessageFormat.format("Character ''{0}'' is not supported!", character));
    }

}
