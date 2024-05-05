package UnitTests.FavoriteTechPreProcessor01222024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadProdPool.loadProdPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestTwoMainTechsSelectsMyFavorite {

    @Test
    @Order(1)
    void t() {
        loadProdPool();

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("java, C#",
                        new String[]{"terraform", "java"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getSuperfluousDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 0);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 0);

        assert (matchBundle.get(1).getLikenessLogicMatches().getSuperfluousDensity().getTotalDensity() == 0);
        assert (matchBundle.get(1).getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 0);
        assert (matchBundle.get(1).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(1).getLikenessLogicMatches().getMatchPercentage() == 100);
    }
}
