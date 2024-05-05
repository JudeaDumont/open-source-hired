package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.LoadLogic;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.PoolOfAlikePhrases;

public class SingletonLogic extends LoadLogic {
    protected SingletonLogic() {
    }

    public static PoolOfAlikePhrases getPool() {
        if (hugeCompositePool == null) {
            load();
        }
        return hugeCompositePool;
    }
}
