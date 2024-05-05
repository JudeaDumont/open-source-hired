package util.E.UnitTestUtil;

import Mocks.MockBundleDao;

import java.io.IOException;
import java.io.InputStream;

import static com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersistLogic.persistBundleReturnPlainText;

public class MockPersistBundle {
    public static String mockPersistBundle(String bundleName, String pathToBundleFiles) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream plainText = classLoader.getResourceAsStream(pathToBundleFiles + bundleName + "/txt.txt")) {
            try (InputStream odt = classLoader.getResourceAsStream(pathToBundleFiles + bundleName + "/odt.odt")) {
                try (InputStream pdf = classLoader.getResourceAsStream(pathToBundleFiles + bundleName + "/pdf.pdf")) {
                    return persistBundleReturnPlainText(
                            plainText,
                            pdf,
                            odt,
                            null,
                            bundleName,
                            MockBundleDao.getMockBundleDao() //does not hit a database, but should, using a static mock
                    );
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
