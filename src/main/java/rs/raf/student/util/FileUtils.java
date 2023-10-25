package rs.raf.student.util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    private static final URL SOURCE_ROOT = FileUtils.class.getClassLoader().getResource("samples/");

    public static String load(String fileName) {
        try {
            if (SOURCE_ROOT == null)
                throw new NullPointerException("Samples root folder is cannot be found!");

            return new String(Files.readAllBytes(Paths.get(SOURCE_ROOT.toURI().resolve(fileName))));
        }
        catch (IOException | URISyntaxException | NullPointerException exception) {
            exception.printStackTrace(System.out);
        }

        return null;
    }

}
