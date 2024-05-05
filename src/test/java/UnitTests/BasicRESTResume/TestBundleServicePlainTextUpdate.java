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

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestBundleServicePlainTextUpdate {

    @Test
    @Order(6)
    void t() throws DuplicatePrimaryKeyException {
        BundleService bundleService = new BundleService(new PostgreSqlBundleDaoService(new JdbcTemplate(PostgresDataSource.getDataSource())));

        ResumeBundlePersist resumeBundlePersist = new ResumeBundlePersist(
                "test text",
                "test"
        );
        bundleService.update(resumeBundlePersist);
        assert (resumeBundlePersist.getId() != null);

        //Make sure its there and has the correct name and plaintext
        ResumeBundlePersist noChange = bundleService.get(resumeBundlePersist.getId());
        assert (Objects.equals(noChange.getName(), "test"));
        assert (Objects.equals(noChange.getPlainTextToMatch(), "test text"));

        //Now remove the ID and update with new plaintext
        resumeBundlePersist.setId(null);
        resumeBundlePersist.setPlainTextToMatch("test text changed by name");
        bundleService.update(resumeBundlePersist);
        assert (resumeBundlePersist.getId() != null);
        ResumeBundlePersist changeByName = bundleService.get(resumeBundlePersist.getId());
        assert (Objects.equals(changeByName.getName(), "test"));
        assert (Objects.equals(changeByName.getPlainTextToMatch(), "test text changed by name"));

        //Name and plain text changed by ID
        resumeBundlePersist.setName("testy");
        resumeBundlePersist.setPlainTextToMatch("test text changed by ID");
        bundleService.update(resumeBundlePersist);
        ResumeBundlePersist changeByID = bundleService.get(resumeBundlePersist.getId());
        assert (Objects.equals(changeByID.getName(), "testy"));
        assert (Objects.equals(changeByID.getPlainTextToMatch(), "test text changed by ID"));

        bundleService.delete(resumeBundlePersist);
    }
}
