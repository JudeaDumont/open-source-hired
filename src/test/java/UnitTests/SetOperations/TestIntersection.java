package UnitTests.SetOperations;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static z.util.SetOperations.intersection;

public class TestIntersection {
    @Test
    void t() {
        Set<String> a = new HashSet<>();
        a.add("age");
        a.add("bald");

        Set<String> b = new HashSet<>();
        b.add("age");
        b.add("bald");
        b.add("fresh");
        Set<String> intersection = intersection(a, b);
        assert (intersection.size() == 2);
    }
}
