package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDashSpace {
    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result =
                setKeyPool(
                        readResourceAsString("TestData/SingleMatchWithSymbols/TestDashSpace/p.json")
                );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/SingleMatchWithSymbols/TestDashSpace/jd.txt"),
                        "TestDashSpace",
                        "TestData/SingleMatchWithSymbols/",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().matchedTotalDensity() == 1);
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("abc d efg h i j kl mn --- abc d efg h i j kl mn").isEmpty());
    }
}
