package com.example.model.MatchBundle.MatchInformation;

import com.example.model.DensityTable.DensityTable;
import com.example.model.MatchedBecause.MatchedBecause;

import java.util.HashSet;
import java.util.Set;

public class MatchInformationMembers {
    private DensityTable superfluousDensity;
    private DensityTable missedDensity;

    private DensityTable matchedDensity;
    private MatchedBecause matchedBecause;

    public Set<String> getFlatMatched() {
        return flatMatched;
    }

    private Set<String> flatMatched = new HashSet<>();
    private double matchPercentage = 0;

    public DensityTable getMatchedDensity() {
        return matchedDensity;
    }

    public MatchedBecause getMatchedBecause() {
        return matchedBecause;
    }

    public DensityTable getSuperfluousDensity() {
        return superfluousDensity;
    }

    public Long matchedTotalDensity() {
        return matchedDensity.getTotalDensity();
    }

    public Long missedTotalDensity() {
        return missedDensity.getTotalDensity();
    }

    public Long superfluousTotalDensity() {
        return superfluousDensity.getTotalDensity();
    }

    public void setMatchPercentage(double matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public double getMatchPercentage() {
        return matchPercentage;
    }

    public Long getMissedDensity(String matchString) {
        return missedDensity.getDensity(matchString);
    }

    public void setMissedDensity(DensityTable missedDensity) {
        this.missedDensity = missedDensity;
    }

    public void setMatchedDensity(DensityTable matchedDensity) {
        this.matchedDensity = matchedDensity;
    }

    public void setMatchedBecause(MatchedBecause matchedBecause) {
        this.matchedBecause = matchedBecause;
    }

    public void setSuperfluousDensity(DensityTable superfluousDensity) {
        this.superfluousDensity = superfluousDensity;
    }

    public DensityTable getMissedDensity() {
        return missedDensity;
    }
}
