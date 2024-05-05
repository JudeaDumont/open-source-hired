package com.example.model.MatchBundle;

import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchBundleMembers.MatchBundleJson;
import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.DirectlyAlikePhrasesLogic;
import com.example.model.ResumeBundle.ResumeBundle;

public class MatchBundleV2 extends MatchBundleJson {
    public MatchBundleV2(
            DirectlyAlikePhrasesLogic likenessMatchInformation) {
        setLikenessLogicMatches(likenessMatchInformation);
    }

    public MatchBundleV2() {
        initializeNew();
    }

    //Create results on the fly
    public MatchBundleV2(JobBundle jobBundleV2, ResumeBundle resumeBundleV2) {
        initializeNew();
        setJobBundleV2(jobBundleV2);
        setResumeBundleV2(resumeBundleV2);

        getLikenessLogicMatches().processDirectlyAlikePhrases(jobBundleV2, resumeBundleV2);
        getRudimentaryWordMatches().processRudimentaryWordLogic(jobBundleV2, resumeBundleV2);
        combineMatchBecause();
        combineMissed();
        combineSuperfluous();
    }

    private void combineMatchBecause() {
        getCombinedMatchedBecause().AddAll(getLikenessLogicMatches().getMatchedBecause());
        getCombinedMatchedBecause().AddAll(getRudimentaryWordMatches().getMatchedBecause());
    }

    private void combineMissed() {
        getCombinedMissed().AddWithNoDensity(getRudimentaryWordMatches().getMissedDensity());
        //then remove the ones that were matches for LikenessLogic
        getCombinedMissed().RemoveAll(getLikenessLogicMatches().getFlatMatched());
        getCombinedMissed().AddWithNoDensity(getLikenessLogicMatches().getMissedDensity());
    }

    private void combineSuperfluous() {
        getCombinedSuperfluous().AddWithNoDensity(getRudimentaryWordMatches().getSuperfluousDensity());
        //then remove the ones that were matches for LikenessLogic
        getCombinedSuperfluous().RemoveAll(getLikenessLogicMatches().getFlatMatched());
        getCombinedSuperfluous().AddWithNoDensity(getLikenessLogicMatches().getSuperfluousDensity());
    }

    private void initializeNew() {
        setLikenessLogicMatches(new DirectlyAlikePhrasesLogic());
    }
}
