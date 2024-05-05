package util.E.UnitTestUtil.MockFindBestMatch;

import com.example.model.MatchBundle.MatchBundleV2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static util.E.UnitTestUtil.MockFindBestMatch.MockLikenessLogic.mockLikenessLogic;
import static util.E.UnitTestUtil.MockFindBestMatch.SortMatches.sortMatches;
import static util.FileIO.ConvertInputStreamToString.convertInputStreamToString;

public class MockFindBestMatch {

    public static ArrayList<MatchBundleV2> mockFindBestMatch(
            String jdPlainText,
            String[] bundleNames,
            String[] pathToBundleDirs,
            boolean hijackIfVague
    ) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<MatchBundleV2> matchBundleV2s = new ArrayList<>();

        for (int i = 0; i < bundleNames.length; i++) {
            String pathToBundleFiles = pathToBundleDirs[i] + "/" + bundleNames[i];
            try (InputStream plainText = classLoader.getResourceAsStream(pathToBundleFiles + "/txt.txt")) {
                try (InputStream odt = classLoader.getResourceAsStream(pathToBundleFiles + "/odt.odt")) {
                    try (InputStream pdf = classLoader.getResourceAsStream(pathToBundleFiles + "/pdf.pdf")) {
                        assert plainText != null;
                        String resumePlainText = convertInputStreamToString(plainText);
                        MatchBundleV2 matchBundleV2 = mockLikenessLogic(jdPlainText, resumePlainText, hijackIfVague);
                        matchBundleV2s.add(matchBundleV2);
                    }
                }
            }
        }
        sortMatches(matchBundleV2s);
        return matchBundleV2s;
    }

    public static ArrayList<MatchBundleV2> mockFindBestMatch(
            String jdPlainText,
            String bundleNames,
            String pathToBundleDirs,
            boolean hijackIfVague
    ) throws IOException {
        return mockFindBestMatch(jdPlainText, new String[]{bundleNames}, new String[]{pathToBundleDirs}, hijackIfVague);
    }
}
