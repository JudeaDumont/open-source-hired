package util.E.UnitTestUtil.MockFindBestMatch;

import com.example.model.MatchBundle.MatchBundleV2;

import java.util.ArrayList;
import java.util.Comparator;

public class SortMatches {
    public static void sortMatches(ArrayList<MatchBundleV2> matchBundleV2s) {
        // aggregated from all of the matching types.
        matchBundleV2s.sort(
                new Comparator<MatchBundleV2>() {
                    @Override
                    public int compare(MatchBundleV2 o1, MatchBundleV2 o2) { //math in java be like dardardardardaar
                        return (int) (((
                                o1.getLikenessLogicMatches().getMatchPercentage() -
                                        o2.getLikenessLogicMatches().getMatchPercentage()) * 100)
                                + ((int) (o1.getLikenessLogicMatches().matchedTotalDensity()
                                - o2.getLikenessLogicMatches().matchedTotalDensity())));
                    }
                }
        );
    }
}
