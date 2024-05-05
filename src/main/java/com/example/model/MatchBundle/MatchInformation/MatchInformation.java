package com.example.model.MatchBundle.MatchInformation;

import com.example.model.DensityTable.DensityTable;
import com.example.model.MatchedBecause.MatchedBecause;
import com.example.model.PhraseCluster.PhraseCluster;
import com.google.gson.Gson;

import java.util.Set;

public class MatchInformation extends MatchInformationMembers {

    public MatchInformation(){
        setMissedDensity(new DensityTable());
        setMatchedDensity(new DensityTable());
        setMatchedBecause(new MatchedBecause());
        setSuperfluousDensity(new DensityTable());
    }

    public MatchInformation(
            DensityTable missedDensity,
            DensityTable matchedDensity,
            MatchedBecause matchedBecause,
            DensityTable superfluousDensity,
            double matchPercentage){
        setMissedDensity(missedDensity);
        setMatchedDensity(matchedDensity);
        setMatchedBecause(matchedBecause);
        setSuperfluousDensity(superfluousDensity);
        setMatchPercentage(matchPercentage);
    }
    protected void match(PhraseCluster phraseCluster, String j, String r) {
        Gson gson = new Gson();
        Set<String> keys = phraseCluster.keySet();
        match(phraseCluster.getPhraseClusterName()); // this makes way more sense to match on
        getMatchedBecause().Add(
                gson.toJson(keys),
                j,
                r
        );
        getFlatMatched().add(j);
        getFlatMatched().add(r);
    }

    protected void match(String key) {
        getMatchedDensity().Add(key, 1L);
    }

    public void addUniqueMatches(PhraseCluster phraseCluster, Set<String> jDensity, Set<String> rDensity) {
        for (String j : jDensity) {
            for (String r : rDensity) {
                if (!getMatchedBecause().Contains(j, r)) { //note that Contains has custom logic here
                    match(phraseCluster, j, r);
                }
            }
        }
    }

    public void addUniqueMiss(String phrase) {
        if (!getMissedDensity().containsKey(phrase)) {
            miss(phrase);
        }
    }

    protected void miss(String key) {
        getMissedDensity().Add(key, 1L);
    }

    public void addUniqueSuperfluous(String phrase) {
        if (!getSuperfluousDensity().containsKey(phrase)) {
            superfluous(phrase);
        }
    }

    public void addUniqueSuperfluous(Set<String> rDensity) {
        for (String s : rDensity) {
            addUniqueSuperfluous(s);
        }
    }

    protected void superfluous(String key) {
        getSuperfluousDensity().Add(key, 1L);
    }

    public double calcMatchPercentage() { //java math ykwim?
        return (double) Math.round((double) (matchedTotalDensity()) / (double) (
                matchedTotalDensity() + missedTotalDensity() + superfluousTotalDensity()
        ) * 10000) / 100;
    }

    public String getMatchedBecause(String matchString) {
        return getMatchedBecause().get(matchString);
    }

    public Long matchedTotalDensity() {
        return getMatchedDensity().getTotalDensity();
    }
}
