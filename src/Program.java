import java.util.InputMismatchException;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Program {
    public static double mean(int[] nums) {
        double length = nums.length;
        int sum = IntStream.of(nums).reduce(0, (int a, int b) -> a+b);
        return Math.round((sum / length * 100)) / 100.0;
    }

    public static double mean2(int[] nums) {
        double average = IntStream.of(nums).average().getAsDouble();
        return Math.round(average * 100) / 100.0;
    }

    //source: https://edabit.com/challenge/c52kNwPuWo5kp9x4H
    public static String flipEndChars(String s) {
        if (s.length() < 2) return "Incompatible.";
        else if (s.charAt(0) == s.charAt(s.length()-1)) return "Two's a pair.";
        else return s.charAt(s.length() -1) + s.substring(1,s.length() - 1) + s.charAt(0);
	}

    //source: https://edabit.com/challenge/gyfsGx7KrGLscxFrD
    public static int calculator(int num1, char operator, int num2) {
	    if (operator == '+') return num1 + num2;
        else if (operator == '*') return num1 * num2;
        else if (operator == '-') return num1 - num2;
        else{
            if (operator == '/' && num2 == 0) return 0;
            return num1 / num2;
        }

    }
}
