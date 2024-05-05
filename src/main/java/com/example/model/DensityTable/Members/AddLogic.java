package com.example.model.DensityTable.Members;

import com.example.model.DensityTable.DensityTable;

import java.util.Set;

public class AddLogic extends Json {
    protected AddLogic() {
    }

    //safely add words that should be in there, but have no occurrences associated.
    //often this will be paired with a single add of an occurrence that is associated with many other words.
    public void AddWithNoDensity(String key) {
        Add(key, 0L);
    }

    //add with density, often one, but needs to be made a required argument
    public void Add(String key, Long density) {
        if (ht.containsKey(key)) {
            ht.put(key, ht.get(key) + density);
        } else {
            ht.put(key, density); //have to start at 0 for first setup of alike phrases
        }

        totalDensity += density;
    }

    public void AddWithNoDensity(Set<String> phrases) {
        for (String phrase : phrases) {
            AddWithNoDensity(phrase);
        }
    }

    public void AddWithNoDensity(String[] phrases) {
        for (String phrase : phrases) {
            AddWithNoDensity(phrase);
        }
    }

    public void AddWithDensity(String[] phrases) {
        for (String phrase : phrases) {
            Add(phrase, 1L);
        }
    }

    public void AddWithNoDensity(DensityTable dt) {
        AddWithNoDensity(dt.keySet());
    }

    public void RemoveAll(DensityTable dt) {
        for (String s : dt.keySet()) {
            ht.remove(s);
        }
    }

    public void RemoveAll(Set<String> set) {
        for (String s : set) {
            ht.remove(s);
        }
    }
}
