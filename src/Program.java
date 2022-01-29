import java.util.InputMismatchException;
import java.util.Locale;
import java.util.function.BiFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Program {
    public static String toHex(String  str) {
        char[] chars = str.toCharArray();

        StringBuilder builder = new StringBuilder();
        for (char c : chars) {
            builder.append(Integer.toHexString(c).toLowerCase(Locale.ROOT)).append(" ");
        }
        System.out.println(builder.toString().trim());
        return builder.toString().trim();

    }
    public static String toHex2(String str) {
        Stream<String> stream = Stream.of(str.split(""));
        String ret = stream.map( s -> String.format("%h ", s.charAt(0)))
                            .reduce("", (String a, String b) -> a + b)
                            .trim();
                            //.toLowerCase(Locale.ROOT); %H --> %h 로 바꿀 경우 불필요.
        return ret;
    }
    private static int getPercentage(String score){
        if (score.charAt(score.length()-1) != '%') throw new IllegalArgumentException("the argument doen't end with '%'");
        return Integer.parseInt(score.substring(0, score.length()-1));

    }
    public static String gradePercentage(String userScore, String passScore){
        if (getPercentage(userScore) < getPercentage(passScore))
            return "You FAILED the Exam";
        else
            return "You PASSED the Exam";
    }

}

