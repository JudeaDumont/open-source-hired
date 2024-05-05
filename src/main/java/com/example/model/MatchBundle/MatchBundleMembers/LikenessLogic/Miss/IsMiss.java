package com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Miss;

import com.example.model.MatchBundle.MatchBundleMembers.LikenessLogic.Superfluous.IsSuperfluous;

import java.util.Set;

public class IsMiss extends IsSuperfluous {
    protected static boolean isMiss(Set<String> rDensity, Set<String> jDensity) {
        return rDensity.isEmpty() && !jDensity.isEmpty();
    }
}
