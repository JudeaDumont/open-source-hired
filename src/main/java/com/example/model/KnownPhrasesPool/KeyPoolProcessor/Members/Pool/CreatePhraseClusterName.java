package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool;

public class CreatePhraseClusterName {
    static String createPhraseClusterName(String[] phrasesStringSplit, String category) {
        int shortestSize = Integer.MAX_VALUE;
        String shortestString = "";
        for (String key : phrasesStringSplit) {
            if (key.length() < shortestSize) {
                shortestSize = key.length();
                shortestString = key;
            }
        }
        assert (!shortestString.isEmpty());

        return shortestString + "-" + category;
    }
}
