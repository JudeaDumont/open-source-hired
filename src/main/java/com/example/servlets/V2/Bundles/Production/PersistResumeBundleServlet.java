package com.example.servlets.V2.Bundles.Production;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;
import java.io.InputStream;

import static com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersistLogic.persistBundleReturnPlainText;


@Path("api/v1/keywordchecker")
public class PersistResumeBundleServlet {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public PersistResumeBundleServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("persistResumeBundle")
    public static String[] persistResumeBundle(
            @FormDataParam("plainText") InputStream plainTextStream,
            @FormDataParam("plainText") FormDataContentDisposition plainTextMetaData,
            @FormDataParam("pdf") InputStream pdfStream,
            @FormDataParam("pdf") FormDataContentDisposition pdfTextMetaData,
            @FormDataParam("odt") InputStream odtStream,
            @FormDataParam("odt") FormDataContentDisposition odtTextMetaData,
            @FormDataParam("jobDescription") InputStream jobDescriptionStream,
            @FormDataParam("jobDescription") FormDataContentDisposition jobDescriptionData,
            @FormDataParam("bundleName") String bundleName
    ) throws IOException {
        return persistResumeBundleInjectable(
                plainTextStream,
                pdfStream,
                odtStream,
                jobDescriptionStream,
                bundleName,
                bundleService
        );
    }

    public static String[] persistResumeBundleInjectable(
            InputStream plainTextStream,
            InputStream pdfStream,
            InputStream odtStream,
            InputStream jobDescriptionStream,
            String bundleName,
            BundleService bundleService
    ) throws IOException {
        try {
            return
                    new String[]{
                            persistBundleReturnPlainText(plainTextStream,
                                    pdfStream,
                                    odtStream,
                                    jobDescriptionStream,
                                    bundleName,
                                    bundleService.getBundleDao())};
        } catch (IOException e) {
            return new String[]{e.getMessage()};
        }
    }
}