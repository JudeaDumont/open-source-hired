package com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.GetWordsLogic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.GetWordsLogic.SplitOnSpaces.SplitOnSpaces.splitOnSpaces;

public class GetWords {
    public static Set<String> getWords(String plainText) {
        //first replace all the punctuation with spaces
        //then split on spaces
        String[] splitOnSpaces = splitOnSpaces(plainText);
        //then feed into a set
        //then return the set
        return new HashSet<>(Arrays.asList(splitOnSpaces));
    }
}
