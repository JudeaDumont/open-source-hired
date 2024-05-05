package com.example.model.KeyPhrasePuller.AddKeyPhrasesFromRawText;

import com.example.model.Categorizer.Categorizer;
import com.example.model.KeyPhrasePuller.KeyPhrasePullLogic;
import com.example.model.KnownPhrasesPool.KnownPhrasesPool;
import com.example.model.PhraseCluster.PhraseCluster;

import java.util.Hashtable;

import static com.example.model.FixText.FixJDRText.fixJDRText;

public class AddKeyPhrasesFromRawText {
    protected AddKeyPhrasesFromRawText() {
    }
    public static void AddKeyPhrasesFromRawText(String plainText, Categorizer poolCategorizer) {

        plainText = fixJDRText(plainText);

        Hashtable<String, PhraseCluster> manyRecognizedPhrases = KnownPhrasesPool.getPhraseClusters();
        for (PhraseCluster phraseCluster : manyRecognizedPhrases.values()) {
            for (String phrase : phraseCluster.keySet()) {
                if (KeyPhrasePullLogic.isMatch(plainText, phrase)) {
                    poolCategorizer.categorize(phrase, phraseCluster);
                }
            }
        }
    }
}
