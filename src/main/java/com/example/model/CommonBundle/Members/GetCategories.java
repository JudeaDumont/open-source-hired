package com.example.model.CommonBundle.Members;

import com.example.model.Categorizer.Categorizer;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

public class GetCategories extends GetCategoryByPhrase {

    protected GetCategories(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public HashSet<String> getCategories() {
        HashSet<String> categories = new HashSet<>();
        for (Map.Entry<String, Hashtable<String, PhraseCluster>> stringHashtableEntry :
                poolCategorizer.getCategorized().entrySet()) {
            for (Map.Entry<String, PhraseCluster> stringPhraseClusterEntry : stringHashtableEntry.getValue().entrySet()) {
                categories.add(stringPhraseClusterEntry.getValue().getCategory());
            }
        }
        return categories;
    }
}
