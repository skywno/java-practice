package challenge;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Strings {

    public static Set<String> permuteAndStore(String text) {
        return permuteAndStore("", text);
    }

    private static Set<String> permuteAndStore(String prefix, String text) {
        Set<String> permutations = new TreeSet<>();
        int n = text.length();

        if (n==0)
            permutations.add(prefix);
        else {
            for (int i=0; i<n; i++){
                String newPrefix = prefix + text.charAt(i);
                permutations.addAll(permuteAndStore(newPrefix, text.substring(0, i) + text.substring(i+1, n)));
            }
        }
        return permutations;
    }

    public static void permuteAndPrint(String text) {
        permuteAndPrint("", text);
    }

    private static void permuteAndPrint(String prefix, String text) {
        int n = text.length();

        if (n == 0)
            System.out.println(prefix+" ");
        else {
            for (int i=0; i<n; i++){
                String newPrefix = prefix + text.charAt(i);
                permuteAndPrint(newPrefix, text.substring(0, i) + text.substring(i+1, n));
            }
        }

    }

    public static Stream<String> permuteAndReturnStream(String text) {
        if (text.isBlank() || text == null)
            return Stream.of("");

        return IntStream.range(0, text.length())
                .parallel()
                .boxed()
                .flatMap(i -> permuteAndReturnStream(text.substring(0 , i) + text.substring(i+1))
                .map(c -> text.charAt(i) + c)
                );

    }

    public static void permuteAndPrintStream(String text) {
        permuteAndPrintStream("", text);
    }

    private static void permuteAndPrintStream(String prefix, String text) {
        int n = text.length();
        if (n == 0)
            System.out.println(prefix + " ");
        else {
         IntStream.range(0, n)
            .parallel()
            .forEach(i -> permuteAndPrintStream(prefix + text.charAt(i), text.substring(0,i) +text.substring(i+1))
            );
        }
    }

}