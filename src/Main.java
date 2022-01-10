import java.util.*;

public class Main {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            String s1=sc.next();
            int x=sc.nextInt();
            //Complete this line
            String template = "%-15s%03d%n";
            System.out.printf(template, s1, x);


    }
}
