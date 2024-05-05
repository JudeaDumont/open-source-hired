package com.example.servlets.V2;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.JobBundle.JobBundle;
import com.example.model.MatchBundle.MatchBundleV2;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import com.example.model.ResumeBundle.ResumeBundle;
import com.google.gson.Gson;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import static com.example.model.JobBundle.Members.PlainText.jobBundleFromVaguePlainText;
import static com.example.model.KeyPhrasePuller.FavoriteTechPreprocessor.pickFavoriteTechWords;
import static com.example.model.ResumeBundle.Members.PlainText.resumeFromPlainText;
import static z.util.BundleFIleWriter.CreateBundlePath.createBundlePath;
import static z.util.FileIO.ReadFileAsString.readFileAsString;


@Path("api/v1/keywordchecker")
public class FindBestMatchServlet {

    private final BundleService bundleService;

    public FindBestMatchServlet() {
        this.bundleService = new BundleService(
                new PostgreSqlBundleDaoService(
                        new JdbcTemplate(
                                PostgresDataSource.getDataSource())));
    }

    private static String getJson(ArrayList<String> jsonBundles) {
        Gson gson = new Gson();
        String json = gson.toJson(jsonBundles);
        return json;
    }

    private static ArrayList<String> getJsonBundles(ArrayList<MatchBundleV2> matchBundles) {
        ArrayList<String> jsonBundles = new ArrayList<>();
        for (MatchBundleV2 matchBundle : matchBundles) {
            String json = matchBundle.toJson();
            jsonBundles.add(json);
        }
        return jsonBundles;
    }

    private static ArrayList<MatchBundleV2> getMatchBundleV2s(ArrayList<ResumeBundle> resumeBundles, JobBundle jobBundle) {
        ArrayList<MatchBundleV2> matchBundles = new ArrayList<>();
        for (ResumeBundle resumeBundle : resumeBundles) {
            MatchBundleV2 matchBundleV2 = new MatchBundleV2(jobBundle, resumeBundle);
            matchBundles.add(matchBundleV2);
        }
        return matchBundles;
    }

    private static ArrayList<ResumeBundle> getResumeBundles(ArrayList<String> resumeFilesAsStrings) {
        ArrayList<ResumeBundle> resumeBundles = new ArrayList<>();
        for (String resumeFilesAsString : resumeFilesAsStrings) {
            resumeBundles.add(resumeFromPlainText(resumeFilesAsString));
        }
        return resumeBundles;
    }

    private static ArrayList<String> getResumeFilesAsStrings(Collection<ResumeBundlePersist> all) throws FileNotFoundException {
        ArrayList<String> resumeFilesAsStrings = new ArrayList<>();
        for (ResumeBundlePersist resumeBundlePersist : all) {
            String bundlePath = createBundlePath(resumeBundlePersist.getName(), resumeBundlePersist.getPlainTextGuid().toString());
            bundlePath += "txt.txt";
            String fileAsString = readFileAsString(bundlePath);
            resumeFilesAsStrings.add(fileAsString);
        }
        return resumeFilesAsStrings;
    }

    @POST
    @Path("findBestMatch")
    public String findBestMatch(
            @FormDataParam("jdPlainText") String jdPlainText
    ) throws IOException {
        JobBundle jobBundle = jobBundleFromVaguePlainText(
                pickFavoriteTechWords(jdPlainText)
        );

        Collection<ResumeBundlePersist> all = bundleService.getAll();

        ArrayList<String> resumeFilesAsStrings = getResumeFilesAsStrings(all);

        ArrayList<ResumeBundle> resumeBundles = getResumeBundles(resumeFilesAsStrings);

        ArrayList<MatchBundleV2> matchBundles = getMatchBundleV2s(resumeBundles, jobBundle);

        ArrayList<String> jsonBundles = getJsonBundles(matchBundles);

        return getJson(jsonBundles);
    }
}
