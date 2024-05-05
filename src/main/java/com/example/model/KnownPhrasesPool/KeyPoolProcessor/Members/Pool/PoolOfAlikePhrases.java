package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class PoolOfAlikePhrases extends LoadLogic {

    public Hashtable<String, PhraseCluster> getPhraseClusters() {
        Hashtable<String, PhraseCluster> clusters = new Hashtable<>();
        for (String s : pool.keySet()) {
            Hashtable<String, PhraseCluster> clustersUnderCategory = pool.get(s);
            clusters.putAll(clustersUnderCategory);
        }
        return clusters;
    }
}
