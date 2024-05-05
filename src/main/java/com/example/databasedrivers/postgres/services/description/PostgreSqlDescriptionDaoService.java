package com.example.databasedrivers.postgres.services.description;

import com.example.databasedrivers.DescriptionDao;
import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.model.Description.DescriptionPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.example.databasedrivers.postgres.services.FormatSqlString.formatSqlString;

@Repository("postgresDescription")
public class PostgreSqlDescriptionDaoService implements
        DescriptionDao<DescriptionPersist, Long> {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertIntoDescription;

    @Autowired
    public PostgreSqlDescriptionDaoService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertIntoDescription = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Description")
                .usingGeneratedKeyColumns("id");
    }

    private static Map<String, Object> dbParametersFromDescription(DescriptionPersist DescriptionPersist) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("name", DescriptionPersist.getName());
        parameters.put("content", DescriptionPersist.getContent());
        return parameters;
    }

    @Override
    public DescriptionPersist get(Long DescriptionID) throws DuplicatePrimaryKeyException {
        if (DescriptionID != null) {
            String getQuery = "SELECT * FROM Description WHERE id = " + DescriptionID;

            List<DescriptionPersist> bundlesMatchingID = jdbcTemplate.query(getQuery,
                    (resultSet, i) -> new DescriptionPersist(resultSet));
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
    public Collection<DescriptionPersist> getAll() {
        String getAllQuery = "SELECT * FROM Description";

        return jdbcTemplate.query(getAllQuery, (resultSet, i) ->
        {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String content = resultSet.getString("content");
            return new DescriptionPersist(
                    id,
                    name,
                    content
            );
        });
    }

    @Override
    public int save(DescriptionPersist DescriptionPersist) {
        String insertQuery = "insert into Description values(DEFAULT,'" +
                formatSqlString(DescriptionPersist.getName()) + "','" +
                formatSqlString(DescriptionPersist.getContent()) +
                "')";
        return jdbcTemplate.update(insertQuery);
    }

    @Override
    public Long saveReturnID(DescriptionPersist DescriptionPersist) {
        final Map<String, Object> parameters = dbParametersFromDescription(DescriptionPersist);
        Long generatedDescriptionId = (Long) insertIntoDescription.executeAndReturnKey(parameters);
        DescriptionPersist.setId(generatedDescriptionId);
        return generatedDescriptionId;
    }

    @Override
    public ArrayList<DescriptionPersist> getByName(String DescriptionName) {
        String getAllQuery = "SELECT * FROM Description WHERE name='" + formatSqlString(DescriptionName) + "' ";

        return (ArrayList<DescriptionPersist>) jdbcTemplate.query(getAllQuery, (resultSet, i) ->
                new DescriptionPersist(
                        resultSet
                ));
    }

    @Override
    public int update(DescriptionPersist DescriptionPersist) {
        String query =
                "update Description set " +
                        "name='" + formatSqlString(DescriptionPersist.getName()) + "', " +
                        "content='" + formatSqlString(DescriptionPersist.getContent()) +
                        "' where id='" + DescriptionPersist.getId() + "' ";
        return jdbcTemplate.update(query);
    }

    @Override
    public int delete(DescriptionPersist resumeDescriptionPersist) {
        String query = "delete from Description where id='" + resumeDescriptionPersist.getId() + "' ";
        int update = jdbcTemplate.update(query);
        return update;
    }
}
