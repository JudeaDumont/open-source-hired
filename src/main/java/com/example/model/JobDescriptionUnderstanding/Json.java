package com.example.model.JobDescriptionUnderstanding;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import static z.util.JsonProcessing.GetJsonOutOfResponse.getJsonOutOfResponse;

public class Json extends Members {
    public static JobDescriptionUnderstanding getJobDescriptionUnderstandingFromJson(byte[] bytes) {
        Gson gson = new Gson();
        String data = getJsonOutOfResponse(bytes);

        JsonObject dataJsonObject = gson.fromJson(data, new TypeToken<JsonObject>() {
        }.getType());

        String jobDescriptionUnderstandingString = dataJsonObject.get("JobDescriptionUnderstanding").getAsString();
        JobDescriptionUnderstanding jobDescriptionUnderstanding
                = gson.fromJson(jobDescriptionUnderstandingString, new TypeToken<JobDescriptionUnderstanding>() {
        }.getType());

        assert (jobDescriptionUnderstanding != null);
        return jobDescriptionUnderstanding;
    }

    protected String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
