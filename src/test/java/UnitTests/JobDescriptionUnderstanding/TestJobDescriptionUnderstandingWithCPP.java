package UnitTests.JobDescriptionUnderstanding;

import com.example.model.JobDescriptionUnderstanding.JobDescriptionUnderstanding;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadPinnedKeyPool12212023.loadPinnedKeyPool12212023;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestJobDescriptionUnderstandingWithCPP {

    public TestJobDescriptionUnderstandingWithCPP() {
    }

    @BeforeEach
    void Setup() {
    }

    @Test
    @Order(6)
        // This needs to check keywords pulled out of the job description against the plaintext of the job description
        // this will be an endpoint used by react as well,
        // a user will want to know how well the software pulls keywords out of the JD
        // and which keywords are missing.
    void CheckJobDescriptionUnderstandingTest1() throws IOException, InterruptedException {

        loadPinnedKeyPool12212023();

        JobDescriptionUnderstanding jobDescriptionUnderstanding =
                new JobDescriptionUnderstanding(
                        "c++"
                );


        assert (jobDescriptionUnderstanding.getMatchs() == 1);
        assert (jobDescriptionUnderstanding.getRemaining().length == 0);
        assert (jobDescriptionUnderstanding.getMatchPercentage() == 100);
    }
}