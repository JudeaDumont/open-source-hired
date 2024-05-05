package com.example.model.DensityTable.Members;

import lombok.Getter;

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Members {
    protected Hashtable<String, Long> ht;
    @Getter
    protected Long totalDensity = 0L;

    protected Members() {
    }

    public Long getDensity(String phrase) {
        Long l = ht.get(phrase);
        return l == null ? 0L : l;
    }

    public int size() {
        return ht.size();
    }

    public Set<String> keySet() {
        return ht.keySet();
    }

    public Set<Map.Entry<String, Long>> entrySet() {
        return ht.entrySet();
    }

    public boolean containsKey(String key) {
        return ht.containsKey(key);
    }

    public void clear() {
        ht.clear();
    }

}
