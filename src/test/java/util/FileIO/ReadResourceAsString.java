package util.FileIO;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class ReadResourceAsString {
    public static String readResourceAsString(String resource) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String text;
        try (InputStream inputStream = classLoader.getResourceAsStream(resource)) {
            assert inputStream != null;
            byte[] bytes = inputStream.readAllBytes();
            text = new String(bytes, StandardCharsets.UTF_8);
        }
        return text;
    }
}
