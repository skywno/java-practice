package challenge;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final String TEXT = "      My high\n\n school,        the Illinois Mathematics and Science Academy, "
            + "showed me that anything is possible and that you're never too young to think big. \r"
            + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, \t"
            + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
            + "computer science.           ";

    public static void main(String[] args) {

        System.out.println("Input text: \n" + TEXT + "\n");

        System.out.println("replaceAll() solution with a regex = \\p{Space}:");
        long startTime = System.nanoTime();

        String result = Strings.removeWhitespaces1(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("String without blanks is: \n" + result);
        // Execution time: 9871300 ns (9 ms)

        System.out.println("replaceAll() solution with a regex = [ \\t\\n\r]}:");
        startTime = System.nanoTime();

        result = Strings.removeWhitespaces2(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("String without blanks is: \n" + result);
        //Execution time: 1690400 ns (1 ms)


        System.out.println("replaceAll() solution with a regex = \\s}:");
        startTime = System.nanoTime();

        result = Strings.removeWhitespaces3(TEXT);

        displayExecutionTime(System.nanoTime() - startTime);
        System.out.println("String without blanks is: \n" + result);
        //Execution time: 856600 ns (0 ms)
    }

    private static void displayExecutionTime(long time) {
        System.out.println("Execution time: " + time + " ns" + " ("
                + TimeUnit.MILLISECONDS.convert(time, TimeUnit.NANOSECONDS) + " ms)");
    }
}