package IntegrationTests;

import util.JerseyTestWrapper;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import javax.ws.rs.core.Response;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestINTEGRATIONBasicJerseySanityCheck extends JerseyTestWrapper {

    @Test
    public void functional() {
        Response res = target("/api/v2/keypool/loadProdPool").request()
                .get();
        String content = res.readEntity(String.class);
        assert (Objects.equals(content, "Success"));
    }
}
