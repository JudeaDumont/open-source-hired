package util.ChracterUtil;
import java.nio.charset.StandardCharsets;

public class AsciiValidator {
    public static boolean isPureAscii(String v) {
        return StandardCharsets.US_ASCII.newEncoder().canEncode(v);
        // or "ISO-8859-1" for ISO Latin 1
        // or StandardCharsets.US_ASCII with JDK1.7+
    }
}
