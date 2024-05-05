package z.util;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {
    public static Set<String> intersection(Set<String> a, Set<String> b) {
        Set<String> intersection = new HashSet<>(a);
        intersection.retainAll(b);
        return intersection;
    }
}
