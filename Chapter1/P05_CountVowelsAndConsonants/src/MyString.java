import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class MyString {
    private static final Set<Character> allVowels
            = new HashSet<>(Arrays.asList('a','e','i','o','u'));
    public static Pair countVowelsAndConsonantsV1(String str){
        int vowelsCount = 0;
        int consonantsCount = 0;
        for (char ch : str.toLowerCase(Locale.ROOT).toCharArray()){
            if (allVowels.contains(ch))
                vowelsCount++;
            else if (Character.isLetter(ch))
                consonantsCount++;
        }
        Pair result = Pair.of(vowelsCount, consonantsCount);
        return result;
    }

    public static Pair<Long, Long> countVowelsAndCOnsonantsV2(String str) {
        if (str == null || str.isBlank()){
            return Pair.of(-1L, -1L);
        }

        str = str.toLowerCase();
        Map<Boolean, Long> result = str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(ch -> (ch >= 'a' && ch <= 'z'))
                .collect(Collectors.partitioningBy(c -> allVowels.contains(c), counting()));
        return Pair.of(result.get(true), result.get(false));
    }
}
