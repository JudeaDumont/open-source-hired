package com.example.model.KeyPhrasePuller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KeyPhrasePullLogic {
    private KeyPhrasePullLogic() {
    }

    //!!!!!!!!!!!!!SEE fixPlainText in MapPhrasesFromPlainText.java for CONFORMAL TEXT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static boolean isMatch(String plainText, String keyPhrase) {
        //yeah, it's hard.
        String fixedPhrase = keyPhrase.replace("-", " ");
        String regex = matchWholeWord(fixedPhrase)
                + "|" +
                matchWholeWord(fixedPhrase + "s")
                + "|" +
                matchWholeWord(fixedPhrase + "y")
                + "|" +
                matchWholeWord(fixedPhrase + "ing")
                + "|" +
                matchWholeWord(fixedPhrase + "ings")
                + "|" +
                matchWholeWord(fixedPhrase + "er")
                + "|" +
                matchWholeWord(fixedPhrase + "ment")
                + "|" +
                matchWholeWord(fixedPhrase + "ed")
                + "|" +
                matchWholeWord(fixedPhrase + "ability")
                + "|" +
                matchWholeWord(fixedPhrase + "able")
                + "|" +
                matchWholeWord(doubleLastLetter(fixedPhrase) + "ed")
                + "|" +
                matchWholeWord(doubleLastLetter(fixedPhrase) + "ability") //the last letter doubled, then plus ed, and ability
                + "|" +
                matchWholeWord(doubleLastLetter(fixedPhrase) + "able");

        String incoming = Pattern.quote( // have to quote the plaintext as a literal for the regex
                " " +
                        plainText +//have to encapsulate the original string in spaces before and after the quote wrap
                        " ");
        Pattern patt = Pattern.compile(regex);
        Matcher matcher = patt.matcher(incoming);
        boolean matches = matcher.matches();

        if (keyPhrase.equals("findProblemsWithMatchingThisPhrase")) {
            int i = 0;
        }
        return matches;
    }

    private static String doubleLastLetter(String fixedPhrase) {
        return fixedPhrase + fixedPhrase.charAt(fixedPhrase.length() - 1);
    }

    public static String matchWholeWord(String fixedPhrase) {
        return ".*(?<=\\s|^)" + Pattern.quote(fixedPhrase) + "(?=\\s|$).*";
    }
}
