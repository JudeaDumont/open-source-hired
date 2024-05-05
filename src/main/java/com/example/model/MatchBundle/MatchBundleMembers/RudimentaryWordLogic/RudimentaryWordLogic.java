package com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic;

import com.example.model.JobBundle.JobBundle;
import com.example.model.JobDescriptionUnderstanding.FluffWords;
import com.example.model.MatchBundle.MatchInformation.MatchInformation;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.HashSet;
import java.util.Set;

import static com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.GetWordsLogic.GetWords.getWords;
import static z.util.SetOperations.intersection;

public class RudimentaryWordLogic extends MatchInformation {
    public RudimentaryWordLogic() {
    }

    public void processRudimentaryWordLogic(JobBundle jobBundleV2, ResumeBundle resumeBundleV2) {
        Set<String> jobWords = getWords(jobBundleV2.plainText);
        Set<String> resumeWords = getWords(resumeBundleV2.plainText);

        //remove fluff words from all three
        FluffWords.dropWords.forEach(jobWords::remove);
        FluffWords.dropWords.forEach(resumeWords::remove);
        Set<String> intersection = intersection(jobWords, resumeWords);

        //then calculate matchpercentage like jobwordssize+resumewordssize-intersectionsize*2

        getMatchedBecause().AddAll("rudimentary", intersection);

        Set<String> jobWordsCompliment = new HashSet<>(jobWords);
        jobWordsCompliment.removeAll(intersection);
        getMissedDensity().AddWithNoDensity(jobWordsCompliment);

        Set<String> resumeWordsCompliment = new HashSet<>(resumeWords);
        resumeWordsCompliment.removeAll(intersection);
        getSuperfluousDensity().AddWithNoDensity(resumeWordsCompliment);

        int js = jobWords.size();
        int rs = resumeWords.size();
        int is = intersection.size();

        setMatchPercentage(
                (is == js && rs == is) ? 100 :
                        (double) Math.round((double) is / ((js - is) + (rs - is) + (is)) * 10000) / 100
        );
    }
}
