package com.example.model.JobBundle.Members;

import com.example.model.JobBundle.JobBundle;
import com.example.model.KeyPhrasePuller.FavoriteTechPreprocessor;
import com.example.model.KeyPhrasePuller.MapPhrasesFromPlainText;

import static com.example.model.FixText.FixJDRText.fixJDRText;
import static com.example.model.KeyPhrasePuller.OmittableCategoryLogic.HijackVagueJobDescription;

public class PlainText {
    private PlainText() {
    }

    public static JobBundle jobBundleFromVaguePlainText(String plainText) {
        JobBundle jobBundle = new JobBundle(
                HijackVagueJobDescription(
                        MapPhrasesFromPlainText.ProcessRawTextIntoPhrases(
                                FavoriteTechPreprocessor.pickFavoriteTechWords(
                                        fixJDRText(plainText)
                                )
                        )
                )
        );
        jobBundle.plainText = fixJDRText(plainText);
        return jobBundle;
    }

    public static JobBundle descriptionFromPlainText(String plainText) {
        String plainText1 = fixJDRText(plainText);
        JobBundle jobBundle = new JobBundle(
                MapPhrasesFromPlainText.ProcessRawTextIntoPhrases(
                        FavoriteTechPreprocessor.pickFavoriteTechWords(
                                plainText1
                        )
                )
        );
        jobBundle.plainText = fixJDRText(plainText);
        return jobBundle;
    }
}
