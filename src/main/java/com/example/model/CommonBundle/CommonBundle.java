package com.example.model.CommonBundle;

import com.example.model.Categorizer.Categorizer;
import com.example.model.CommonBundle.Members.GetCategories;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

public class CommonBundle extends GetCategories {

    public String plainText = "";

    public CommonBundle(CommonBundle commonBundle) {
        super(commonBundle.getPoolCategorizer());
        SetCategorizedKeyPhraseHashTable(commonBundle.GetCategorizedKeyPhraseHashTable());
    }

    private CommonBundle() {
        super(null);
    }

    public CommonBundle(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public CommonBundle(Hashtable<String, Hashtable<String, PhraseCluster>> categorizedKeyPhraseHashTable) {
        super(Categorizer.Create());
        this.SetCategorizedKeyPhraseHashTable(categorizedKeyPhraseHashTable);
    }
}
