package com.example.servlets.V2.Descriptions.Production;

import com.example.databasedrivers.DuplicatePrimaryKeyException;
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
import java.io.IOException;


@Path("api/v1/description")
public class PersistDescriptionServlet {

    private static final DescriptionService descriptionService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource())));

    public PersistDescriptionServlet() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("persist")
    public static String[] persistDescription(
            @FormDataParam("descriptionName") String descriptionName,
            @FormDataParam("content") String content
    ) throws IOException {
        return persistDescriptionInjectable(
                content,
                descriptionName,
                descriptionService
        );
    }

    public static String[] persistDescriptionInjectable(
            String content,
            String descriptionName,
            DescriptionService descriptionService
    ) throws IOException {
        try {
            DescriptionPersist descriptionPersist = new DescriptionPersist(null, descriptionName, content);
            int updates = descriptionService.update(descriptionPersist);
            return
                    new String[]{
                            content
                    };
        } catch (DuplicatePrimaryKeyException e) {
            return new String[]{
                    content, e.toString()
            };
        }
    }
}