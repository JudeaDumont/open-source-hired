package UnitTests.FindBestMatch.Mock;

import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.io.IOException;
import java.util.ArrayList;

import static util.E.UnitTestUtil.KeyPoolConfig.LoadProdPool.loadProdPool;
import static util.E.UnitTestUtil.MockFindBestMatch.MockFindBestMatch.mockFindBestMatch;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestMatchJavaOnly {

    @Test
    @Order(1)
    void t() throws IOException {
            loadProdPool();

            ArrayList<MatchBundleV2> resultsMatchBundles = mockFindBestMatch(
                    "Java",
                    new String[]{"JavaBundle","CSharpBundle"},
                    new String[]{"TestData/ComparingResumes", "TestData/ComparingResumes"},
                    false
            );

            assert (resultsMatchBundles.get(0).getLikenessLogicMatches().getMatchPercentage() == 0);
            assert (resultsMatchBundles.get(1).getLikenessLogicMatches().getMatchPercentage() == 100);
    }
}
