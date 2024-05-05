package com.example.model.PhraseCluster.Members;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class ConstructionMethods extends PhraseCluster {
    private ConstructionMethods() {
    }

    public static PhraseCluster createAlikePhrasesWithDensity(String category,
                                                              String phraseClusterName,
                                                              String[] phrases) {
        return new PhraseCluster(category, phraseClusterName, phrases);
    }

    public static PhraseCluster createAlikePhrasesWithOccurrence(String occurrence,
                                                                 PhraseCluster phraseCluster) {
        return new PhraseCluster(occurrence, phraseCluster);
    }

    public static PhraseCluster createAlikePhrasesFromTable(Hashtable<String, Long> ht,
                                                            long totalDensity,
                                                            String category,
                                                            String phraseClusterName) {
        return new PhraseCluster(ht, totalDensity, category, phraseClusterName);
    }
}
