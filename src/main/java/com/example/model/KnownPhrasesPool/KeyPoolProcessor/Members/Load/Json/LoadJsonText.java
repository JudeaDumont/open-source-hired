package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.Json;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LayerLogic.LoadTripleLayer;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Hashtable;

public class LoadJsonText extends LoadTripleLayer {
    protected LoadJsonText() {
    }

    static void loadJsonSingleDoubleTripleLayer(String text) {

        //load Hashtable<String, ArrayList<String>>
        Gson gson = new Gson();
        try {
            Hashtable<String, ArrayList<String>> o = gson.fromJson(text, new TypeToken<Hashtable<String, ArrayList<String>>>() {
            }.getType());
            loadDouble(o);
            return;
        } catch (JsonSyntaxException ignored) {

        }

        //load Hashtable<String, Hashtable<String, ArrayList<String>>>
        try {
            Hashtable<String, Hashtable<String, ArrayList<String>>> o = gson.fromJson(text,
                    new TypeToken<Hashtable<String, Hashtable<String, ArrayList<String>>>>() {
                    }.getType());
            loadTriple(o);
            return;
        } catch (JsonSyntaxException ignored) {

        }

        //load Hashtable<String, String>
        try {
            Hashtable<String, String> o = gson.fromJson(text,
                    new TypeToken<Hashtable<String, String>>() {
                    }.getType());
            loadSingle(o);
        } catch (JsonSyntaxException endOfTheLine) {
            throw endOfTheLine;
        }
    }
}
