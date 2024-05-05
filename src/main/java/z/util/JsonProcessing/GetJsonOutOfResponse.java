package z.util.JsonProcessing;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;

public class GetJsonOutOfResponse {
    public static String getJsonOutOfResponse(byte[] responseJson) {
        Gson gson = new Gson();
        String text = new String(responseJson, StandardCharsets.UTF_8);
        JsonObject jsonObject = gson.fromJson(text, new TypeToken<JsonObject>() {
        }.getType());
        JsonObject body = gson.fromJson(jsonObject.get("body"), new TypeToken<JsonObject>() {
        }.getType());
        JsonObject data = gson.fromJson(body.get("data"), new TypeToken<JsonObject>() {
        }.getType());
        return gson.toJson(data);
    }
}
