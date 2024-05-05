package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class Members {
    Hashtable<String, Hashtable<String, PhraseCluster>> pool;

    boolean containsCategory(String category) {
        return pool.containsKey(category);
    }
}
