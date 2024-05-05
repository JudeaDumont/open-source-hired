package com.example.model.MatchBundle.MatchBundleMembers.RudimentaryWordLogic.GetWordsLogic.SplitOnSpaces;

public class SplitOnSpaces {
    public static String[] splitOnSpaces(String plainText) {
        return plainText
                .replace(",", " ")
                .replace(".", " ")
                .replace("(", " ")
                .replace(")", " ")
                .replace(";", " ")
                .replace("\"", " ")
                .replace("'", " ")
                .replace("-", " ")
                .replace("_", " ")
                .replace("+", " ")
                .replace("=", " ")
                .replace("!", " ")
                .replace("&", " ")
                .replace("\\", " ")
                .replace("/", " ")
                .replace("|", " ")
                .replace(":", " ")
                .replace("<", " ")
                .replace(">", " ")
                .replace("*", " ")
                .split(" ");
    }
}
