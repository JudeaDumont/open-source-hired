package UnitTests.KnownKeyPhrasePool;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.PhraseCluster.PhraseCluster;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Hashtable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestClustering {

    @Test
    void t() {
        KnownPhrasesPool.setFromJson("{\"a\":\"b\"}");
        Hashtable<String, PhraseCluster> phraseClusters = KnownPhrasesPool.getPhraseClusters();
        assert (phraseClusters.get("a-b").containsKey("a"));
    }

    @Test
    void t2() {
        KnownPhrasesPool.setFromJson("{\"a\":\"b\",\"a,tests\":\"c\"}");
        Hashtable<String, PhraseCluster> phraseClusters = KnownPhrasesPool.getPhraseClusters();
        assert (phraseClusters.get("a-b").containsKey("a"));
        assert (phraseClusters.get("a-c").containsKey("a"));
    }
}
