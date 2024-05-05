package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;
import java.util.Map;

public class CheckClustersForPhrase extends Members {
    PhraseCluster checkClustersForPhrase(String[] phrasesStringSplit, String category, String phraseClusterName) {
        for (String phrase : phrasesStringSplit) {
            for (Map.Entry<String, Hashtable<String, PhraseCluster>> stringHashtableEntry : pool.entrySet()) {
                for (Map.Entry<String, PhraseCluster> stringPhraseClusterEntry : stringHashtableEntry.getValue().entrySet()) {
                    if (!phraseClusterName.equals(stringPhraseClusterEntry.getValue().getPhraseClusterName()) &&
                            category.equals(stringPhraseClusterEntry.getValue().getCategory())
                            && stringPhraseClusterEntry.getValue().containsKey(phrase)) {
                        return stringPhraseClusterEntry.getValue();
                    }
                }
            }
        }
        return null;
    }
}
