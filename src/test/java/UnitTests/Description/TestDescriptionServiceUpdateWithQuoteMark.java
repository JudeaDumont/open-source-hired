package UnitTests.Description;

import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.description.DescriptionService;
import com.example.databasedrivers.postgres.services.description.PostgreSqlDescriptionDaoService;
import com.example.model.Description.DescriptionPersist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDescriptionServiceUpdateWithQuoteMark {
    @Test
    @Order(6)
    void t() throws DuplicatePrimaryKeyException {
        DescriptionService DescriptionService = new DescriptionService(new PostgreSqlDescriptionDaoService(new JdbcTemplate(PostgresDataSource.getDataSource())));

        DescriptionPersist DescriptionPersist = new DescriptionPersist(
                null,
                "test'",
                "text 'to match"
        );
        Long bundleId = DescriptionService.saveReturnID(DescriptionPersist);
        DescriptionPersist DescriptionPersist1 = DescriptionService.get(DescriptionPersist.getId());
        assert (bundleId != 0);
        assert (DescriptionPersist1 != null);
        assert (Objects.equals(DescriptionPersist1.getName(), "test'"));
        assert (Objects.equals(DescriptionPersist1.getContent(), "text 'to match"));
        DescriptionPersist1.setName("jeff'");
        DescriptionPersist1.setContent("jeff 'to match");
        DescriptionService.update(DescriptionPersist1);
        DescriptionPersist DescriptionPersist2 = DescriptionService.get(DescriptionPersist.getId());
        assert (Objects.equals(DescriptionPersist2.getName(), "jeff'"));
        assert (Objects.equals(DescriptionPersist2.getContent(), "jeff 'to match"));
        DescriptionService.delete(DescriptionPersist2);
    }
}
