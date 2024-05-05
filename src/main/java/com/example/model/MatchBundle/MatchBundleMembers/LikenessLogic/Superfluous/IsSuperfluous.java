package com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Superfluous;

import com.example.model.JobBundle.JobBundle;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.Set;

import static com.example.model.MatchBundle.MatchBundleMembers.VagueJDLogic.VagueJDLogic.isJdPurposefullyVague;

public class IsSuperfluous extends RPhraseRelevantToJDPhrase {

    protected static boolean isSuperfluous(JobBundle jobBundleV2,
                                           ResumeBundle resumeBundleV2,
                                           String phrase,
                                           Set<String> jDensity,
                                           Set<String> rDensity) {
        return jDensity.isEmpty() &&
                rDensity.contains(phrase)
                &&
                !isJdPurposefullyVague(jobBundleV2, resumeBundleV2, phrase)
                &&
                !isRPhraseRelevantToJPhrase(jobBundleV2, resumeBundleV2, phrase)
                ;
    }
}
