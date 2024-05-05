package UnitTests.BasicRESTResume;

import com.example.databasedrivers.postgres.datasource.PostgresDataSource;
import com.example.databasedrivers.postgres.services.resume.BundleService;
import com.example.databasedrivers.postgres.services.resume.PostgreSqlBundleDaoService;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.jdbc.core.JdbcTemplate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestBundleServiceSaveReturnID {

    @Test
    @Order(6)
    void t() {
        BundleService bundleService = new BundleService(new PostgreSqlBundleDaoService(new JdbcTemplate(PostgresDataSource.getDataSource())));

        ResumeBundlePersist resumeBundlePersist = new ResumeBundlePersist();
        resumeBundlePersist.setName("test");
        Long bundleId = bundleService.saveReturnID(resumeBundlePersist);
        assert (bundleId != 0);
        bundleService.delete(resumeBundlePersist);
    }
}
