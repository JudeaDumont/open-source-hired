package util.EndPointUtils;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import util.HttpClient.HttpClient;
import util.HttpClient.PostMultipartFormData;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CallSimplePersistEndPoint {
    private static final String simplePersistURL = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/resumeBundle/";

    public static String callSimpleResumePersistEndPoint(
            String bundleName,
            String content
    ) throws IOException, InterruptedException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "bundleName",
                bundleName
        );
        builder.addTextBody(
                "content",
                content
        );

        HttpEntity httpEntity = PostMultipartFormData
                .postMultipartFormData(simplePersistURL + "persist", builder);
        byte[] bytes = httpEntity.getContent().readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
