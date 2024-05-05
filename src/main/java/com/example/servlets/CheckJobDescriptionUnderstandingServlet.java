package com.example.servlets;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.InputStream;

import static com.example.model.JobDescriptionUnderstanding.ResponseEntity.getJobDescriptionUnderstanding;
import static z.util.FileIO.ReadInputStreamAsString.getStringFromInputStream;


@Path("api/v1/extractor")
public class CheckJobDescriptionUnderstandingServlet {

    private final BundleService bundleService;

    public CheckJobDescriptionUnderstandingServlet() {
        this.bundleService = new BundleService(
                new PostgreSqlBundleDaoService(
                        new JdbcTemplate(
                                PostgresDataSource.getDataSource())));
    }

    @POST
    @Path("checkJobDescriptionUnderstanding")
    public ResponseEntity<Response>
    checkJobDescriptionUnderstanding(
            @FormDataParam("jobDescription") InputStream jobDescriptionStream,
            @FormDataParam("jobDescription") FormDataContentDisposition jobDescriptionData) throws IOException {
        return getJobDescriptionUnderstanding(getStringFromInputStream(jobDescriptionStream));
    }
}
