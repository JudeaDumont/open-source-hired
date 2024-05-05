package com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Match;

import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Miss.IsMiss;

import java.util.Set;

public class IsMatch extends IsMiss {
    protected static boolean isMatch(Set<String> jDensity, Set<String> rDensity) {
        return !jDensity.isEmpty() && !rDensity.isEmpty();
    }
}
