package util;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import javax.ws.rs.core.Application;

import static com.example.databasedrivers.postgres.datasource.PostgresDataSource.setDataSource;

public class JerseyTestWrapper extends JerseyTest {
    @Override
    protected Application configure() {
        setDataSource("datasource-testing");
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(JerseyTestWrapper.class)
                .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_SERVER, "ALL")
                .packages("com.example")
                .register(MultiPartFeature.class); // will get a "no injection site" error without this
    }
}
