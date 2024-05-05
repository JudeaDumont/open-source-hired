package com.example.model.Categorizer.Members;

import com.example.model.PhraseCluster.PhraseCluster;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;

import java.util.Hashtable;

public class Members {
    @Getter
    @Setter
    Hashtable<String, Hashtable<String, PhraseCluster>> categorized
            = new Hashtable<>();

    private boolean vagueTech = false;

    protected Members() {
    }

    public String getPersistJson() {
        Gson gson = new Gson();
        return gson.toJson(categorized);
    }

    public void hadVagueTech() {
        vagueTech = true;
    }
}
