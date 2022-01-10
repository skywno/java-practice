import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int lineNum = 1;
        while (sc.hasNext()){
            System.out.printf("%d %s%n", lineNum, sc.nextLine());
            lineNum++;
        }
    }
}