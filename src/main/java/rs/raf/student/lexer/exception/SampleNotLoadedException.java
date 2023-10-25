package rs.raf.student.lexer.exception;

import java.text.MessageFormat;

public class SampleNotLoadedException extends RuntimeException {

    public SampleNotLoadedException(String fileName) {
        super(MessageFormat.format("Sample {0} could not be loaded!", fileName));
    }
}
