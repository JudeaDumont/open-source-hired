package com.example.model.MatchedBecause.Members;

import java.util.HashSet;
import java.util.Set;

public class SetOperations extends ContainsLogic {
    public Set<String> Compliment(Set<String> keys) {
        Set<String> returnVal = new HashSet<>();
        Set<String> copy = new HashSet<>(keys);
        Set<String> copyThis = new HashSet<>(keySet());
        copyThis.removeAll(copy);
        copy.removeAll(keySet());
        returnVal.addAll(copyThis);
        returnVal.addAll(copy);
        return returnVal;
    }
}
