package com.example.model.ResumeBundle.Members;

import com.example.model.KeyPhrasePuller.MapPhrasesFromPlainText;
import com.example.model.ResumeBundle.ResumeBundle;

import static com.example.model.FixText.FixJDRText.fixJDRText;

public class PlainText {

    private PlainText() {
    }

    public static ResumeBundle resumeFromPlainText(String plainText) {
        ResumeBundle resumeBundle = new ResumeBundle(
                MapPhrasesFromPlainText.ProcessRawTextIntoPhrases(
                        fixJDRText(plainText)
                )
        );
        resumeBundle.plainText = fixJDRText(plainText);
        return resumeBundle;
    }
}
