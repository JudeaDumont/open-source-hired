package util.EndPointUtils;

import com.example.model.JobDescriptionUnderstanding.JobDescriptionUnderstanding;
import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.io.InputStream;

import static com.example.model.JobDescriptionUnderstanding.Json.getJobDescriptionUnderstandingFromJson;
import static util.HttpClient.PostMultipartFormData.postMultipartFormData;
public class CallJobDescriptionUnderstanding {
    private static final String urlJobDescriptionUnderstanding =
            AppYamlManager.getTestingUrl() + "9998" + "/api/v1/extractor/" + "checkJobDescriptionUnderstanding";

    public static JobDescriptionUnderstanding getJobDescriptionUnderstanding(String resourcePath) throws IOException, InterruptedException {
        JobDescriptionUnderstanding jobDescriptionUnderstandingFromJson;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream jobDescription = classLoader.getResourceAsStream(
                resourcePath
        )) {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            builder.addBinaryBody(
                    "jobDescription",
                    jobDescription,
                    ContentType.APPLICATION_OCTET_STREAM,
                    "jobDescription.txt"
            );

            HttpEntity httpEntity = postMultipartFormData(
                    urlJobDescriptionUnderstanding,
                    builder);

            jobDescriptionUnderstandingFromJson =
                    getJobDescriptionUnderstandingFromJson(httpEntity.getContent().readAllBytes());
        }
        return jobDescriptionUnderstandingFromJson;
    }
}
