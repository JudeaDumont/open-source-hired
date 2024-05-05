package com.example.model.DensityTable.Members;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class OccurredLogic extends AddLogic {
    protected OccurredLogic() {
    }

    public Collection<String> GetOccurred() {
        ArrayList<String> occurred = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : entrySet()) {
            if (stringLongEntry.getValue() > 0) {
                occurred.add(stringLongEntry.getKey());
            }
        }
        return occurred;
    }

    public Collection<String> GetRelated() {
        ArrayList<String> occurred = new ArrayList<>();
        for (Map.Entry<String, Long> stringLongEntry : entrySet()) {
            occurred.add(stringLongEntry.getKey());
        }
        return occurred;
    }
}
