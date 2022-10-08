import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        Path path1 = Paths.get("/learning/packt/JavaModernChallenge.pdf");
        Path path2 = Paths.get("/LEARNING/PACKT/JavaModernChallenge.pdf");
        Path path3 = Paths.get("D:/learning/packt/JavaModernChallenge.pdf");

        System.out.println("path1 = " + path1.toString());
        System.out.println("path2.toString() = " + path2.toString());
        System.out.println("path3 = " + path3.toString());

        System.out.println(path1.equals(path2));
        System.out.println(path1.equals(path3));

        System.out.println(Files.isSameFile(path1, path2)); //true
//      System.out.println(Files.isSameFile(path1, path3)); // Error!
        System.out.println(path1.compareTo(path2)); // 0
        System.out.println(path1.compareTo(path3)); // positive
        System.out.println(path2.compareTo(path3)); // positive

        boolean sw = path1.startsWith("/learning/packt");
        boolean ew = path1.endsWith("JavaModernChallenge.pdf");
        System.out.println("\nStart width: " + sw);
        System.out.println("End with: " + ew);    }
}
