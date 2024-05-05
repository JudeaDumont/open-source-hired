package util.EndPointUtils.CallKeyPoolConfigurationEndPoint;

import java.io.IOException;

import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.CallSetPool.callSetPool;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

public class CallLoadPinnedKeyPool12212023 {
    public static void callLoadPinnedKeyPool12212023() throws IOException, InterruptedException {
        String result = callSetPool(
                readResourceAsString("TestData/KeyPoolSnapShots/KeyPoolSnapshot12212023.json")
        );
        assert (result.equals("Success"));
    }
}
