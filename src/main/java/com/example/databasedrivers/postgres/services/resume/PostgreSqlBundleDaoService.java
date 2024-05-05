package com.example.databasedrivers.postgres.services.resume;

import com.example.databasedrivers.BundleDao;
import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.regex.Pattern;

import static com.example.databasedrivers.postgres.services.FormatSqlString.formatSqlString;
import static z.util.FileIO.Bundle.RemoveAssociatedBundleDirectory.removeDir;

@Repository("postgresBundle")
public class PostgreSqlBundleDaoService implements
        BundleDao<ResumeBundlePersist, Long> {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertIntoBundle;

    @Autowired
    public PostgreSqlBundleDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertIntoBundle = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Bundle")
                .usingGeneratedKeyColumns("id");
    }

    private static UUID getUUIDorNull(ResultSet resultSet, String stringToGUID) throws SQLException {
        String uuid = resultSet.getString(stringToGUID);
        return validateUUID(uuid) ? UUID.fromString(uuid) : new UUID(0, 0);
    }

    private static boolean validateUUID(String uuid) {//why do i have to do this myself? ugh
        return uuid != null && Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$")
                .matcher(uuid).matches();
    }

    private static Map<String, Object> dbParametersFromResumeBundle(ResumeBundlePersist ResumeBundlePersist) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", ResumeBundlePersist.getName());
        parameters.put("plainTextToMatch", ResumeBundlePersist.getPlainTextToMatch());
        parameters.put("plaintextguid", ResumeBundlePersist.getPlainTextGuid());
        parameters.put("pdfguid", ResumeBundlePersist.getPdfGuid());
        parameters.put("wordGuid", ResumeBundlePersist.getWordGuid());
        parameters.put("tieredMatchKeywords", ResumeBundlePersist.getTieredMatchKeywords());
        parameters.put("jobDescriptionGuid", ResumeBundlePersist.getJobDescriptionGuid());
        return parameters;
    }

    @Override
    public ResumeBundlePersist get(Long BundleID) throws DuplicatePrimaryKeyException {
        if (BundleID != null) {
            String getQuery = "SELECT * FROM Bundle WHERE id = " + BundleID;

            List<ResumeBundlePersist> bundlesMatchingID = jdbcTemplate.query(getQuery,
                    (resultSet, i) -> new ResumeBundlePersist(resultSet));
            if (bundlesMatchingID.size() == 1) {
                return bundlesMatchingID.get(0);
            } else if (bundlesMatchingID.isEmpty()) {
                return null;
            }
            throw new DuplicatePrimaryKeyException();
        }
        return null;
    }

    @Override
    public Collection<ResumeBundlePersist> getAll() {
        String getAllQuery = "SELECT * FROM Bundle";
        Gson gson = new Gson();

        return jdbcTemplate.query(getAllQuery, (resultSet, i) ->
        {
            UUID wordGuid = getUUIDorNull(resultSet, "wordGuid");
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String plainTextToMatch = resultSet.getString("plainTextToMatch");
            //String jobDescriptionName = resultSet.getString("jobDescriptionName");
            UUID pdfGuid = getUUIDorNull(resultSet, "pdfGuid");
            UUID plainTextGuid = getUUIDorNull(resultSet, "plainTextGuid");
            UUID jobDescriptionGuid = getUUIDorNull(resultSet, "jobDescriptionGuid");
            return new ResumeBundlePersist(
                    id,
                    name,
                    plainTextToMatch,
                    pdfGuid,
                    plainTextGuid,
                    wordGuid,
                    jobDescriptionGuid
            );
        });
    }

    @Override
    public int save(ResumeBundlePersist ResumeBundlePersist) {
        Gson gson = new Gson();
        String insertQuery = "insert into Bundle values(DEFAULT,'" +
                formatSqlString(ResumeBundlePersist.getName()) + "','" +
                formatSqlString(ResumeBundlePersist.getPlainTextToMatch()) + "','" +
                ResumeBundlePersist.getPdfGuid() + "','" +
                ResumeBundlePersist.getWordGuid() + "','" +
                ResumeBundlePersist.getPlainTextGuid() + "','" +
                formatSqlString(gson.toJson(ResumeBundlePersist.getTieredMatchKeywords())) + "','" +
                ResumeBundlePersist.getJobDescriptionGuid() +
                "')";
        return jdbcTemplate.update(insertQuery);
    }

    @Override
    public Long saveReturnID(ResumeBundlePersist ResumeBundlePersist) {
        final Map<String, Object> parameters = dbParametersFromResumeBundle(ResumeBundlePersist);
        Long generatedBundleId = (Long) insertIntoBundle.executeAndReturnKey(parameters);
        ResumeBundlePersist.setId(generatedBundleId);
        return generatedBundleId;
    }

    @Override
    public ArrayList<ResumeBundlePersist> getByName(String BundleName) {
        String getAllQuery = "SELECT * FROM Bundle WHERE name='" + formatSqlString(BundleName) + "' ";

        return (ArrayList<ResumeBundlePersist>) jdbcTemplate.query(getAllQuery, (resultSet, i) ->
                new ResumeBundlePersist(
                        resultSet
                ));
    }

    @Override
    public int update(ResumeBundlePersist ResumeBundlePersist) {
        String query =
                "update Bundle set " +
                        "name='" + formatSqlString(ResumeBundlePersist.getName()) + "', " +
                        "plaintexttomatch='" + formatSqlString(ResumeBundlePersist.getPlainTextToMatch()) +
                        "' where id='" + ResumeBundlePersist.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    @Override
    public int delete(ResumeBundlePersist resumeBundlePersist) {
        String query = "delete from Bundle where id='" + resumeBundlePersist.getId() + "' ";
        int update = jdbcTemplate.update(query);

        //part of removing the model from the database
        // is remove the associated directory that contains the bundles files.
        removeDir(resumeBundlePersist);

        return update;
    }
}
