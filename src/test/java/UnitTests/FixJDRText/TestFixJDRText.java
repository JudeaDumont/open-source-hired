package UnitTests.FixJDRText;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;

import static com.example.model.FixText.FixJDRText.fixJDRText;
import static util.ChracterUtil.AsciiValidator.isPureAscii;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestFixJDRText {
    @Test
    @Order(1)
    void t() throws IOException {
        String AfterTrash = fixJDRText(readResourceAsString("TestData/HandleTrashChracters/trashJD.txt"));

        assert(isPureAscii(AfterTrash));
    }
}
