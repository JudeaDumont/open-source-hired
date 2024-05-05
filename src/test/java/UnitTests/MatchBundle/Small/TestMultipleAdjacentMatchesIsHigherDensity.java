package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestMultipleAdjacentMatchesIsHigherDensity {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/HowDensityWorks/MultipleAdjacentMatchesIsHigherDensity/p.json")
        );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> matchBundleV2s = mockFindBestMatch(
                readResourceAsString("TestData/HowDensityWorks/MultipleAdjacentMatchesIsHigherDensity/jd.txt"),
                new String[]{"MultipleAdjacentMatchesIsHigherDensity"},
                new String[]{"TestData/HowDensityWorks"},
                false
        );

        assert (matchBundleV2s.get(0).getLikenessLogicMatches().matchedTotalDensity() == 1);
        assert (!matchBundleV2s.get(0).getLikenessLogicMatches().getMatchedBecause("one direct match is one direct match --- one direct match is one direct match").isEmpty());
    }
}