package com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Load.Testing;

import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.Pool.PoolOfAlikePhrases;
import com.example.model.KnownPhrasesPool.KeyPoolProcessor.Members.SingletonLogic;

public class TestingLoadLogic extends SingletonLogic {
    protected TestingLoadLogic() {
    }

    //necessary for testing purposes because the static pool is not destroyed and recreated between test runs.
    // so one of them will load a very small pool and then everything else will fail.
    public static void loadProdPool() {
        hugeCompositePool = new PoolOfAlikePhrases();
        load();
    }
}
