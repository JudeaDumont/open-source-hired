package UnitTests.CategorizationLogic;

import com.example.model.Categorizer.Categorizer;
import com.example.model.PhraseCluster.PhraseCluster;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCategorizationLogic {

    @Test
    @Order(1)
    void t() {
        Categorizer categorizer = Categorizer.Create();
        categorizer.categorize("a", new PhraseCluster("b", "c", new String[]{"a"}));
        assert(categorizer.getCategorized().containsKey("b"));
        assert(categorizer.getCategorized().get("b").get("c").getDensity("a")==1L);
    }
}
