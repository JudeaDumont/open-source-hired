package com.example.servlets.V2.Bundles.Production;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("api/v1/keywordchecker")
public class RemoveBundleServlet {

    private static final BundleService bundleService = new BundleService(
            new PostgreSqlBundleDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public RemoveBundleServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("removeBundle")
    public static ArrayList<Long> removeBundle(
            @FormDataParam("bundleName") String bundleName) {
        return removeBundleInjectable(bundleName, bundleService);
    }
    public static ArrayList<Long> removeBundleInjectable(
            String bundleName,
            BundleService bundleService) {

        List<ResumeBundlePersist> byName = bundleService.getByName(bundleName);
        ArrayList<Long> ids = new ArrayList<>();
        for (ResumeBundlePersist resumeBundlePersist : byName) {
            ids.add(resumeBundlePersist.getId());
            bundleService.delete(resumeBundlePersist);
        }

        return ids;
    }
}
