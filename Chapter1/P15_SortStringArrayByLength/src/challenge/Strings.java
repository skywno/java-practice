package challenge;

import java.util.Arrays;
import java.util.Comparator;

public final class Strings {
    private Strings(){
        throw new AssertionError("Cannot be instantiated");
    }

    public enum Sort{
        ASC, DESC
    };


    public static void sortArrayByLengthV1(String[] strs, Sort order) {
        if (strs == null || order == null || strs.length==0 )
            throw new IllegalArgumentException("not allowed arguments");

        if (order.equals(Sort.ASC)){
            Arrays.sort(strs, (String a, String b) -> Integer.compare(a.length(), b.length()));
        } else {
            Arrays.sort(strs, (String a, String b) -> -1 * Integer.compare(a.length(), b.length()));
        }
    }

    public static void sortArrayByLengthV2(String[] strs, Sort order) {
        if (strs == null || order == null || strs.length==0 )
            throw new IllegalArgumentException("not allowed arguments");

        Comparator<String> comparator = Comparator.comparingInt(String::length);

        if (order.equals(Sort.ASC)){
            Arrays.sort(strs, comparator);
        } else {
            Arrays.sort(strs, comparator.reversed());
        }
    }

    public static String[] sortArrayByLengthV3(String[] strs, Sort order) {
        if (strs == null || order == null || strs.length==0 )
            throw new IllegalArgumentException("not allowed arguments");

        if (order.equals(Sort.ASC)){
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length))
                    .toArray(String[]::new);
        } else {
            return Arrays.stream(strs)
                    .sorted(Comparator.comparingInt(String::length).reversed())
                    .toArray(String[]::new);
        }

    }

}
