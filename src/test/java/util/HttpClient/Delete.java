package util.HttpClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static util.HttpClient.HttpClient.getHttpClient;
public class Delete {
    public static HttpResponse<String> delete(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .DELETE()
                .build();

        return getHttpClient().send(request,
                HttpResponse.BodyHandlers.ofString());
    }
}
