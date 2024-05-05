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
import java.util.ArrayList;

import static com.example.servlets.V2.Descriptions.Production.RemoveDescriptionServlet.removeDescriptionInjectable;

@Path("api/v1/keywordchecker/jest")
public class RemoveDescriptionServletJest {

    private static final DescriptionService descriptionService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public RemoveDescriptionServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @POST
    @Path("removeDescription")
    public static ArrayList<Long> removeDescription(
            @FormDataParam("descriptionName") String descriptionName) {
        return removeDescriptionInjectable(descriptionName, descriptionService);
    }
}
