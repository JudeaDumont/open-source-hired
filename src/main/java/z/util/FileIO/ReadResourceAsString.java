package z.util.FileIO;

import java.io.IOException;
import java.io.InputStream;

public class ReadResourceAsString {

    public static String getString(String fileName) {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String text;
        try (
                InputStream input = classLoader.getResourceAsStream(fileName)
        ) {
            {
                text = ReadInputStreamAsString.getStringFromInputStream(input);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
