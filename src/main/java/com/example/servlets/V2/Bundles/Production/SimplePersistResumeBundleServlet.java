package com.example.servlets.V2.Bundles.Production;

import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;

import static com.example.model.ResumeBundle.Members.Persist.SimplePersist.SimplePersistLogic.simplePersistLogic;


@Path("api/v1/resumeBundle")
public class SimplePersistResumeBundleServlet {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public SimplePersistResumeBundleServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("persist")
    public static String[] simpleResumePersist(
            @FormDataParam("bundleName") String bundleName,
            @FormDataParam("content") String content
    ) {
        return simpleResumePersistInjectable(
                bundleName,
                content,
                bundleService
        );
    }

    public static String[] simpleResumePersistInjectable(
            String bundleName,
            String content,
            BundleService bundleService
    ) {
        try {
            return
                    new String[]{
                            simplePersistLogic(
                                    bundleName,
                                    content,
                                    bundleService)};
        } catch (IOException e) {
            return new String[]{e.getMessage()};
        } catch (DuplicatePrimaryKeyException e) {
            throw new RuntimeException(e);
        }
    }
}