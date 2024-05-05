package com.example.model.CommonBundle.Members;

import com.example.model.Categorizer.Categorizer;
import lombok.Getter;

//Which methods does the common bundle need access to and how are they used?
//this is why we don't just extend the pool categorizer, we don't need everything it exposes
@Getter
public class Members {
    protected Categorizer poolCategorizer = null;

    private Members() {

    }
    protected Members(Categorizer poolCategorizer) {
        this.poolCategorizer = poolCategorizer;
    }
}
