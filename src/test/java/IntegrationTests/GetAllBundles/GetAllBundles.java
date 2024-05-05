package IntegrationTests.GetAllBundles;

import org.junit.jupiter.api.*;
import util.JerseyTestWrapper;

import java.io.IOException;
import java.util.Objects;

import static util.EndPointUtils.CallGetAllBundleEndPoint.getAllBundles;


//SingleMatchWithBadGrammer of those rare instances where I need two tests to be bundles together for a
// more complete integration test. this is why not having partial classes is a java annoyance.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestGetAllBundles extends JerseyTestWrapper {

    @Test
    @Order(1)
    void TestGetAllBundlesEmpty() throws IOException, InterruptedException {
        String allBundles = getAllBundles();
        assert (Objects.equals(allBundles, "[]"));
    }
}
