package com.example.model.JobDescriptionUnderstanding;

import com.example.model.Response;

import java.util.Map;

import static com.example.model.Response.getOk;
import static java.time.LocalDateTime.now;

public class ResponseEntity {
    public static org.springframework.http.ResponseEntity<Response> getJobDescriptionUnderstanding(String jobDescriptionPlainText) {
        JobDescriptionUnderstanding jobDescriptionUnderstanding =
                new JobDescriptionUnderstanding(jobDescriptionPlainText);
        return getOk(
                Map.of("JobDescriptionUnderstanding",
                        jobDescriptionUnderstanding.toJson()
                ),
                "Success");
    }

}
