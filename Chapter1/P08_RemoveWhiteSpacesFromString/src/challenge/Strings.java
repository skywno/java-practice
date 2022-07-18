package challenge;

// Write a program that removes all white spaces from the given string.
public class Strings {

    public static String removeWhitespaces1(String text) {
        if (text.isEmpty() || text == null)
            return "";
        return text.replaceAll("\\p{Space}", "");
    }

    public static String removeWhitespaces2(String text) {
        if (text.isEmpty() || text == null)
            return "";
        return text.replaceAll("[ \t\n\r]", "");
    }

    public static String removeWhitespaces3(String text) {
        if (text.isEmpty() || text == null)
            return "";
        return text.replaceAll("\\s", "");
    }
}
