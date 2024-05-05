package UnitTests.BasicOperationalTests;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.PoolOfAlikePhrases;
import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.PhraseCluster.PhraseCluster;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Hashtable;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestJerseyTestFrameworkKeyPoolProcessor {

    @Test
    @Order(6)
    void t() {
        KnownPhrasesPool.loadProdPool();
        PoolOfAlikePhrases pool = KnownPhrasesPool.getPool();
        Hashtable<String, PhraseCluster> phraseClusters = KnownPhrasesPool.getPhraseClusters();
        assert (pool != null);
        assert (!phraseClusters.isEmpty());
    }
}
