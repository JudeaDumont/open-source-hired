package UnitTests.FindBestMatch.Mock;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadPinnedKeyPool01092024.loadPinnedKeyPool01092024;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestSuperfluous1 {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        loadPinnedKeyPool01092024();

        ArrayList<MatchBundleV2> resultsMatchBundles = mockFindBestMatch(
                "Java",
                new String[]{"Superfluous"},
                new String[]{"TestData/SingleMatchWithSymbols"},
                false
        );

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getSuperfluousDensity().getTotalDensity() == 1);

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getMatchPercentage() == 50);
    }
}
