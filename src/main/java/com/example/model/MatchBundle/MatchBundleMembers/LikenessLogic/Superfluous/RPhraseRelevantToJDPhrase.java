package com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Superfluous;

import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchInformation.MatchInformation;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.Collections;
import java.util.Set;

public class RPhraseRelevantToJDPhrase extends MatchInformation {

    protected static boolean isRPhraseRelevantToJPhrase(JobBundle jobBundleV2,
                                                        ResumeBundle resumeBundleV2,
                                                        String phrase) {
        Set<String> resumeOccurrences =
                resumeBundleV2.getAllRelatedPhrases(phrase);
        Set<String> jobOccurrences =
                jobBundleV2.getAllRelatedPhrases(phrase);
        return !Collections.disjoint(
                resumeOccurrences,
                jobOccurrences);
    }

}
