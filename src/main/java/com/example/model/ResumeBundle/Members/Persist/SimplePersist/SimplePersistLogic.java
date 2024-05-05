package com.example.model.ResumeBundle.Members.Persist.SimplePersist;

import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;

import java.io.IOException;

public class SimplePersistLogic {
    public static String simplePersistLogic(
            String bundleName,
            String content,
            BundleService bundleDao) throws IOException, DuplicatePrimaryKeyException {

        ResumeBundlePersist resumeBundlePersist = new ResumeBundlePersist(content, bundleName);

        bundleDao.update(resumeBundlePersist);
        return content;
    }
}
