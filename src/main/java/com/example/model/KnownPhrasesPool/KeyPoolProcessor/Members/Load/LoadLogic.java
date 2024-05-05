package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.Code.LoadCode;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Members;

public class LoadLogic extends LoadCode {
    protected LoadLogic() {
    }

    protected static void load() {
        Members.initialize();
        loadJsonPoolFiles();
        loadCode();
    }
}
