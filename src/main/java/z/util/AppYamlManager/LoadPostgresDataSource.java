package z.util.AppYamlManager;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Map;
public class LoadPostgresDataSource extends GetDecrypted {

    protected void loadPostgresDataSource(StandardPBEStringEncryptor decryptor, Map<String, Map<String, Map<String, String>>> data) {
        postgresDataSource.put("app.datasource-testing.jdbc-url", getDecrypted(decryptor, data, "datasource-testing", "jdbc-url"));
        postgresDataSource.put("app.datasource-testing.username", getDecrypted(decryptor, data, "datasource-testing", "username"));
        postgresDataSource.put("app.datasource-testing.password", getDecrypted(decryptor, data, "datasource-testing", "password"));

        postgresDataSource.put("app.datasource-production.jdbc-url", getDecrypted(decryptor, data, "datasource-production", "jdbc-url"));
        postgresDataSource.put("app.datasource-production.username", getDecrypted(decryptor, data, "datasource-production", "username"));
        postgresDataSource.put("app.datasource-production.password", getDecrypted(decryptor, data, "datasource-production", "password"));
    }
}
