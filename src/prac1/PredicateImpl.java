package prac1;

import java.util.function.Predicate;

public class PredicateImpl implements Predicate<String> {

    @Override
    public boolean test(String str) {
        if (str == null || (str.length() != 4 && str.length() != 6)) {
            return false;
        }
        return str.matches("[0-9]+");
    }
}
