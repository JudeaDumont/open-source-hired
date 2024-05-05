package z.util.StringProcessing;

import java.util.Arrays;
import java.util.function.Predicate;

public class SplitWithNoEmpties {

    public static String[] splitNoEmpties(String remaining) {
        return Arrays.stream(remaining.split(" ")).filter(Predicate.not(String::isEmpty)).toArray(String[]::new);
    }
}
