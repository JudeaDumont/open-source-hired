package com.example.model.PhraseCluster;

import com.example.model.PhraseCluster.Members.Members;
import lombok.Getter;

import java.util.Hashtable;

@Getter
public class PhraseCluster extends Members {

    protected PhraseCluster() {
    }

    public PhraseCluster(String occurrence,
                         PhraseCluster phraseCluster) {
        setCategory(phraseCluster.getCategory());
        setPhraseClusterName(phraseCluster.getPhraseClusterName());
        Add(occurrence, 1L);
        AddWithNoDensity(phraseCluster.keySet().toArray(new String[0]));
    }

    public PhraseCluster(String category,
                         String phraseClusterName,
                         String[] phrases) {
        setCategory(category);
        setPhraseClusterName(phraseClusterName);
        AddWithDensity(phrases);
    }

    public PhraseCluster(Hashtable<String, Long> ht,
                         long totalDensity,
                         String category,
                         String phraseClusterName) {
        super(ht, totalDensity, category, phraseClusterName); //pass through to density table
    }
}
