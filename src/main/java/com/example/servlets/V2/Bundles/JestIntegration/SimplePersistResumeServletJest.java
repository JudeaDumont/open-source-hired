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

import static com.example.servlets.V2.Bundles.Production.SimplePersistResumeBundleServlet.simpleResumePersistInjectable;


@Path("api/v1/resumeBundle/jest")
public class SimplePersistResumeServletJest {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public SimplePersistResumeServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }


    @POST
    @Path("persist")
    public static String[] simplePersist(
            @FormDataParam("content") String content,
            @FormDataParam("bundleName") String bundleName
    ) {
        return simpleResumePersistInjectable(
                bundleName,
                content,
                bundleService
        );
    }
}