package z.util.FileIO.Bundle;

import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import z.util.BundleFIleWriter.WriteBundleFilesAndJobDescription;

import java.io.File;

import static z.util.BundleFIleWriter.CreateBundlePath.createBundlePath;
import static z.util.BundleFIleWriter.DeleteDir.deleteDir;

public class RemoveAssociatedBundleDirectory {
    public static void removeDir(ResumeBundlePersist resumeBundlePersist) {
        //Get the name of the bundle directory
        String bundlePath = createBundlePath(
                resumeBundlePersist.getName(),
                resumeBundlePersist.getJobDescriptionGuid() != null ?
                        resumeBundlePersist.getJobDescriptionGuid().toString() :
                        resumeBundlePersist.getWordGuid() != null ?
                                resumeBundlePersist.getWordGuid().toString() :
                                resumeBundlePersist.getPdfGuid() != null ?
                                        resumeBundlePersist.getPdfGuid().toString() :
                                        resumeBundlePersist.getPlainTextGuid() != null ?
                                                resumeBundlePersist.getPlainTextGuid().toString() :
                                                ""
        );
        //check if the dir exists, and remove it
        File file = new File(bundlePath);
        if (file.isDirectory()) {
            deleteDir(file);
        }
    }
}
