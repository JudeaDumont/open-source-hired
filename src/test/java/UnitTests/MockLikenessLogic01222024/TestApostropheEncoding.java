package UnitTests.MockLikenessLogic01222024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

public class TestApostropheEncoding {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"a's,a\\u0027s,a\\u0026s\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a's",
                        new String[]{"a's,a\\u0027s,a\\u0026s"},
                        false
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t2() throws IOException, InterruptedException {
        setKeyPool("{\"a\\u0027s\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("as",
                        new String[]{"a's"},
                        false
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t3() throws IOException, InterruptedException {
        setKeyPool("{\"as\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a\\u0027s",
                        new String[]{"a's"},
                        false
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t4() throws IOException, InterruptedException {
        setKeyPool("{\"as\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("as",
                        new String[]{"a\\u0027s"},
                        false
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }

    @Test
    void t5() throws IOException, InterruptedException {
        setKeyPool("{\"a's\":\"b\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("a's",
                        new String[]{"a\\u0027s"},
                        false
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 1);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 100);
    }
}
