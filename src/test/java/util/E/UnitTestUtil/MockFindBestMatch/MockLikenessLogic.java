package util.E.UnitTestUtil.MockFindBestMatch;

import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchBundleV2;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.ArrayList;

import static com.example.model.JobBundle.Members.PlainText.descriptionFromPlainText;
import static com.example.model.JobBundle.Members.PlainText.jobBundleFromVaguePlainText;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static util.E.UnitTestUtil.MockFindBestMatch.SortMatches.sortMatches;

public class MockLikenessLogic {
    public static ArrayList<MatchBundleV2> mockLikenessLogic(String jdPlainText, String[] resumePlainTexts, boolean hijackIfVague) {
        JobBundle jobBundle = null;
        ArrayList<MatchBundleV2> matches = new ArrayList<>();
        if (hijackIfVague) {
            jobBundle = jobBundleFromVaguePlainText(jdPlainText);
        } else {
            jobBundle = descriptionFromPlainText(jdPlainText);
        }

        for (String resumePlainText : resumePlainTexts) {
            matches.add(new MatchBundleV2(jobBundle, resumeFromPlainText(resumePlainText)));
        }
        sortMatches(matches);
        return matches;
    }

    public static MatchBundleV2 mockLikenessLogic(String jdPlainText, String resumePlainText, boolean hijackIfVague) {
        ResumeBundle resumeBundle = resumeFromPlainText(resumePlainText);
        JobBundle jobBundle = null;
        if (hijackIfVague) {
            jobBundle = jobBundleFromVaguePlainText(jdPlainText);
        } else {
            jobBundle = descriptionFromPlainText(jdPlainText);
        }
        return new MatchBundleV2(jobBundle, resumeBundle);
    }
}
