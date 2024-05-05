package util.EndPointUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static util.HttpClient.PostMultipartFormData.postMultipartFormData;

public class CallDeleteBundle {
    static String keywordCheckerAPIPath = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/keywordchecker/";

    public static void delBundle(String bundleName) throws IOException, InterruptedException {
        MultipartEntityBuilder deleteBuilder = MultipartEntityBuilder.create();
        deleteBuilder.addTextBody(
                "bundleName",
                bundleName
        );

        HttpEntity httpEntityDelete = postMultipartFormData(
                keywordCheckerAPIPath + "removeBundle", deleteBuilder);
        byte[] bytesRemove = httpEntityDelete.getContent().readAllBytes();
        String textRemove = new String(bytesRemove, StandardCharsets.UTF_8);

        Gson gson = new Gson();
        ArrayList<Long> deletedIds = gson.fromJson(textRemove, new TypeToken<ArrayList<Long>>() {
        }.getType());
        assert (deletedIds.size() == 1);
    }
}
