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
class TestCS {
    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/SingleMatchWithSymbols/TestHash/p.json")
        );
        assert (result.equals("Success"));

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/SingleMatchWithSymbols/TestHash/jd.txt"),
                        "TestHash",
                        "TestData/SingleMatchWithSymbols/",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().getMatchedDensity().size() == 1);
        String clusterText = "[\"c sharp\",\"csharp\",\"c#\"]";
        assert (results.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 3);
        assert (Objects.equals(results.get(0).getLikenessLogicMatches().getMatchedBecause("c# --- c#"), clusterText));
        assert (Objects.equals(results.get(0).getLikenessLogicMatches().getMatchedBecause("c sharp --- c#"), clusterText));
        assert (Objects.equals(results.get(0).getLikenessLogicMatches().getMatchedBecause("csharp --- c#"), clusterText));
    }
}
