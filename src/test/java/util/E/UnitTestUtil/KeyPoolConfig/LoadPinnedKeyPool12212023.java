package util.E.UnitTestUtil.KeyPoolConfig;

import java.io.IOException;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

public class LoadPinnedKeyPool12212023 {

    public static void loadPinnedKeyPool12212023() throws IOException, InterruptedException {
        String result;
        result = setKeyPool(
                readResourceAsString("TestData/KeyPoolSnapShots/KeyPoolSnapshot12212023.json")
        );
        assert (result.equals("Success"));
    }
}
