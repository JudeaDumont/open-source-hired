package UnitTests.RudimentaryWordLogic;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static com.example.model.JobBundle.Members.PlainText.descriptionFromPlainText;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;

public class TestCombinedLogicLikenessMatchIsNotASuperfluous {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"b, c\":\"directlyalike\", \"d, e\":\"directlyalike\"}");

        MatchBundleV2 mb = new MatchBundleV2(
                descriptionFromPlainText("b,"),
                resumeFromPlainText("|c/D")
        );

        assert (mb.getRudimentaryWordMatches().getMissedDensity().size() == 1);
        assert (mb.getRudimentaryWordMatches().getSuperfluousDensity().size() == 2);

        assert (mb.getCombinedMatchedBecause().size() == 1);
        assert (mb.getLikenessLogicMatches().getMatchPercentage() == 50.0);
        assert (mb.getCombinedMissed().getTotalDensity() == 0);
        assert (mb.getCombinedSuperfluous().size() == 1);
    }
}
