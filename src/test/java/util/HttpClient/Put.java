package util.HttpClient;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static util.HttpClient.HttpClient.getHttpClient;

public class Put {

    public static HttpResponse<String> put(String url, String contentBody) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .uri(URI.create(url))
                .PUT(HttpRequest.BodyPublishers.ofString(contentBody))
                .setHeader("content-type", MediaType.APPLICATION_JSON)
                .build();
        return getHttpClient().send(request,
                HttpResponse.BodyHandlers.ofString());
    }
}
