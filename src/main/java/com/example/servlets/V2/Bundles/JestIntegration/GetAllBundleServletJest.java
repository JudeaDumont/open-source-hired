package com.example.servlets.V2.Bundles.JestIntegration;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;

import static com.example.servlets.V2.Bundles.Production.GetAllBundleServlet.getAllBundlesInjectable;

@Path("api/v1/keywordchecker/jest")
public class GetAllBundleServletJest {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public GetAllBundleServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @GET
    @Path("getAllBundles")
    public static ArrayList<String> getAllBundles() {
        return getAllBundlesInjectable(bundleService);
    }
}
