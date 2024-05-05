package util.EndPointUtils;

import util.HttpClient.Get;
import util.HttpClient.HttpClient;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.net.http.HttpResponse;

public class CallGetAllBundleEndPoint {

    private static final String keywordCheckerAPIPath = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/keywordchecker/";

    public static String getAllBundles(
    ) throws IOException, InterruptedException {

        HttpResponse<String> response = Get.get(keywordCheckerAPIPath + "getAllBundles");
        return response.body();
    }
}
