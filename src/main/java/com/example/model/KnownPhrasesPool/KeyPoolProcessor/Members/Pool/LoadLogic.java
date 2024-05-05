package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

import static com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.CreatePhraseClusterName.createPhraseClusterName;
import static com.example.model.PhraseCluster.Members.ConstructionMethods.createAlikePhrasesWithDensity;

public class LoadLogic extends MergeClusters {
    // All of the key pool resources go through this function, so it is generally used as a preprocessor for things going into the pool.
    public void load(Hashtable<String, String> incomingPhrasesToCategory) {
        if (pool == null) {//The reason why this was not a big deal is because different files typically have different categories.
            pool = new Hashtable<>();
        }

        Set<Map.Entry<String, String>> entries = incomingPhrasesToCategory.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String phrasesString = entry.getKey();
            String category = entry.getValue();
            String[] phrasesStringSplit = phrasesString.split(",");

            //hang on, we might not need to create a new cluster.
            //you can just change the category if you don't want phrase clusters to merge
            PhraseCluster phraseCluster = checkClustersForPhrase(phrasesStringSplit, category, "NoClusterName");
            if (phraseCluster != null) {
                phraseCluster.AddWithDensity(phrasesStringSplit);
                //may have to merge now
                mergeClusters();
            } else {
                String phraseClusterName = createPhraseClusterName(phrasesStringSplit, category);
                if (containsCategory(category)) { //has category
                    if (pool.get(category).containsKey(phraseClusterName)) { //has phrases
                        pool.get(category).get(phraseClusterName)
                                .AddWithDensity(
                                        phrasesStringSplit
                                );
                    } else { //does not have phrases
                        PhraseCluster phraseClusterWithDensity = createAlikePhrasesWithDensity(category, phraseClusterName, phrasesStringSplit);
                        pool.get(category).put(phraseClusterName, phraseClusterWithDensity);
                    }
                } else { //does not have category
                    PhraseCluster phraseClusterWithDensity = createAlikePhrasesWithDensity(category, phraseClusterName, phrasesStringSplit);
                    Hashtable<String, PhraseCluster> value = new Hashtable<>();
                    value.put(phraseClusterName, phraseClusterWithDensity);
                    pool.put(
                            category,
                            value
                    );
                }
            }
        }
    }
}
