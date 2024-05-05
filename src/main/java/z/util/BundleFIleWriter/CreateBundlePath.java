package z.util.BundleFIleWriter;

public class CreateBundlePath {

    public static String createBundlePath(String bundleName, String uuidString) {
        return "./Bundles/bundle-" + bundleName + "-" + uuidString + "/";
    }
}
