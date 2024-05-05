package com.example.model.MatchBundle.MatchBundleMembers;

import com.example.model.DensityTable.DensityTable;
import com.example.model.MatchBundle.MatchBundleV2;
import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.DirectlyAlikePhrasesLogic;
import com.example.model.MatchedBecause.MatchedBecause;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.Hashtable;

import static z.util.JsonProcessing.GetJsonOutOfResponse.getJsonOutOfResponse;

public class MatchBundleJson extends MatchBundleMembers {
    protected MatchBundleJson() {
    }

    public static MatchBundleV2 getMatchBundleFromJson(byte[] bytes) {
        Gson gson = new Gson();
        String data = getJsonOutOfResponse(bytes);

        JsonObject dataJsonObject = gson.fromJson(data, new TypeToken<JsonObject>() {
        }.getType());

        String matchBundleString = dataJsonObject.get("match").getAsString();
        MatchBundleV2 matchBundleV2
                = MatchBundleV2.fromJson(matchBundleString);

        return matchBundleV2;
    }

    public static MatchBundleV2 fromJson(String json) {
        Gson gson = new Gson();
        Hashtable<String, JsonElement> results =
                gson.fromJson(json, new TypeToken<Hashtable<String, JsonElement>>() {
                }.getType());
        JsonObject missedObject = results.get("missed").getAsJsonObject();
        JsonObject matchedObject = results.get("matched").getAsJsonObject();
        JsonObject matchedBecauseObject = results.get("matchedBecause").getAsJsonObject();
        JsonObject superfluousObject = results.get("superfluous").getAsJsonObject();

        String missedJsonHashtable = gson.toJson(missedObject.get("ht"));
        String matchedJsonHashtable = gson.toJson(matchedObject.get("ht"));
        String superfluousHashtable = gson.toJson(superfluousObject.get("ht"));
        String matchedBecauseJsonHashtable = gson.toJson(matchedBecauseObject);

        Hashtable<String, Long> missed =
                gson.fromJson(missedJsonHashtable, new TypeToken<Hashtable<String, Long>>() {
                }.getType());

        Hashtable<String, Long> matched =
                gson.fromJson(matchedJsonHashtable, new TypeToken<Hashtable<String, Long>>() {
                }.getType());

        Hashtable<String, String> matchedBecause =
                gson.fromJson(matchedBecauseJsonHashtable, new TypeToken<Hashtable<String, String>>() {
                }.getType());

        Hashtable<String, Long> superfluous =
                gson.fromJson(superfluousHashtable, new TypeToken<Hashtable<String, Long>>() {
                }.getType());

        DirectlyAlikePhrasesLogic likenessMatchInformation = new DirectlyAlikePhrasesLogic(
                new DensityTable(missed, missedObject.get("totalDensity").getAsLong()),
                new DensityTable(matched, matchedObject.get("totalDensity").getAsLong()),
                new MatchedBecause(matchedBecause),
                new DensityTable(superfluous, superfluousObject.get("totalDensity").getAsLong()),
                results.get("matchPercentage").getAsDouble()
        );

        return new MatchBundleV2(likenessMatchInformation);
    }

    public String toJson() {
        return "{" +
                "\"missed\":" + getLikenessLogicMatches().getMissedDensity().toJson() + "," +
                "\"matched\":" + getLikenessLogicMatches().getMatchedDensity().toJson() + "," +
                "\"matchedBecause\":" + getLikenessLogicMatches().getMatchedBecause().toJson() + "," +
                "\"superfluous\":" + getLikenessLogicMatches().getSuperfluousDensity().toJson() + "," +
                "\"matchPercentage\":" + getLikenessLogicMatches().getMatchPercentage() + "," +
                "\"combinedMatchedBecause\":" + getCombinedMatchedBecause().toJson() + "," +
                "\"combinedMissed\":" + getCombinedMissed().toJson() + "," +
                "\"combinedSuperfluous\":" + getCombinedSuperfluous().toJson() +
                "}";
    }
}
