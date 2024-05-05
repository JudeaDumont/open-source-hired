package com.example.model.JobDescriptionUnderstanding;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;

import static com.example.model.FixText.FixJDRText.fixJDRText;

public class JobDescriptionUnderstanding extends UnderstandingLogic {

    private JobDescriptionUnderstanding() {
    }

    public JobDescriptionUnderstanding(String jdPlainText) {
        getUnderstanding(
                KnownPhrasesPool.getPool()
                        .getPhraseClusters(),
                fixJDRText(jdPlainText));
    }
}
