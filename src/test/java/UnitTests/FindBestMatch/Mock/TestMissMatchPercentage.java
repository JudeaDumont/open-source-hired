package UnitTests.FindBestMatch.Mock;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMissMatchPercentage {

    //especially important test to pay attention to.
    // this demonstrates how to use categories so that

    // keywords will still show up as missed even if adjacent keyphrases are matched.
    //pool: {"java": "duties","java, mockito": "adjacent"}
    //resume: mockito
    //jd: java
    //likeness: java is MISSED, java --- mockito is MATCHED!

    //THIS IS BY DESIGN, because if java is missed but mockito shows up, a recruiter will throw the resume out!
    // so, use multiple categories where a keyword must be matched as denoted by a particular cluster!
    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {
        assert (setKeyPool(
                readResourceAsString("TestData/SingleMatchWithSymbols/TestAdjacentAndVagueWithPool/p.json")
        ).equals("Success"));

        ArrayList<MatchBundleV2> resultsMatchBundles = mockFindBestMatch(
                "Java",
                new String[]{"TestAdjacentAndVague"},
                new String[]{"TestData/SingleMatchWithSymbols/TestAdjacentAndVagueWithPool"},
                false
        );

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 1);

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getSuperfluousDensity().getTotalDensity() == 0);

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);

        assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getMatchPercentage() == 50);
    }
}
