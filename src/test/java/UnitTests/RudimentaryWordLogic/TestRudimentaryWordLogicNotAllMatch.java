package UnitTests.RudimentaryWordLogic;

import com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.RudimentaryWordLogic;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

import static com.example.model.JobBundle.Members.PlainText.descriptionFromPlainText;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;

public class TestRudimentaryWordLogicNotAllMatch {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"a, b, c\":\"directlyalike\"}");

        RudimentaryWordLogic rudimentaryWordLogic = new RudimentaryWordLogic();
        rudimentaryWordLogic.processRudimentaryWordLogic(
                descriptionFromPlainText("a b,"),
                resumeFromPlainText("a.b:c")
        );

        assert (rudimentaryWordLogic.getMatchedBecause().size() == 1);
        assert (rudimentaryWordLogic.getMatchPercentage() == 50.0);
        assert (Objects.equals(rudimentaryWordLogic.getMatchedBecause().toJson(),
                "{\"b --- b\":\"rudimentary\"}"));

        RudimentaryWordLogic rudimentaryWordLogic2 = new RudimentaryWordLogic();
        rudimentaryWordLogic2.processRudimentaryWordLogic(
                descriptionFromPlainText("b,c:d:e"),
                resumeFromPlainText("b:c,e")
        );

        assert (rudimentaryWordLogic2.getMatchedBecause().size() == 3);
        assert (rudimentaryWordLogic2.getMatchPercentage() == 75.0);
        assert (Objects.equals(rudimentaryWordLogic2.getMatchedBecause().toJson(),
                "{\"c --- c\":\"rudimentary\",\"e --- e\":\"rudimentary\",\"b --- b\":\"rudimentary\"}"));
    }
}
