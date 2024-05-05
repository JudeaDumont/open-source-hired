package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;
import java.util.Map;

public class MergeClusters extends CheckClustersForPhrase {
    void mergeClusters() {
        // all clusters under the same category must guarantee that they contain unique keyphrases
        // if there is a cluster that merges with another because they each contain the same key
        // you must run the whole process again to ensure this contract is satisfied.
        // if this contract is not satisfied, you will find problems where cluster phrases are not organized the same between runs
        // which causes errors in tests.
        boolean runAgain = true;
        while (runAgain) {
            runAgain = false;
            for (Map.Entry<String, Hashtable<String, PhraseCluster>> stringHashtableEntry : pool.entrySet()) {
                for (Map.Entry<String, PhraseCluster> stringPhraseClusterEntry : stringHashtableEntry.getValue().entrySet()) {
                    PhraseCluster pc = stringPhraseClusterEntry.getValue();
                    String[] phrases = pc.keySet().toArray(new String[0]);
                    PhraseCluster phraseCluster = checkClustersForPhrase(phrases, pc.getCategory(), pc.getPhraseClusterName()); //fails because it returns before it gets to the match
                    if (phraseCluster != null) {
                        phraseCluster.AddWithDensity(phrases);
                        pc.clear();
                        runAgain = true;
                    }
                }
            }
        }
    }
}
