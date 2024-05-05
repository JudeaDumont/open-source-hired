package UnitTests.BasicRESTResume;

import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Objects;
import java.util.UUID;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestBundleServiceUpdateWithQuoteMark {

    @Test
    @Order(6)
    void t() throws DuplicatePrimaryKeyException {
        BundleService bundleService = new BundleService(new PostgreSqlBundleDaoService(new JdbcTemplate(PostgresDataSource.getDataSource())));

        ResumeBundlePersist resumeBundlePersist = new ResumeBundlePersist(
                UUID.randomUUID(),
                "test'",
                ""
        );
        resumeBundlePersist.setPlainTextToMatch("text 'to match");
        Long bundleId = bundleService.saveReturnID(resumeBundlePersist);
        ResumeBundlePersist resumeBundlePersist1 = bundleService.get(resumeBundlePersist.getId());
        assert (bundleId != 0);
        assert (resumeBundlePersist1 != null);
        assert (Objects.equals(resumeBundlePersist1.getName(), "test'"));
        assert (Objects.equals(resumeBundlePersist1.getPlainTextToMatch(), "text 'to match"));
        resumeBundlePersist1.setName("jeff'");
        resumeBundlePersist1.setPlainTextToMatch("jeff 'to match");
        bundleService.update(resumeBundlePersist1);
        ResumeBundlePersist resumeBundlePersist2 = bundleService.get(resumeBundlePersist.getId());
        assert (Objects.equals(resumeBundlePersist2.getName(), "jeff'"));
        assert (Objects.equals(resumeBundlePersist2.getPlainTextToMatch(), "jeff 'to match"));
        bundleService.delete(resumeBundlePersist2);
    }
}
