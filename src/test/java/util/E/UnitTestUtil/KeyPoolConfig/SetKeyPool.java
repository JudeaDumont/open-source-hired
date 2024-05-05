package util.E.UnitTestUtil.KeyPoolConfig;

import com.example.model.KnownPhrasesPool.KnownPhrasesPool;

import java.io.IOException;

public class SetKeyPool {
    public static String setKeyPool(String keyPoolJson) throws IOException, InterruptedException {
        try {
            KnownPhrasesPool.setFromJson(keyPoolJson);
        } catch (Exception e) {
            return "Failed";
        }
        return "Success";
    }
}
