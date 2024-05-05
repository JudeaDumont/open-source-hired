package z.util.FileIO;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class FilesFromResourceDirectory {
    public static ArrayList<String> getFiles(String resourcesDir) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        ArrayList<String> filesToLoad = new ArrayList<>();
        URL resource = classLoader.getResource(resourcesDir);
        assert (resource != null);
        try (
                InputStream input = resource.openStream()
        ) {
            assert input != null;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(input))
            ) {
                {
                    String fileName;

                    while ((fileName = br.readLine()) != null) {
                        String nestedPath = resourcesDir + "/" + fileName;
                        URL potentialDir = classLoader.getResource(nestedPath);
                        assert potentialDir != null;
                        String pathToPotentialDir = potentialDir.getPath();
                        File filePotentialDir = new File(pathToPotentialDir);
                        if (filePotentialDir.isDirectory()) {
                            filesToLoad.addAll(getFiles(nestedPath));
                        } else {
                            filesToLoad.add(nestedPath);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return filesToLoad;
    }
}
