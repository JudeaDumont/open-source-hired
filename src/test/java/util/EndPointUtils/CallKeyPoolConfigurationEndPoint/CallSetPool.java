package util.EndPointUtils.CallKeyPoolConfigurationEndPoint;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import util.HttpClient.PostMultipartFormData;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.KeyPoolConfigurationAPIPath.keyPoolConfigurationAPIPath;

public class CallSetPool {

    public static String callSetPool(String keyPoolJson) throws IOException, InterruptedException {
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "keyPool",
                keyPoolJson
        );

        HttpEntity httpEntity = PostMultipartFormData.postMultipartFormData(
                keyPoolConfigurationAPIPath + "set", builder);
        byte[] bytes = httpEntity.getContent().readAllBytes();

        return new String(bytes, StandardCharsets.UTF_8);
    }
}
