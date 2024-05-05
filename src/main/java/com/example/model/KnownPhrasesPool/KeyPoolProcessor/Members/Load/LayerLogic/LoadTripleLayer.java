package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LayerLogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

public class LoadTripleLayer extends LoadDoubleLayer {
    protected LoadTripleLayer() {
    }

    protected static void loadTriple(Hashtable<String, Hashtable<String, ArrayList<String>>> o) {
        //this is going to load outerkey+inner key as categories
        //meaning each inner hashtable can just be passed to loadDouble
        //after collapsing the outer set of outerKeys to the inner set of keys
        Hashtable<String, ArrayList<String>> ht = new Hashtable<>();
        ArrayList<String> outerKeys = Collections.list(o.keys());
        for (String outerKey : outerKeys) {
            Hashtable<String, ArrayList<String>> innerTable = o.get(outerKey);
            ArrayList<String> innerKeys = Collections.list(innerTable.keys());
            for (String innerKey : innerKeys) {
                ArrayList<String> strings = innerTable.get(innerKey);
                ht.put(outerKey + "-" + innerKey, strings);
            }
        }
        loadDouble(ht);
    }
}
