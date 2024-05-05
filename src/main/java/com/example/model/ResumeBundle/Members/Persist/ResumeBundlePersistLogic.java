package com.example.model.ResumeBundle.Members.Persist;

import com.example.databasedrivers.BundleDao;
import z.util.BundleFIleWriter.WriteBundleFilesAndJobDescription;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.AccessDeniedException;
import java.util.UUID;

import static z.util.BundleFIleWriter.CreateBundlePath.createBundlePath;

public class ResumeBundlePersistLogic {
    public static String persistBundleReturnPlainText(
            InputStream plainTextStream,
            InputStream pdfStream,
            InputStream odtStream,
            InputStream jobDescriptionStream,
            String bundleName,
            BundleDao<ResumeBundlePersist, Long> bundleDao) throws IOException {
        String plainText =
                null;
        ResumeBundlePersist resumeBundlePersist = null;
            FileBundle fileBundle = new FileBundle();
            UUID uuid = UUID.randomUUID();
            String uuidString = uuid.toString().replace("{", "").replace("}", "");
            fileBundle.setPdfGuid(uuid);
            fileBundle.setWordGuid(uuid);

            //Write the bundle files "alongside" the database entry

            String bundlePath = createBundlePath(bundleName, uuidString);

        try {
            plainText = WriteBundleFilesAndJobDescription.writeBundleFilesAndJobDescription(plainTextStream, pdfStream, odtStream, jobDescriptionStream, fileBundle, bundlePath, uuidString);
        } catch (AccessDeniedException a) {
            System.err.println("ERROR: " + a);
        }

        resumeBundlePersist = new ResumeBundlePersist(fileBundle, bundleName, uuid);

        bundleDao.save(resumeBundlePersist);

        return plainText;
    }
}
