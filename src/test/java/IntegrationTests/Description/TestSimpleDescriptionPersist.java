package IntegrationTests.Description;

import org.junit.jupiter.api.*;
import util.JerseyTestWrapper;

import java.io.IOException;

import static util.EndPointUtils.CallDeleteDescription.delDescription;
import static util.EndPointUtils.CallKeyPoolConfigurationEndPoint.CallLoadPinnedKeyPool12212023.callLoadPinnedKeyPool12212023;
import static util.EndPointUtils.CallSimplePersistDescriptionEndPoint.callSimpleDescriptionPersistEndPoint;


//SingleMatchWithBadGrammer of those rare instances where I need two tests to be bundles together for a
// more complete integration test. this is why not having partial classes is a java annoyance.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestSimpleDescriptionPersist extends JerseyTestWrapper {
    @Test
    @Order(1)
    void TestSimpleDescriptionPersistX() throws IOException, InterruptedException {
        try {
            callLoadPinnedKeyPool12212023();
            String s = callSimpleDescriptionPersistEndPoint(
                    "testX", "testX resume plaintext only");
            assert (s.equals("[\"testX resume plaintext only\"]"));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            delDescription("testX");
        }
    }
}
