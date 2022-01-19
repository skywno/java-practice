import java.io.*;
import java.util.*;

public class Main {
    static {
        Scanner input = new Scanner(System.in);
        int breadth = input.nextInt();
        int height = input.nextInt();
        if (breadth <= 0 || height <= 0){
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        } else {
            System.out.println(breadth * height);
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */


    }
}