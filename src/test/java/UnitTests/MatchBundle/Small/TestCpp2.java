package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestCpp2 {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/SingleMatchWithSymbols/TestPlus/p.json")
        );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/SingleMatchWithSymbols/TestPlus/jd.txt"),
                        "TestPlus",
                        "TestData/SingleMatchWithSymbols",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().matchedTotalDensity() == 1);
        String clusterText = "[\"cpp\",\"c++\"]";
        assert (results.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (Objects.equals(results.get(0).getLikenessLogicMatches().getMatchedBecause("cpp --- c++"), clusterText));
    }
}
