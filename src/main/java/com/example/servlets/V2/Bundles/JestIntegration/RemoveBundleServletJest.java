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
import java.util.ArrayList;

import static com.example.servlets.V2.Bundles.Production.RemoveBundleServlet.removeBundleInjectable;

@Path("api/v1/keywordchecker/jest")
public class RemoveBundleServletJest {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public RemoveBundleServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("removeBundle")
    public static ArrayList<Long> removeBundle(
            @FormDataParam("bundleName") String bundleName) {
        return removeBundleInjectable(bundleName, bundleService);
    }
}
