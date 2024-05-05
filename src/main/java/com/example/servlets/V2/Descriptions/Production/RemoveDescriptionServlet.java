package com.example.servlets.V2.Descriptions.Production;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.description.DescriptionService;
import com.example.databasedrivers.postgres.services.description.PostgreSqlDescriptionDaoService;
import com.example.model.Description.DescriptionPersist;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("api/v1/keywordchecker")
public class RemoveDescriptionServlet {

    private static final DescriptionService descriptionService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public RemoveDescriptionServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("removeDescription")
    public static ArrayList<Long> removeDescription(
            @FormDataParam("descriptionName") String descriptionName) {
        return removeDescriptionInjectable(descriptionName, descriptionService);
    }
    public static ArrayList<Long> removeDescriptionInjectable(
            String descriptionName,
            DescriptionService descriptionService) {

        List<DescriptionPersist> byName = descriptionService.getByName(descriptionName);
        ArrayList<Long> ids = new ArrayList<>();
        for (DescriptionPersist resumeDescriptionPersist : byName) {
            ids.add(resumeDescriptionPersist.getId());
            descriptionService.delete(resumeDescriptionPersist);
        }

        return ids;
    }
}
