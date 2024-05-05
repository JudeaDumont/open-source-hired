package util.EndPointUtils;

import org.apache.http.HttpEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import util.HttpClient.PostMultipartFormData;
import z.util.AppYamlManager.AppYamlManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CallPersistBundleEndPoint {
    private static final String keywordCheckerAPIPath = AppYamlManager.getTestingUrl() + "9998" + "/api/v1/keywordchecker/";

    public static String callPersistBundle(
            String bundleName,
            String pathToBundleDir
    ) throws IOException, InterruptedException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String pathToBundleFiles = pathToBundleDir + "/" + bundleName;
        try (InputStream plainText = classLoader.getResourceAsStream(pathToBundleFiles + "/txt.txt")) {
            try (InputStream odt = classLoader.getResourceAsStream(pathToBundleFiles + "/odt.odt")) {
                try (InputStream pdf = classLoader.getResourceAsStream(pathToBundleFiles + "/pdf.pdf")) {

                    MultipartEntityBuilder builder = MultipartEntityBuilder.create();
                    builder.addBinaryBody(
                            "plainText",
                            plainText,
                            ContentType.APPLICATION_OCTET_STREAM,
                            "txt.txt"
                    );
                    builder.addBinaryBody(
                            "pdf",
                            pdf,
                            ContentType.APPLICATION_OCTET_STREAM,
                            "pdf.pdf"
                    );
                    builder.addBinaryBody(
                            "odt",
                            odt,
                            ContentType.APPLICATION_OCTET_STREAM,
                            "odt.odt"
                    );
                    builder.addTextBody(
                            "bundleName",
                            bundleName
                    );

                    HttpEntity httpEntity = PostMultipartFormData
                            .postMultipartFormData(keywordCheckerAPIPath + "persistResumeBundle", builder);
                    byte[] bytes = httpEntity.getContent().readAllBytes();
                    String text = new String(bytes, StandardCharsets.UTF_8);
                    return text;
                }
            }
        }
    }
}
