package UnitTests.MockSimpleMatchLogic03172024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

public class TestEngineeringIllustrationOfPoolProblem {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"engineering\":\"test\"}");

        ArrayList<MatchBundleV2> matchBundle =
                mockLikenessLogic("engineering",
                        new String[]{"engineer"},
                        true
                );

        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchedDensity().getTotalDensity() == 0);
        assert (matchBundle.get(0).getLikenessLogicMatches().getMatchPercentage() == 0);
    }
}
