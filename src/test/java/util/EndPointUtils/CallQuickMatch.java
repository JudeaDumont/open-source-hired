package util.EndPointUtils;

import com.example.model.MatchBundle.MatchBundleV2;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;

import static com.example.model.MatchBundle.MatchBundleMembers.MatchBundleJson.getMatchBundleFromJson;
import static util.HttpClient.PostMultipartFormData.postMultipartFormData;

public class CallQuickMatch {

    private static final String urlQuickMatch =
            AppYamlManager.getTestingUrl() + "9998" + "/api/v1/match";

    public static MatchBundleV2 getQuickMatch(String jdPlainText, String rPlainText) throws IOException, InterruptedException {
        MatchBundleV2 matchBundleV2;

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "jdPlainText",
                jdPlainText
        );
        builder.addTextBody(
                "rPlainText",
                rPlainText
        );

        HttpEntity httpEntity = postMultipartFormData(
                urlQuickMatch,
                builder);

        matchBundleV2 =
                getMatchBundleFromJson(
                        httpEntity.getContent().readAllBytes()
                );
        return matchBundleV2;
    }
}
