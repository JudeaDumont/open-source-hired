package com.example.model.PhraseCluster.Members;

import com.example.model.DensityTable.DensityTable;
import lombok.Getter;
import lombok.Setter;

import java.util.Hashtable;

@Getter
@Setter
public class Members extends DensityTable {

    private String category;
    private String phraseClusterName;

    protected Members() {
    }

    //Only necessary because initialization from the top level is necessary
    protected Members(Hashtable<String, Long> ht, Long totalDensity, String category, String phraseClusterName) {
        super(ht, totalDensity);
        this.category = category;
        this.phraseClusterName = phraseClusterName;
    }
}
