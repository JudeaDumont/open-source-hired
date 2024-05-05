package UnitTests.MockLikenessLogic01222024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

public class TestComma {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"a,b,c\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a,b-c",
                        new String[]{"a-b,c"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 9);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t2() throws IOException, InterruptedException {
        setKeyPool("{\"a,b,c\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a,-,-,1-,b--,,,-c",
                        new String[]{"a-----,,,b--,-,,-,c"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 9);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t3() throws IOException, InterruptedException {
        setKeyPool("{\"a\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a,c",
                        new String[]{"c,a"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t4() throws IOException, InterruptedException {
        setKeyPool("{\"a\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("c,a",
                        new String[]{"a,c"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t5() throws IOException, InterruptedException {
        setKeyPool("{\"a\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("c,a",
                        new String[]{"a,c"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t6() throws IOException, InterruptedException {
        setKeyPool("{\"a\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("c,a",
                        new String[]{"c,a"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }
}
