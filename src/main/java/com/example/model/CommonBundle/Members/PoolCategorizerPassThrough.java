package com.example.model.CommonBundle.Members;

import com.example.model.Categorizer.Categorizer;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;
import java.util.Set;

//Which methods does the common bundle need access to and how are they used?
//this is why we don't just extend the pool categorizer, we don't need everything it exposes
public class PoolCategorizerPassThrough extends Members {

    protected PoolCategorizerPassThrough(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public String getPersistJson() {
        return poolCategorizer.getPersistJson();
    }

    public Hashtable<String, Hashtable<String, PhraseCluster>> GetCategorizedKeyPhraseHashTable() {
        return poolCategorizer.getCategorized(); //category + key phrases under category
    }

    public void SetCategorizedKeyPhraseHashTable(Hashtable<String, Hashtable<String, PhraseCluster>> categorizedKeyPhraseHashTable) {
        this.poolCategorizer.setCategorized(categorizedKeyPhraseHashTable);
    }

    public Long getDensity(String phrase) {
        return poolCategorizer.getDensity(phrase);
    }

    public Set<String> getOccurrences(String phrase, String category) {
        return poolCategorizer.getOccurrences(phrase, category);
    }

    public Set<String> getAllRelatedPhrases(String phrase) {

        return poolCategorizer.getRelated(phrase);
    }
}
