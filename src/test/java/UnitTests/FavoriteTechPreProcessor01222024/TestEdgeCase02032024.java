package UnitTests.FavoriteTechPreProcessor01222024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadProdPool.loadProdPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestEdgeCase02032024 {

    @Test
    @Order(1)
    void t() {
        loadProdPool();

        MatchBundleV2 matchBundle =
                mockLikenessLogic("c++\u00a0java",
                        "java c",
                        true
                );

        assert (matchBundle.getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 0);
    }
}
