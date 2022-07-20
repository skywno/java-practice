package challenge;

import java.util.stream.IntStream;

public class Strings {
    public static boolean isPalindromeV1(String text) {
        if (text == null || text.isBlank())
            return false;

        int n = text.length();
        int half = (n % 2 == 0) ? n / 2 : (int) (n / 2) + 1;
        int i = 0;
        while (i < half) {
            if (text.charAt(i) != text.charAt(n-1-i))
                return false;
            i++;
        }
        return true;
    }

    public static boolean isPalindromeV2(String text) {
        if (text == null || text.isBlank())
            return false;

        int n = text.length();
        for (int i = 0; i < n/2 ; i++) {
            if (text.charAt(i) != text.charAt(n-1-i))
                return false;
        }
        return true;
    }


    public static boolean isPalindromeV3(String text) {
//        StringBuilder temp = new StringBuilder();
//        for (int i = text.length()-1; i >= 0 ; i--){
//            temp.append(text.charAt(i));
//        }
//        return temp.toString().equals(text);
        return text.equals(new StringBuilder(text).reverse().toString());
    }

    public static boolean isPalindromeV4(String text) {
        int n = text.length();
        return IntStream.range(0, n / 2)
                .allMatch(i -> text.charAt(i) == text.charAt(n-1-i));
    }
}
