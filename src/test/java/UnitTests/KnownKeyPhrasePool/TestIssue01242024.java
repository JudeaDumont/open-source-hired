package UnitTests.KnownKeyPhrasePool;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.MatchBundle.MatchBundleV2;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestIssue01242024 {

    @Test
    void t() {
        KnownPhrasesPool.setFromJson("""
                {
                  "Java": "tech",
                  "Ruby": "tech",
                  "Javascript": "tech",
                  "Go": "cloud-tech",
                  "Python": "adjacent-tech",
                  "Rust": "adjacent-tech",
                  "C++": "tech",
                  "PostgreSQL": "db-tech",
                  "Ruby on Rails": "tech",
                  "GCP": "cloud-tech",
                  "Docker": "container-tech",
                  "Kubernetes": "container-tech",
                  "Nomad": "cloud-tech",
                  "terraform": "cloud-tech",
                  "gke": "cloud-tech"
                }""");
        MatchBundleV2 matchBundleV2 = mockLikenessLogic("like Java, Ruby, Javascript, Go, Python, Rust or C++",
                "like Java, Ruby, Javascript, Go, Python, Rust or C++",
                false);
        assert (matchBundleV2.getLikenessLogicMatches().getMissedDensity().getTotalDensity() == 0);
        assert (matchBundleV2.getLikenessLogicMatches().getSuperfluousDensity().getTotalDensity() == 1);
    }
}
