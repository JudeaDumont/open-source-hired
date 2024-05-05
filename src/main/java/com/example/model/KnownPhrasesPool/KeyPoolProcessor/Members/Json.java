package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members;

import com.example.model.FixText.FixPoolText;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LayerLogic.LoadSingleLayer;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.PoolOfAlikePhrases;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Hashtable;

public class Json extends LoadSingleLayer {
    protected Json() {
    }

    public static void setFromJson(String keyPool) {
        keyPool = FixPoolText.fixPoolText(keyPool);
        Gson gson = new Gson();
        Hashtable<String, String> ht =
                gson.fromJson(keyPool, new TypeToken<Hashtable<String, String>>() {
                }.getType());
        hugeCompositePool = new PoolOfAlikePhrases();
        loadSingle(ht);
    }

    public static String toJson() {
        Gson gson = new Gson();
        return gson.toJson(hugeCompositePool);
    }
}
