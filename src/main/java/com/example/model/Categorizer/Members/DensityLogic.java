package com.example.model.Categorizer.Members;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class DensityLogic extends CategorizationLogic {

    protected DensityLogic() {
    }

    private static Long getPhraseDensityIfCatMoreDense(String phrase,
                                                       String string,
                                                       Hashtable<String, PhraseCluster> stringPhraseClusterHashtable,
                                                       Long phraseDensity) {
        PhraseCluster phraseCluster = stringPhraseClusterHashtable.get(string);
        Long phraseClusterDensity = phraseCluster.getDensity(phrase);
        if (phraseClusterDensity > phraseDensity) {
            phraseDensity = phraseClusterDensity;
        }
        return phraseDensity;
    }

    public Long getDensity(String phrase) {
        //compensates for duplicate keyword matches by only counting the highest number of matches.
        //meaning if you have a bunch of adjacent tech that matches with docker in one phrase cluster,
        //that will be higher than the tiny cluster with just docker in it.
        //note that duplicates will only exist in different categories
        return checkAllCategoriesForHigherDensity(phrase, 0L);
    }

    private Long checkAllCategoriesForHigherDensity(String phrase, Long phraseDensity) {
        for (String allCategories : getCategorized().keySet()) {
            Hashtable<String, PhraseCluster> phrasesToClusters = getCategorized().get(allCategories);
            for (String checkPhrases : phrasesToClusters.keySet()) {
                phraseDensity = getPhraseDensityIfCatMoreDense(
                        phrase,
                        checkPhrases,
                        phrasesToClusters,
                        phraseDensity);
            }
        }
        return phraseDensity;
    }

}
