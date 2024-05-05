package util.E.UnitTestUtil.KeyPoolConfig;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;

public class LoadProdPool {
    public static String loadProdPool() {
        KnownPhrasesPool.loadProdPool();
        return "Success";
    }
}
