package com.example.model.MatchBundle.MatchBundleMembers;

import com.example.model.DensityTable.DensityTable;
import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.DirectlyAlikePhrasesLogic;
import com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.RudimentaryWordLogic;
import com.example.model.MatchedBecause.MatchedBecause;
import com.example.model.ResumeBundle.ResumeBundle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchBundleMembers {
    private JobBundle jobBundleV2 = null;
    private ResumeBundle resumeBundleV2 = null;
    private DirectlyAlikePhrasesLogic likenessLogicMatches = new DirectlyAlikePhrasesLogic();
    private RudimentaryWordLogic rudimentaryWordMatches = new RudimentaryWordLogic();
    private MatchedBecause combinedMatchedBecause = new MatchedBecause();
    private DensityTable combinedMissed = new DensityTable();
    private DensityTable combinedSuperfluous = new DensityTable();

    protected MatchBundleMembers() {
    }
}
