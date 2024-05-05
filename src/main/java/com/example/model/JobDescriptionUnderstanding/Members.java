package com.example.model.JobDescriptionUnderstanding;

import lombok.Getter;

public class Members {
    //What words cannot count as matches?
    //use this: Really, you can't think of an alike phrase to _____?
    //Should be very limited, we want to air on the side of keyphrasing,
    //Even if those keyphrases are categorized as "who cares"
    //we want our users to see "tier wgaf" requests from hiring managers.

    @Getter
    protected Long matchs = 0L;
    @Getter
    protected String[] remaining;
    @Getter
    protected double matchPercentage = 0L;

    protected void setRemainingAndCalcMatchPercentage(String[] remaining) {
        this.remaining = remaining;
        matchPercentage = (double) Math.round((matchs / (double) (matchs + remaining.length)) * 10000)/100;
    }
}
