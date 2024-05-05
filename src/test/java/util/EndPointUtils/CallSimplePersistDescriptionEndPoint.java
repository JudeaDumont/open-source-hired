package util.EndPointUtils;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import util.HttpClient.PostMultipartFormData;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CallSimplePersistDescriptionEndPoint {

    private static final String simpleDescriptionPersistURL = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/description/";

    public static String callSimpleDescriptionPersistEndPoint(
            String descriptionName,
            String content
    ) throws IOException, InterruptedException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "descriptionName",
                descriptionName
        );
        builder.addTextBody(
                "content",
                content
        );

        HttpEntity httpEntity = PostMultipartFormData
                .postMultipartFormData(simpleDescriptionPersistURL + "persist", builder);
        byte[] bytes = httpEntity.getContent().readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
