package Mocks;

import com.example.databasedrivers.BundleDao;
import com.example.model.ResumeBundle.Members.Persist.ResumeBundlePersist;

import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

import static z.util.FileIO.Bundle.RemoveAssociatedBundleDirectory.removeDir;

public class MockBundleDao {
    private static Hashtable<Long, ResumeBundlePersist> mockDb = null;
    private static BundleDao<ResumeBundlePersist, Long> bundleDao = null;
    private static Long id = 0L;

    public static BundleDao<ResumeBundlePersist, Long> getMockBundleDao() {
        if (bundleDao == null) {
            initialize();
        }
        return bundleDao;
    }

    private static void initialize() {
        mockDb = new Hashtable<>();
        mockOutBundleDao();
    }

    public static void deleteAllByName(String name) {
        List<ResumeBundlePersist> byName = bundleDao.getByName(name);
        for (ResumeBundlePersist resumeBundlePersist : byName) {
            bundleDao.delete(resumeBundlePersist);
        }
    }

    private static void mockOutBundleDao() {
        bundleDao = new BundleDao<>() {
            @Override
            public ResumeBundlePersist get(Long id) {
                return mockDb.get(id);
            }

            @Override
            public Collection<ResumeBundlePersist> getAll() {
                return mockDb.values();
            }

            @Override
            public int save(ResumeBundlePersist resumeBundlePersist) {
                resumeBundlePersist.setId(id++);
                mockDb.put(id, resumeBundlePersist);
                return Math.toIntExact(id);
            }

            @Override
            public Long saveReturnID(ResumeBundlePersist resumeBundlePersist) {
                resumeBundlePersist.setId(id++);
                mockDb.put(id, resumeBundlePersist);
                return id;
            }

            @Override
            public List<ResumeBundlePersist> getByName(String name) {
                return mockDb.values().stream().filter(rpb -> Objects.equals(rpb.getName(), name)).toList();
            }

            @Override
            public int update(ResumeBundlePersist resumeBundlePersist) {
                mockDb.remove(resumeBundlePersist.getId());
                mockDb.put(resumeBundlePersist.getId(), resumeBundlePersist);
                return Math.toIntExact(resumeBundlePersist.getId());
            }

            @Override
            public int delete(ResumeBundlePersist resumeBundlePersist) {
                mockDb.remove(resumeBundlePersist.getId());
                removeDir(resumeBundlePersist);
                return Math.toIntExact(resumeBundlePersist.getId());
            }
        };
    }
}
