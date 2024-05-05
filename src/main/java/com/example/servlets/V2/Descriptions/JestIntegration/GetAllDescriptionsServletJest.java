package com.example.servlets.V2.Descriptions.JestIntegration;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.description.DescriptionService;
import com.example.databasedrivers.postgres.services.description.PostgreSqlDescriptionDaoService;
import com.example.servlets.ServerConfiguration.CORSFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;

import static com.example.servlets.V2.Descriptions.Production.GetAllDescriptionServlet.getAllDescriptionsInjectable;

@Path("api/v1/keywordchecker/jest")
public class GetAllDescriptionsServletJest {

    private static final DescriptionService resumeService = new DescriptionService(
            new PostgreSqlDescriptionDaoService(
                    new JdbcTemplate(
                            PostgresDataSource.getDataSource("datasource-testing"))));

    public GetAllDescriptionsServletJest() {
        final ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(new CORSFilter());
    }

    @GET
    @Path("getAllDescriptions")
    public static ArrayList<String> getAllDescriptions() {
        return getAllDescriptionsInjectable(resumeService);
    }
}
