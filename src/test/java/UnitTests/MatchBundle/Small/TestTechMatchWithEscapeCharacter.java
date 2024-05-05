package UnitTests.MatchBundle.Small;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadPinnedKeyPool12212023.loadPinnedKeyPool12212023;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestTechMatchWithEscapeCharacter {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        loadPinnedKeyPool12212023();

        ArrayList<MatchBundleV2> results =
                mockFindBestMatch(
                        readResourceAsString("TestData/SingleMatchWithSymbols/SingleMatchWithBadGrammer/jd.txt"),
                        "SingleMatchWithBadGrammer",
                        "TestData/SingleMatchWithSymbols",
                        false
                );

        assert (results.get(0).getLikenessLogicMatches().matchedTotalDensity() == 1);
        assert (results.get(0).getLikenessLogicMatches().missedTotalDensity() == 0);
    }

}
