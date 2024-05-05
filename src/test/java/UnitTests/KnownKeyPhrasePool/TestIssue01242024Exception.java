package UnitTests.KnownKeyPhrasePool;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.google.gson.JsonSyntaxException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestIssue01242024Exception {

    @Test
        //need duplicate keys to throw exceptions
    void t() {
        Assertions.assertThrows(JsonSyntaxException.class, () -> {
            KnownPhrasesPool.setFromJson("""
                    {
                      "GCP": "cloud-tech",
                      "gcp": "cloud-tech",
                    }""");
        });
    }
}
