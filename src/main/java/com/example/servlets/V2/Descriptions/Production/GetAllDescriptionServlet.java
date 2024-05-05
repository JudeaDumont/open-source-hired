package com.example.servlets.V2.Descriptions.Production;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.description.DescriptionService;
import com.example.databasedrivers.postgres.services.description.PostgreSqlDescriptionDaoService;
import com.example.model.Description.DescriptionPersist;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Collection;
@Path("api/v1/keywordchecker")
public class GetAllDescriptionServlet {

    private static final DescriptionService descriptionService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public GetAllDescriptionServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @GET
    @Path("getAllDescriptions")
    public static ArrayList<String> getAllDescriptions() {
        return getAllDescriptionsInjectable(descriptionService);
    }

    public static ArrayList<String> getAllDescriptionsInjectable(DescriptionService descriptionService) {

        Collection<DescriptionPersist> all = descriptionService.getAll();
        ArrayList<String> bundles = new ArrayList<>();
        for (DescriptionPersist descriptionBundlePersist : all) {
            String json = descriptionBundlePersist.toJson();
            bundles.add(json);
        }

        return bundles;
    }
}
