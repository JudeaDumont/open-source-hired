package UnitTests.RudimentaryWordLogic;

import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.DirectlyAlikePhrasesLogic;
import com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.RudimentaryWordLogic;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Objects;

import static com.example.model.JobBundle.Members.PlainText.descriptionFromPlainText;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;

public class TestRudimentaryWordLogic {
    @Test
    void t() throws IOException, InterruptedException {
        setKeyPool("{\"a, b, c\":\"directlyalike\"}");
        DirectlyAlikePhrasesLogic directlyAlikePhrasesLogic = new DirectlyAlikePhrasesLogic();

        directlyAlikePhrasesLogic.processDirectlyAlikePhrases(
                descriptionFromPlainText("a b,c"),
                resumeFromPlainText("a.b:c")
        );

        assert (directlyAlikePhrasesLogic.getMatchedBecause().size() == 9);
        assert (Objects.equals(directlyAlikePhrasesLogic.getMatchedBecause().toJson(),
                "{\"a --- c\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"a --- b\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"a --- a\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"c --- c\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"c --- b\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"c --- a\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"b --- c\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"b --- b\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\",\"b --- a\":\"[\\\"b\\\",\\\"a\\\",\\\"c\\\"]\"}"));

        RudimentaryWordLogic rudimentaryWordLogic = new RudimentaryWordLogic();
        rudimentaryWordLogic.processRudimentaryWordLogic(
                descriptionFromPlainText("a b,c"),
                resumeFromPlainText("a.b:c")
        );

        assert (rudimentaryWordLogic.getMatchedBecause().size() == 2);
        assert (rudimentaryWordLogic.getMatchPercentage() == 100);
        assert (Objects.equals(rudimentaryWordLogic.getMatchedBecause().toJson(),
                "{\"c --- c\":\"rudimentary\",\"b --- b\":\"rudimentary\"}"));
    }
}
