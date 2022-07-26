package challenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Strings {

    private static final int EXTENDED_ASCII_CODES = 256;
    public static Pair maxOccurenceCharacterV1(String s) {

        if (s == null || s.isBlank())
            return Pair.of(Character.MIN_VALUE, -1);

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            if (!Character.isWhitespace(ch)){
                Integer noCh = map.get(ch);
                if (noCh == null) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, ++noCh);
                }
            }
        }

        Pair<Character, Integer> pair = Pair.of('a', -1);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > pair.occurrences) {
                pair = Pair.of(entry.getKey(), entry.getValue());
            }
        }
        return pair;
    }

    public static Pair maxOccurenceCharacterV2(String text) {
        if (text == null || text.isBlank()){
            return Pair.of(Character.MIN_VALUE, -1);
        }

        int maxOccurence = -1;
        char maxCharacter = Character.MIN_VALUE;

        char[] chStr = text.toCharArray();
        int[] asciiCodes = new int[EXTENDED_ASCII_CODES];

        for (int i=0;i<chStr.length;i++){
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) {
                int code = (int) currentCh;
                asciiCodes[code]++;
                if (asciiCodes[code] > maxOccurence){
                    maxOccurence = asciiCodes[code];
                    maxCharacter = currentCh;
                }
            }
        }
        return Pair.of(maxCharacter, maxOccurence);
    }

    public static Pair<Character, Long> maxOccurenceCharacterV3(String text) {
        return text.chars()
                .filter(c-> Character.isWhitespace() == false)
                .mapToObj(i -> (char) i)
                .collect(groupingBy(c -> c, counting()))
                .entrySet()
                .stream()
                .max(comparingByValue())
                .map(p -> Pair.of(p.getKey(), p.getValue()))
                .orElse(Pair.of(Character.MIN_VALUE, -1L));
    }
}
