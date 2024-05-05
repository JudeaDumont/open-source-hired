package com.example.servlets.V2.Bundles.JestIntegration;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.example.servlets.V2.Bundles.Production.PersistResumeBundleServlet.persistResumeBundleInjectable;


@Path("api/v1/keywordchecker/jest")
public class PersistResumeBundleServletJest {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public PersistResumeBundleServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }


    @POST
    @Path("persistResumeBundle")
    public static String[] persistResumeBundleX(
            @FormDataParam("plainText") String plainText,
            @FormDataParam("bundleName") String bundleName
    ) {
        InputStream plainTextStream = new ByteArrayInputStream(plainText.getBytes(StandardCharsets.UTF_8));

        try {
            persistResumeBundleInjectable(
                    plainTextStream,
                    null, null, null,
                    bundleName,
                    bundleService
            );
            return new String[]{plainText};
        } catch (IOException e) {
            return new String[]{plainText, "ERROR: " + e};
        }
    }
}