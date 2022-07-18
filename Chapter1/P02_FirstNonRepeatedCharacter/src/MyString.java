//Finding the first non-repeated character:
//Write a program that returns the first non-repeated character from a given string.


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyString {
    private static final int EXTENDED_ASCII_CODES = 256;

    //linkedHashMap
    public static char firstNonRepeatedCharacterV1(String str){

        Map<Character, Integer> result = new LinkedHashMap<>();
        for (char ch : str.toCharArray()){
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : result.entrySet()) {
            if (entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }
    // 256 ASCII codes solution:
    public static char firstNonRepeatedCharacterV2(String str){
        if (str == null || str.isBlank()){
            return Character.MIN_VALUE;
        }

        int[] flags = new int[EXTENDED_ASCII_CODES];
        for (int i = 0; i < flags.length; i++){
            flags[i] = -1;
        }

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (flags[ch] == -1){
                flags[ch] = i;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < EXTENDED_ASCII_CODES; i++){
            if (flags[i] >= 0){
                position = Math.min(position, flags[i]);
            }
        }
        return position == Character.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    public static char firstNonRepeatedCharacterV4(String str){
        if (str == null || str.isBlank()) return Character.MIN_VALUE;

        Map<Integer, Long> chs = str.chars()
                .mapToObj(ch -> ch)
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new, Collectors.counting()));
        return (char) (int) chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
    }

    public static String firstNonRepeatedCharacterVCP4(String str){
        Map<Integer, Long> chs = str.codePoints()
                .mapToObj(ch -> ch)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()));

        int cp = chs.entrySet().stream()
                .filter(e -> e.getValue() == 1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));

        return String.valueOf(Character.toChars(cp));

    }
}
