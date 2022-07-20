package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Numbers {
    public static int sumIntegers(List<Integer> numbers) {
        return numbers.stream().filter(val -> val != null).reduce(Integer::sum).orElse(0);
    }

    public static boolean integersContainsNulls(List<Integer> numbers) {
        return numbers.contains(null);
    }

    public static List<Integer> evenIntegers(List<Integer> numbers) {
        return numbers.stream().filter(val -> val != null && val % 2 == 0).collect(Collectors.toList());
    }
}

class Numbers2 {

    public static int sumIntegers(List<Integer> numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException("List cannot be null");
        }

        return numbers.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sum();
    }

    public static boolean integersContainsNulls(List<Integer> numbers) {
        if (Objects.isNull(numbers))
            return false;

        return numbers.stream().anyMatch(Objects::isNull);
    }

    public static List<Integer> evenIntegers(List<Integer> numbers) {
        if (numbers == null)
            return Collections.EMPTY_LIST;

        List<Integer> evens = new ArrayList<>();
        for (Integer num : numbers){
            evens.add(num);
        }

        return evens;
    }
}
