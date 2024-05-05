package com.example.model.MatchedBecause.Members;

import com.example.model.MatchedBecause.MatchedBecause;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.Hashtable;

public class Json extends Members {
    protected Json() {
    }

    public static MatchedBecause fromJson(String json) {
        Gson gson = new Gson();
        Hashtable<String, String> deserialized
                = gson.fromJson(json, new TypeToken<Hashtable<String, String>>() {
        }.getType());
        return new MatchedBecause(deserialized);
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(ht);
    }
}
