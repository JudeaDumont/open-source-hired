package z.util.AppYamlManager;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class LoadYamlFile extends LoadAppSettings {
    protected void loadYamlFile() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = classLoader.getResourceAsStream("application.yaml")) {
            Yaml yaml = new Yaml();
            Map<String, Map<String, Map<String, String>>> data = yaml.load(
                    input
            );
            StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();

            String jasyptEncryptorPasswordFromNotTomcat = System.getenv("JASYPT_ENCRYPTOR_PASSWORD");
            if (jasyptEncryptorPasswordFromNotTomcat == null || jasyptEncryptorPasswordFromNotTomcat.isEmpty()) {
                jasyptEncryptorPasswordFromNotTomcat = System.getProperty("JASYPT_ENCRYPTOR_PASSWORD");
            }

            decryptor.setPassword(jasyptEncryptorPasswordFromNotTomcat);
            loadPostgresDataSource(decryptor, data);
            loadAppSettings(decryptor, data);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
