package z.util.AppYamlManager;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AppYamlManager extends LoadYamlFile {

    private AppYamlManager() {
        super();
        loadYamlFile();
    }

    public static Map<String, String> getPostgresDataSource() {
        return get().postgresDataSource;
    }

    public static String getTestingUrl() {
        return get().testingUrl;
    }

    public static AppYamlManager get() {
        if (self == null) {
            self = new AppYamlManager();
        }
        return self;
    }
}
