package util.EndPointUtils.CallKeyPoolConfigurationEndPoint;

import java.io.IOException;

import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.CallSetPool.callSetPool;
import static util.FileIO.ReadResourceAsString.readResourceAsString;

public class CallLoadPinnedKeyPool01092024 {

    public static void callLoadPinnedKeyPool01092024() throws IOException, InterruptedException {
        String result = callSetPool(
                readResourceAsString("TestData/KeyPoolSnapShots/KeyPoolSnapshot01092024.json")
        );
        assert (result.equals("Success"));
    }
}
