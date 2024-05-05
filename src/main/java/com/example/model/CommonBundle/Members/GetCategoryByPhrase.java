package com.example.model.CommonBundle.Members;

import com.example.model.Categorizer.Categorizer;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class GetCategoryByPhrase extends PoolCategorizerPassThrough {
    protected GetCategoryByPhrase(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public HashSet<String> getCategoryByPhrase(String phrase) {
        HashSet<String> categories = new HashSet<>();
        for (Map.Entry<String, Hashtable<String, PhraseCluster>> stringHashtableEntry :
                poolCategorizer.getCategorized().entrySet()) {
            for (Map.Entry<String, PhraseCluster> stringPhraseClusterEntry : stringHashtableEntry.getValue().entrySet()) {
                if (stringPhraseClusterEntry.getValue().containsKey(phrase)) {
                    categories.add(stringPhraseClusterEntry.getValue().getCategory());
                }
            }
        }
        return categories;
    }
}
