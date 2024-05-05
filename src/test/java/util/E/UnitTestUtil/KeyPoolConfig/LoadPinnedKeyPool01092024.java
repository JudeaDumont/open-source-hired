package util.E.UnitTestUtil.KeyPoolConfig;

import java.io.IOException;

import static util.E.UnitTestUtil.KeyPoolConfig.SetKeyPool.setKeyPool;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

public class LoadPinnedKeyPool01092024 {

    public static void loadPinnedKeyPool01092024() throws IOException, InterruptedException {
        String result = setKeyPool(
                readResourceAsString("TestData/KeyPoolSnapShots/KeyPoolSnapshot01092024.json")
        );
        assert (result.equals("Success"));
    }
}
