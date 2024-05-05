package com.example.model.KeyPhrasePuller;

import java.util.regex.Pattern;

import static com.example.model.FixText.FixJDRText.fixJDRText;
import static com.example.model.KeyPhrasePuller.KeyPhrasePullLogic.isMatch;

//Operates on the plaintext of a job description before being processed by categorization key phrase logic.
public class FavoriteTechPreprocessor {

    public static String matchWholeWord(String fixedPhrase) {
        return "(?<=\\s|^)" + Pattern.quote(fixedPhrase) + "(?=\\s|$)";
    }

    public static String pickFavoriteTechWords(String plainText) {
        if (isMatch(plainText, "java")) {
            plainText = plainText
                    .replaceAll(matchWholeWord("c#"), "")
                    .replaceAll(matchWholeWord("c++"), "")
                    .replaceAll(matchWholeWord("cpp"), "")
                    .replaceAll(matchWholeWord("ada"), "")
                    .replaceAll(matchWholeWord("c sharp"), "")
                    .replaceAll(matchWholeWord("csharp"), "");
        } else if (isMatch(plainText, "c#") ||
                isMatch(plainText, "c sharp") ||
                isMatch(plainText, "csharp")) {
            plainText = plainText
                    .replaceAll(matchWholeWord("c++"), "")
                    .replaceAll(matchWholeWord("cpp"), "");
        } else if (isMatch(plainText, "cpp") ||
                isMatch(plainText, "c++")) {
            plainText = plainText
                    .replaceAll(matchWholeWord("ada"), "");
        }
        return plainText;
    }
}
