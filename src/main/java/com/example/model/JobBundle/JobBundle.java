package com.example.model.JobBundle;

import com.example.model.Categorizer.Categorizer;
import com.example.model.CommonBundle.CommonBundle;

public class JobBundle extends CommonBundle {

    private JobBundle() {
        super((Categorizer) null);
    }

    public JobBundle(Categorizer poolCategorizer) {
        super(poolCategorizer);
    }

    public JobBundle(
            CommonBundle commonBundle
    ) {
        super(commonBundle);
    }
}
