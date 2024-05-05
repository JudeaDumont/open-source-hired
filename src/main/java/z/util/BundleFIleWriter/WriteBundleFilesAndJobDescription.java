package z.util.BundleFIleWriter;

import com.example.model.ResumeBundle.Members.Persist.FileBundle;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static z.util.BundleFIleWriter.WriteBundleFiles.writeBundleFiles;

public class WriteBundleFilesAndJobDescription {
    public static String writeBundleFilesAndJobDescription(InputStream plainTextStream,
                                                           InputStream pdfStream,
                                                           InputStream odtStream,
                                                           InputStream jobDescriptionStream,
                                                           FileBundle fileBundle,
                                                           String bundlePath,
                                                           String uuidString) throws IOException {
        String plainText = writeBundleFiles(plainTextStream, pdfStream, odtStream, fileBundle, bundlePath, uuidString);

        if (jobDescriptionStream != null) {
            byte[] jobDescriptionBytes = jobDescriptionStream.readAllBytes();
            FileOutputStream outjobDescription = new FileOutputStream(
                    bundlePath + "jobDescription-" +
                            uuidString
                            + ".txt");
            outjobDescription.write(jobDescriptionBytes);
            outjobDescription.close();
        }
        return plainText;
    }
}
