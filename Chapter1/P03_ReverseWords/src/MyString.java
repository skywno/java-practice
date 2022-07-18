//Reversing letters and words:
//Write a program that reverses the letters of each word and a program that reverses the letters of each word and the words themselves.

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MyString{
    private static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile(" +");

    public static String reverseWordsV1(String str){
        if (str == null || str.isBlank()) return "";

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedStr = new StringBuilder();

        for (String word : words){
            for (int i = word.length()-1; i>=0; i--){
                reversedStr.append(word.charAt(i));
            }
            reversedStr.append(WHITESPACE);
        }
        return reversedStr.toString();
    }
    public static String reverseWordsV2(String str){
        if (str == null || str.isBlank()) return "";

        return PATTERN.splitAsStream(str)
                .map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }

    public static String reverse(String str){
        if (str == null || str.isBlank()) return "";
        return new StringBuilder(str).reverse().toString();
    }
}


