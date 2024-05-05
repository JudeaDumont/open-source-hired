package com.example.model.MatchBundle.MatchBundleMembers.VagueJDLogic;

import com.example.model.JobBundle.JobBundle;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.Collections;
import java.util.HashSet;

import static com.example.model.KeyPhrasePuller.OmittableCategoryLogic.OmittableCategories;

public class VagueJDLogic {
    //for this particular phrase, the categories related to it matched those categories an employer would leave out
    // and the phrases in the job description did not relate to those categories an employer would leave out
    public static boolean isJdPurposefullyVague(JobBundle jobBundleV2, ResumeBundle resumeBundleV2, String phrase) {
        HashSet<String> jCats = jobBundleV2.getCategories();
        HashSet<String> rCats = resumeBundleV2.getCategoryByPhrase(phrase);
        boolean containsOmittableCategory = containsOmittableCategory(rCats);
        boolean categoryWasOmitted = Collections.disjoint(//any match between categories?
                jCats
                , rCats);

        return containsOmittableCategory
                &&
                categoryWasOmitted;
    }

    public static boolean containsOmittableCategory(HashSet<String> categoryByPhrase) {
        return !Collections.disjoint(categoryByPhrase, OmittableCategories);
    }
}
