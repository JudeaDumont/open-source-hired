package util.EndPointUtils;

import com.example.model.MatchBundle.MatchBundleV2;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import static util.E.UnitTestUtil.MockFindBestMatch.SortMatches.sortMatches;
import static util.HttpClient.PostMultipartFormData.postMultipartFormData;

public class CallFindBestMatch {

    private static final String keywordCheckerAPIPath = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/keywordchecker/";

    public static ArrayList<MatchBundleV2> findBestMatch(
            String jdPlainText
    ) throws IOException, InterruptedException {

        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        builder.addTextBody(
                "jdPlainText",
                jdPlainText
        );
        HttpEntity httpEntity = postMultipartFormData(keywordCheckerAPIPath + "findBestMatch", builder);
        byte[] bytes = httpEntity.getContent().readAllBytes();
        String text = new String(bytes, StandardCharsets.UTF_8);

        assert (!text.isEmpty());

        ArrayList<MatchBundleV2> resultsMatchBundles = new ArrayList<>();
        Gson gson = new Gson();
        ArrayList<String> ArrayOfMatchBundleV2Strings = gson.fromJson(text, new TypeToken<ArrayList<String>>() {
        }.getType());
        for (String arrayOfMatchBundleV2String : ArrayOfMatchBundleV2Strings) {
            MatchBundleV2 matchBundleV2 = MatchBundleV2.fromJson(arrayOfMatchBundleV2String);
            resultsMatchBundles.add(matchBundleV2);
        }

        assert (!resultsMatchBundles.isEmpty());

        sortMatches(resultsMatchBundles);

        return resultsMatchBundles;
    }
}
