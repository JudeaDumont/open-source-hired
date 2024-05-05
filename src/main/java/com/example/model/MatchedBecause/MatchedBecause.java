package com.example.model.MatchedBecause;

import com.example.model.MatchedBecause.Members.SetOperations;

import java.util.Hashtable;
import java.util.Set;

public class MatchedBecause extends SetOperations {
    public MatchedBecause() {
    }

    public MatchedBecause(Hashtable<String, String> matchedBecause) {
        ht = matchedBecause;
    }

    public void AddAll(String cluster, Set<String> stringSet) {
        for (String s : stringSet) {
            Add(cluster, s, s);
        }
    }

    public void AddAll(MatchedBecause matchedBecause) {
        ht.putAll(matchedBecause.ht);
    }
}
