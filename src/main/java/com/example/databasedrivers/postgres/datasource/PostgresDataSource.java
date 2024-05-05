package com.example.databasedrivers.postgres.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Map;
import java.util.Properties;

import static z.util.AppYamlManager.AppYamlManager.getPostgresDataSource;

@Configuration
public class PostgresDataSource {
    private static final String DRIVER = "org.postgresql.Driver";

    private static String dataSourceName = null;

    public static void setDataSource(String dataSourceName) {
        PostgresDataSource.dataSourceName = dataSourceName;
        // This will take a string that will set a name
        // so that get datasource uses that name to look up the correct config
        // this method will be called by JerseyTestWrapper, and by the start and stop listener, and maybe that is it.
        // anything that invokes an entity that calls getDataSource should set it up.
    }
    public static DataSource getDataSource(String dataSourceName) {
        Map<String, String> postgreDataSource = getPostgresDataSource();
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PostgresDataSource.DRIVER);
        dataSource.setUrl(postgreDataSource.get("app." + dataSourceName + ".jdbc-url"));
        dataSource.setUsername(postgreDataSource.get("app." + dataSourceName + ".username"));
        dataSource.setPassword(postgreDataSource.get("app." + dataSourceName + ".password"));

        Properties connectionProperties = new Properties();
        dataSource.setConnectionProperties(connectionProperties);
        return dataSource;
    }

    public static DataSource getDataSource() {
        return getDataSource(getDataSourceName());
    }

    private static String getDataSourceName() {
        return dataSourceName == null ? "datasource-testing" : dataSourceName;
    }
}
