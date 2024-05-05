package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.PoolOfAlikePhrases;
import com.example.model.PhraseCluster.PhraseCluster;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class Members {
    protected static ArrayList<String> loadedFiles;
    protected static PoolOfAlikePhrases hugeCompositePool = null;

    protected Members() {
    }

    protected static void initialize() {
        hugeCompositePool = new PoolOfAlikePhrases();
        loadedFiles = new ArrayList<>();
    }

    public static Hashtable<String, PhraseCluster> getPhraseClusters() {
        return hugeCompositePool.getPhraseClusters();
    }


    public static String getPinnableJson() {
        Hashtable<String, String> keyCat = new Hashtable<>();
        for (PhraseCluster hugeListOfRecognizedKeyword : hugeCompositePool.getPhraseClusters().values()) {
            StringBuilder alikePhrases = new StringBuilder();
            for (Map.Entry<String, Long> stringLongEntry : hugeListOfRecognizedKeyword.entrySet()) {
                alikePhrases.append(stringLongEntry.getKey()).append(",");
            }
            keyCat.put(alikePhrases.toString(), hugeListOfRecognizedKeyword.getCategory());
        }
        Gson gson = new Gson();
        return gson.toJson(keyCat);
    }
}
