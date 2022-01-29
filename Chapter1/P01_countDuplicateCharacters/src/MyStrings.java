import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MyStrings {
    private MyStrings() {
        throw new AssertionError("Cannot be instantiated");
    }
    public static Map<Character, Integer> countDuplicateCharactersV1(String str){
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }
        Map<Character, Integer> result = new HashMap<>();

        for (char ch: str.toCharArray()){
            result.compute(ch, (k,v) -> (v==null) ? 1 : ++v);
        }
        return result;
    }

    public static Map<Character, Long> countDuplicateCharactersV2(String str){
        if (str == null || str.isBlank()) {
            return Collections.emptyMap();
        }
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); //그룹핑 by char + 통계:카운팅

        return result;
    }

    public static Map<String, Integer> countDuplicateCharactersVCP1(String str){
        if (str == null || str.isEmpty()) return Collections.emptyMap();

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++){

            String ch = String.valueOf(Character.toChars(str.codePointAt(i)));
            if (i < str.length() -1 && str.codePointCount(i, i+2) == 1) {
                i++;
            }
            result.compute(ch, (k,v) -> (v==null) ? 0 : ++v);
        }
        return result;
    }
    public static Map<String, Long> countDuplicateCharactersVCP2(String str){
        if (str == null || str.isEmpty()) return Collections.emptyMap();

        Map<String, Long> result = str.codePoints()
                .mapToObj(c -> String.valueOf(Character.toChars(c)))
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;
    }
}
