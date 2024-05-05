package com.example.databasedrivers.postgres.services.resume;

import com.example.databasedrivers.BundleDao;
import com.example.databasedrivers.DuplicatePrimaryKeyException;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BundleService {

    private final BundleDao<ResumeBundlePersist, Long> BundleDao;

    @Autowired
    public BundleService(@Qualifier("postgresBundle") BundleDao<ResumeBundlePersist, Long> BundleDao) {
        this.BundleDao = BundleDao;
    }

    public com.example.databasedrivers.BundleDao<ResumeBundlePersist, Long> getBundleDao() {
        return BundleDao;
    }

    public int save(ResumeBundlePersist ResumeBundlePersist) {
        assert (ResumeBundlePersist.getName() != null);
        return BundleDao.save(ResumeBundlePersist);
    }

    public Long saveReturnID(ResumeBundlePersist ResumeBundlePersist) {
        assert (ResumeBundlePersist.getName() != null);
        return BundleDao.saveReturnID(ResumeBundlePersist);
    }

    public ResumeBundlePersist get(Long BundleID) throws DuplicatePrimaryKeyException {
        return BundleDao.get(BundleID);
    }

    public List<ResumeBundlePersist> getByName(String BundleName) {
        return BundleDao.getByName(BundleName);
    }

    public int update(ResumeBundlePersist ResumeBundlePersist) throws DuplicatePrimaryKeyException {
        //Unique names if you call update
        List<ResumeBundlePersist> resumeBundlePersist = getByName(ResumeBundlePersist.getName());
        if (ResumeBundlePersist.getId()==null) {
            if (resumeBundlePersist.isEmpty()) {
                saveReturnID(ResumeBundlePersist);
                return 1;
            } else {
                ResumeBundlePersist.setId(resumeBundlePersist.get(0).getId());
                return BundleDao.update(ResumeBundlePersist);
            }
        }
        else {
            return BundleDao.update(ResumeBundlePersist);
        }
    }
    public int delete(ResumeBundlePersist ResumeBundlePersist) {
        return BundleDao.delete(ResumeBundlePersist);
    }

    public Collection<ResumeBundlePersist> getAll() {
        return BundleDao.getAll();
    }
}
