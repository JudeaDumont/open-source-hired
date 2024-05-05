package z.util.AppYamlManager;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.util.Map;

public class GetDecrypted extends AppYamlManagerMembers {
    protected static String getDecrypted(StandardPBEStringEncryptor decryptor,
                                       Map<String, Map<String, Map<String, String>>> data,
                                       String first,
                                       String second) {
        return decryptor.decrypt(data.get("app").get(first).get(second).
                replace("ENC(", "").replace(")", ""));
    }
}
