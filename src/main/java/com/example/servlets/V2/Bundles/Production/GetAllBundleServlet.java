package com.example.servlets.V2.Bundles.Production;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collection;
@Path("api/v1/keywordchecker")
public class GetAllBundleServlet {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public GetAllBundleServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @GET
    @Path("getAllBundles")
    public static ArrayList<String> getAllBundles() {
        return getAllBundlesInjectable(bundleService);
    }

    public static ArrayList<String> getAllBundlesInjectable(BundleService bundleService) {

        Collection<ResumeBundlePersist> all = bundleService.getAll();
        ArrayList<String> bundles = new ArrayList<>();
        for (ResumeBundlePersist resumeBundlePersist : all) {
            String json = resumeBundlePersist.toJson();
            bundles.add(json);
        }

        return bundles;
    }
}
