package z.util.AppYamlManager;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Map;

public class LoadAppSettings extends LoadPostgresDataSource {

    protected void loadAppSettings(StandardPBEStringEncryptor decryptor, Map<String, Map<String, Map<String, String>>> data) {
        testingUrl = getDecrypted(decryptor, data, "testing", "base-url");
    }
}
