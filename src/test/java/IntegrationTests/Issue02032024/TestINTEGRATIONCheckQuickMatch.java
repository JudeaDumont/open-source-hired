package IntegrationTests.Issue02032024;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.*;
import util.JerseyTestWrapper;

import java.io.IOException;

import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.CallLoadProdPool.callLoadProdPool;
import static util.EndPointUtils.CallQuickMatch.getQuickMatch;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestINTEGRATIONCheckQuickMatch extends JerseyTestWrapper {
    @Test
    @Order(6)
    void CheckJobDescriptionUnderstandingTest1() throws IOException, InterruptedException {

        callLoadProdPool();

        MatchBundleV2 jobDescriptionUnderstandingFromJson =
                getQuickMatch("c++\u00a0java", "java c");

        assert (jobDescriptionUnderstandingFromJson.getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 0);
    }
}