package UnitTests.Compliment;

import com.example.model.MatchedBecause.MatchedBecause;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.Set;

import static util.FileIO.ReadResourceAsString.readResourceAsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestComplimentC {

    @Test
    @Order(1)
    void t() throws IOException, InterruptedException {

        MatchedBecause matchedBecause = MatchedBecause.fromJson(
                readResourceAsString("TestData/Compliment/c/a.json"));

        MatchedBecause matchedBecause1 = MatchedBecause.fromJson(
                readResourceAsString("TestData/Compliment/c/b.json"));
        Set<String> compliment = matchedBecause.Compliment(matchedBecause1.keySet());
        assert (compliment.size() == 4);
    }
}
