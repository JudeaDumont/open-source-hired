package util.EndPointUtils;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import util.HttpClient.HttpClient;
import util.HttpClient.PostMultipartFormData;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CallPersistBundleResumePlainTextOnlyEndPoint {

    private static final String keywordCheckerAPIPath = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/keywordchecker/";

    public static String persistResumeBundlePlaintextOnly(
            String bundleName,
            String plainText
    ) throws IOException, InterruptedException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "bundleName",
                bundleName
        );
        builder.addTextBody(
                "plainText",
                plainText
        );

        HttpEntity httpEntity = PostMultipartFormData
                .postMultipartFormData(keywordCheckerAPIPath + "persistResumeBundle", builder);
        byte[] bytes = httpEntity.getContent().readAllBytes();
        String text = new String(bytes, StandardCharsets.UTF_8);
        return text;
    }
}
