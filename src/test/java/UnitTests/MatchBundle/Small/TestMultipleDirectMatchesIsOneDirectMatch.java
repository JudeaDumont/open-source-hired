package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestMultipleDirectMatchesIsOneDirectMatch {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/HowDensityWorks/MultipleDirectMatchesIsOneDirectMatch/p.json")
        );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/HowDensityWorks/MultipleDirectMatchesIsOneDirectMatch/jd.txt"),
                        "MultipleDirectMatchesIsOneDirectMatch",
                        "TestData/HowDensityWorks",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 4);
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("another match --- another match").isEmpty());
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("another match --- one direct match is one direct match").isEmpty());
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("one direct match is one direct match --- one direct match is one direct match").isEmpty());
        assert (!results.get(0).getLikenessLogicMatches().getMatchedBecause("one direct match is one direct match --- another match").isEmpty());
    }
}

