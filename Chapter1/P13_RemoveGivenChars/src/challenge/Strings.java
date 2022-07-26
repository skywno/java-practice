package challenge;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Strings {
    public static String removeCharacterV1(String str, char ch) {
        if (str == null || str.isEmpty()) {
            // or throw IllegalArgumentException
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();
        for (char c : chArray) {
            if (c != ch) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static String removeCharacterV2(String text, char c) {
        return text.replaceAll(Pattern.quote(String.valueOf(c)), "");
    }

    public static String removeCharacterV3(String text, char c) {
        return text.chars()
                .filter(ch -> ch != c)
                .mapToObj(ch -> String.valueOf((char) ch))
                .collect(Collectors.joining());
    }

    public static String removeCharacterV4(String text, String str) {
        return text.codePoints().filter(ch -> ch != str.codePointAt(0))
                .mapToObj(ch -> String.valueOf(Character.toChars(ch)))
                .collect(Collectors.joining());
    }
}
