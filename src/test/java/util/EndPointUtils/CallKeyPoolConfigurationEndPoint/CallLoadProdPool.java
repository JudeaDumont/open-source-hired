package util.EndPointUtils.CallKeyPoolConfigurationEndPoint;

import util.HttpClient.Get;

import java.io.IOException;
import java.net.http.HttpResponse;

import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.KeyPoolConfigurationAPIPath.keyPoolConfigurationAPIPath;

public class CallLoadProdPool {

    public static String callLoadProdPool() throws IOException, InterruptedException {

        HttpResponse<String> response = Get.get(
                keyPoolConfigurationAPIPath + "loadProdPool");
        String loadStatus = response.body();
        assert (loadStatus.equals("Success"));
        return loadStatus;
    }
}
