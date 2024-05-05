package com.example.servlets.V2;

import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchBundleV2;
import com.example.model.Response;
import com.example.model.ResumeBundle.ResumeBundle;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.http.ResponseEntity;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.Map;

import static com.example.model.JobBundle.Members.PlainText.jobBundleFromVaguePlainText;
import static com.example.model.KeyPhrasePuller.FavoriteTechPreprocessor.pickFavoriteTechWords;
import static com.example.model.Response.getOk;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;


@Path("api/v1/match")
public class _QuickMatchServlet {
    public _QuickMatchServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    public ResponseEntity<Response> _quickMatch(
            @FormDataParam("jdPlainText") String jdPlainText,
            @FormDataParam("rPlainText") String rPlainText
    ) {
         JobBundle jobBundle = jobBundleFromVaguePlainText(
                pickFavoriteTechWords(jdPlainText)
        );
        ResumeBundle resumeBundle = resumeFromPlainText(rPlainText);

        MatchBundleV2 matchBundleV2 = new MatchBundleV2(jobBundle, resumeBundle);

        return getOk(
                Map.of("match",
                        matchBundleV2.toJson()
                ),
                "Success");
    }
}
