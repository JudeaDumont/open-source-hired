package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCpp {
    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/SingleMatchWithSymbols/TestPlus2/p.json")
        );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/SingleMatchWithSymbols/TestPlus2/jd.txt"),
                        "TestPlus2",
                        "TestData/SingleMatchWithSymbols",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().matchedTotalDensity() == 1);
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("c++ --- c++").isEmpty());
        assert (results.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
    }
}
