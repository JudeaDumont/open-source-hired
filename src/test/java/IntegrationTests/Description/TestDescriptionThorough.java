package IntegrationTests.Description;

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
class TestDescriptionThorough {

    @Test
    @Order(6)
    void t() throws DuplicatePrimaryKeyException {
        DescriptionService descriptionService = new DescriptionService(new PostgreSqlDescriptionDaoService(new JdbcTemplate(PostgresDataSource.getDataSource())));

        DescriptionPersist resumeDescriptionPersist = new DescriptionPersist(
                null,
                "test",
                ""
        );
        int descriptionId = descriptionService.update(resumeDescriptionPersist);
        DescriptionPersist resumeDescriptionPersist1 = descriptionService.get(resumeDescriptionPersist.getId());
        assert (descriptionId != 0);
        assert (resumeDescriptionPersist1 != null);
        resumeDescriptionPersist1.setName("jeff");
        descriptionService.update(resumeDescriptionPersist1);

        DescriptionPersist resumeDescriptionPersist2 = descriptionService.get(resumeDescriptionPersist.getId());
        assert (Objects.equals(resumeDescriptionPersist2.getName(), "jeff"));

        DescriptionPersist resumeDescriptionPersist3 = new DescriptionPersist(
                null,
                "jeff",
                ""
        );

        descriptionService.update(resumeDescriptionPersist3);

        descriptionService.delete(resumeDescriptionPersist3);
    }
}
