package com.example.model.KeyPhrasePuller;

import com.example.model.Categorizer.Categorizer;
import com.example.model.KeyPhrasePuller.AddKeyPhrasesFromRawText.AddKeyPhrasesFromRawText;

public class MapPhrasesFromPlainText extends AddKeyPhrasesFromRawText {
    protected MapPhrasesFromPlainText() {
    }

    public static Categorizer ProcessRawTextIntoPhrases(String plainText) {

        Categorizer poolCategorizer = Categorizer.Create();

        AddKeyPhrasesFromRawText(plainText, poolCategorizer);

        return poolCategorizer;
    }
}
