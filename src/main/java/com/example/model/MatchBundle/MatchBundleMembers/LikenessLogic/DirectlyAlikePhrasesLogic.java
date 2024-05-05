package com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic;

import com.example.model.DensityTable.DensityTable;
import com.example.model.JobBundle.JobBundle;
import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Match.IsMatch;
import com.example.model.MatchedBecause.MatchedBecause;
import com.example.model.PhraseCluster.PhraseCluster;
import com.example.model.ResumeBundle.ResumeBundle;

import java.util.Hashtable;
import java.util.Set;

/**
 * // will not match on the same items over and over again
 * // but if a new relation is presented it will match on it.
 * // p{a,c}, r{a}, j{b} = no match
 * // p{a,b}, r{a, a, a}, j{b} = match b --- a
 * // p{a,b}, r{a, b}, j{b} = 2 match b --- a, b --- b
 * // p{a,c}{a,b}, r{a, b}, j{b} = 2 match b --- a, b --- b //multiple relations to a, and first is not a hard stop
 * <p>
 * //It will only match if the categories are the same.
 */

public class DirectlyAlikePhrasesLogic extends IsMatch {
    public DirectlyAlikePhrasesLogic() {
    }

    public DirectlyAlikePhrasesLogic(
            DensityTable missedDensity,
            DensityTable matchedDensity,
            MatchedBecause matchedBecause,
            DensityTable superfluousDensity,
            double matchPercentage){
        setMissedDensity(missedDensity);
        setMatchedDensity(matchedDensity);
        setMatchedBecause(matchedBecause);
        setSuperfluousDensity(superfluousDensity);
        setMatchPercentage(matchPercentage);
    }

    public void processDirectlyAlikePhrases(JobBundle jobBundleV2, ResumeBundle resumeBundleV2) {
        Hashtable<String, PhraseCluster> phraseClusters = KnownPhrasesPool.getPhraseClusters();
        for (PhraseCluster phraseCluster : phraseClusters.values()) {
            for (String phrase : phraseCluster.keySet()) {
                Set<String> jDensity = jobBundleV2.getOccurrences(phrase, phraseCluster.getCategory());
                Set<String> rDensity = resumeBundleV2.getOccurrences(phrase, phraseCluster.getCategory());
                if (isMatch(jDensity, rDensity)) {
                    addUniqueMatches(phraseCluster, jDensity, rDensity);
                } else if (isMiss(rDensity, jDensity)) {
                    addUniqueMiss(jDensity.toString());
                } else if (isSuperfluous(jobBundleV2, resumeBundleV2, phrase, jDensity, rDensity)) {
                    addUniqueSuperfluous(rDensity);
                } else {
                    //irrelevant
                    //superfluous but not a red flag.
                }
            }
        }
        setMatchPercentage(
                calcMatchPercentage()
        );
    }
}
