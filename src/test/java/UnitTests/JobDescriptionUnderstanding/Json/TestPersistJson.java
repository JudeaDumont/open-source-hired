package UnitTests.JobDescriptionUnderstanding.Json;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.ResumeBundle.ResumeBundle;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestPersistJson {

    @Test
    @Order(1)
    void t() {
        KnownPhrasesPool.setFromJson("{\"java\":\"tech\"}");
        ResumeBundle resumeBundle = resumeFromPlainText("java");
        String persistJson = resumeBundle.getPersistJson();
        assert (!persistJson.isEmpty());
    }
}
