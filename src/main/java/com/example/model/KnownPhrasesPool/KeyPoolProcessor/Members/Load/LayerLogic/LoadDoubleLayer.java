package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LayerLogic;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Json;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class LoadDoubleLayer extends Json {
    protected LoadDoubleLayer() {
    }

    protected static void loadDouble(Hashtable<String, ArrayList<String>> o) {
        //this is going to reverse store values as keys
        //and keys as values (categories)
        Hashtable<String, String> ht = new Hashtable<>();

        ArrayList<String> keys = Collections.list(o.keys());
        for (String key : keys) {
            ArrayList<String> strings = o.get(key);
            for (String string : strings) {
                ht.put(string.toLowerCase(), key.toLowerCase());
            }
        }
        loadSingle(ht);
    }
}
