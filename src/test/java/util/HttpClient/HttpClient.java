package util.HttpClient;

public class HttpClient {

    private static java.net.http.HttpClient client = null;

    private HttpClient() {
    }

    static java.net.http.HttpClient getHttpClient() {
        if (client == null) {
            client = java.net.http.HttpClient.newHttpClient();
        }
        return client;
    }
}
