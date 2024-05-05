package com.example.databasedrivers.postgres.services.description;

import com.example.databasedrivers.DescriptionDao;
import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.model.Description.DescriptionPersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DescriptionService {

    private final DescriptionDao<DescriptionPersist, Long> DescriptionDao;

    @Autowired
    public DescriptionService(@Qualifier("postgresDescription") DescriptionDao<DescriptionPersist, Long> DescriptionDao) {
        this.DescriptionDao = DescriptionDao;
    }

    public com.example.databasedrivers.DescriptionDao<DescriptionPersist, Long> getDescriptionDao() {
        return DescriptionDao;
    }

    public int save(DescriptionPersist DescriptionPersist) {
        assert (DescriptionPersist.getName() != null);
        return DescriptionDao.save(DescriptionPersist);
    }

    public Long saveReturnID(DescriptionPersist DescriptionPersist) {
        assert (DescriptionPersist.getName() != null);
        return DescriptionDao.saveReturnID(DescriptionPersist);
    }

    public DescriptionPersist get(Long DescriptionID) throws DuplicatePrimaryKeyException {
        return DescriptionDao.get(DescriptionID);
    }

    public List<DescriptionPersist> getByName(String DescriptionName) {
        return DescriptionDao.getByName(DescriptionName);
    }

    public int update(DescriptionPersist DescriptionPersist) throws DuplicatePrimaryKeyException {
        //Unique names if you call update
        List<DescriptionPersist> resumeDescriptionPersist = getByName(DescriptionPersist.getName());
        if (DescriptionPersist.getId() == null) {
            if (resumeDescriptionPersist.isEmpty()) {
                saveReturnID(DescriptionPersist);
                return 1;
            } else {
                DescriptionPersist.setId(resumeDescriptionPersist.get(0).getId());
                return DescriptionDao.update(DescriptionPersist);
            }
        } else {
            return DescriptionDao.update(DescriptionPersist);
        }
    }

    public int delete(DescriptionPersist DescriptionPersist) {
        return DescriptionDao.delete(DescriptionPersist);
    }

    public Collection<DescriptionPersist> getAll() {
        return DescriptionDao.getAll();
    }
}
