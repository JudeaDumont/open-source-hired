package UnitTests.KeyPhrasePullerMatch;

import com.example.model.KeyPhrasePuller.KeyPhrasePullLogic;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestKeyPhrasePullerMatch {

    @Test
    @Order(1)
    void t() {
        assert (!KeyPhrasePullLogic.isMatch("debugtests", "debug")); //match whole words only!

        assert (KeyPhrasePullLogic.isMatch("c", "c"));
        assert (KeyPhrasePullLogic.isMatch("cs", "c"));
        assert (KeyPhrasePullLogic.isMatch("cy", "c"));
        assert (KeyPhrasePullLogic.isMatch("cing", "c"));
        assert (KeyPhrasePullLogic.isMatch("cings", "c"));
        assert (KeyPhrasePullLogic.isMatch("cer", "c"));
        assert (KeyPhrasePullLogic.isMatch("cment", "c"));
        assert (KeyPhrasePullLogic.isMatch("ced", "c"));
        assert (KeyPhrasePullLogic.isMatch("ced", "c"));
        assert (KeyPhrasePullLogic.isMatch("cability", "c"));
        assert (KeyPhrasePullLogic.isMatch("cable", "c"));
        assert (KeyPhrasePullLogic.isMatch("cced", "c"));
        assert (KeyPhrasePullLogic.isMatch("cability", "c"));
        assert (KeyPhrasePullLogic.isMatch("cable", "c"));

        assert (KeyPhrasePullLogic.isMatch("c#", "c#"));


        assert (KeyPhrasePullLogic.isMatch("has space again", "has space again"));
        assert (KeyPhrasePullLogic.isMatch("builds", "build"));
        assert (KeyPhrasePullLogic.isMatch("building", "build"));
        assert (KeyPhrasePullLogic.isMatch("buildings", "build"));
        assert (KeyPhrasePullLogic.isMatch("improvement", "improve"));
        assert (KeyPhrasePullLogic.isMatch("improvement", "improve"));
    }
}
