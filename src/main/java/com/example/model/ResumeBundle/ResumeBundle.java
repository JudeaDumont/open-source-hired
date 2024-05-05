package com.example.model.ResumeBundle;

import com.example.model.Categorizer.Categorizer;
import com.example.model.CommonBundle.CommonBundle;

public class ResumeBundle extends CommonBundle {

    public ResumeBundle(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public ResumeBundle(
            CommonBundle commonBundle
    ) {
        super(commonBundle);
    }
}
