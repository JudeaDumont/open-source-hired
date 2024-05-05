package com.example.model.MatchedBecause.Members;

import java.util.Hashtable;
import java.util.Set;

public class Members {
    protected Hashtable<String, String> ht = new Hashtable<>();

    protected Members() {
    }

    public int size() {
        return ht.size();
    }

    public String get(String matchString) {
        return ht.get(matchString);
    }

    public Set<String> keySet() {
        return ht.keySet();
    }
}
