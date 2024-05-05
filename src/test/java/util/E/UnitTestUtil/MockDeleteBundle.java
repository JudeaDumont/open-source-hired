package util.E.UnitTestUtil;

import Mocks.MockBundleDao;

public class MockDeleteBundle {
    public static void mockDeleteBundleByName(String name){
        MockBundleDao.deleteAllByName(name);
    }
}
