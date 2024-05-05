package com.example.model.DensityTable.Members;

import com.google.gson.Gson;

public class Json extends Members {
    protected Json() {
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
