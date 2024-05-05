package UnitTests.YamlManager;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import z.util.AppYamlManager.AppYamlManager;

import java.util.Map;
import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestYamlParser {

    @Test
    @Order(1)
    void test_yamlparser() {

        Map<String, String> postgreDataSource =
                AppYamlManager.getPostgresDataSource();
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-production.jdbc-url"), "jdbc:postgresql://postgres:5432/proddb"));
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-testing.username"), "postgres"));
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-testing.jdbc-url"), "jdbc:postgresql://postgres:5432/testdb"));
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-production.password"), "root"));
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-testing.password"), "root"));
        assert(Objects.equals(
                postgreDataSource.get("app.datasource-production.username"), "postgres"));
    }
}
