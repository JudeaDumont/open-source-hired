package z.util.FileIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileFromBytes {
    public static void writeFileFromBytes(String path, byte[] plainTextBytes) throws IOException {
        FileOutputStream out = new FileOutputStream(path);
        out.write(plainTextBytes);
        out.close();
    }
}
