package z.util.AppYamlManager;

import java.util.HashMap;
import java.util.Map;

public class AppYamlManagerMembers {
    protected static AppYamlManager self = null;
    protected final Map<String, String> postgresDataSource;

    protected String testingUrl;

    protected AppYamlManagerMembers() {
        postgresDataSource = new HashMap<>();
    }
}
