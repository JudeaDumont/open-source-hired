package UnitTests.RudimentaryWordLogic;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.model.JobBundle.Members.PlainText.descriptionFromPlainText;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;

public class TestCombinedLogicLikenessMatchIsNotAMiss {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"b, c\":\"directlyalike\"}");

        MatchBundleV2 mb = new MatchBundleV2(
                descriptionFromPlainText("b,"),
                resumeFromPlainText("|c")
        );

        assert (mb.getRudimentaryWordMatches().getMissedDensity().size() == 1);
        assert (mb.getRudimentaryWordMatches().getSuperfluousDensity().size() == 1);

        assert (mb.getCombinedMatchedBecause().size() == 1);
        assert (mb.getLikenessLogicMatches().getMatchPercentage() == 100.0);
        assert (mb.getCombinedMissed().getTotalDensity() == 0);
    }
}
