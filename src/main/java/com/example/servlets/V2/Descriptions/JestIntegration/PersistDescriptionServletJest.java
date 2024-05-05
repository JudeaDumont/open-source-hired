package com.example.servlets.V2.Descriptions.JestIntegration;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.description.DescriptionService;
import com.example.databasedrivers.postgres.services.description.PostgreSqlDescriptionDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.io.IOException;

import static com.example.servlets.V2.Descriptions.Production.PersistDescriptionServlet.persistDescriptionInjectable;


@Path("api/v1/description/jest")
public class PersistDescriptionServletJest {

    private static final DescriptionService descriptionService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public PersistDescriptionServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }


    @POST
    @Path("persist")
    public static String[] persistDescriptionDescriptionX(
            @FormDataParam("content") String content,
            @FormDataParam("descriptionName") String descriptionName
    ) {
        try {
            persistDescriptionInjectable(
                    content,
                    descriptionName,
                    descriptionService
            );
            return new String[]{content};
        } catch (IOException e) {
            return new String[]{content, "ERROR: " + e};
        }
    }
}