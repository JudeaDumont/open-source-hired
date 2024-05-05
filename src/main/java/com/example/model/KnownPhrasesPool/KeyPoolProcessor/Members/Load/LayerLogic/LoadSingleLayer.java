package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LayerLogic;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Members;

import java.util.Hashtable;

public class LoadSingleLayer extends Members {
    protected LoadSingleLayer() {
    }

    protected static void loadSingle(Hashtable<String, String> phrasesToCategory) {
        hugeCompositePool.load(phrasesToCategory);
    }
}
