import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws Exception {
        Path startPath = Paths.get("");

        System.out.println("Find all files ending with the '.properties' extension " +
                "and following symbolic links: ");

        Stream<Path> stream1 = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> path.toString().endsWith(".properties"),
                FileVisitOption.FOLLOW_LINKS
        );

//        stream1.forEach(System.out::println);

        System.out.println("\n\nFind all regular files whose names start with " +
                "'application': ");
        Stream<Path> stream2 = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isRegularFile() && path.toString().startsWith(
                        "application"),
                FileVisitOption.FOLLOW_LINKS
        );
        stream2.forEach(System.out::println);


        System.out.println("\n\nFind all directories created after 16 March 2022: ");
        Stream<Path> stream3
                = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isDirectory()
                        && attr.creationTime().toInstant().
                        isAfter(LocalDate.of(2022, 3, 16).atStartOfDay().
                                toInstant(ZoneOffset.UTC))
        );
//        stream3.forEach(System.out::println);


        System.out.println("\n\nFind all files created after 16 March 2022: ");
        Stream<Path> stream4
                = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isRegularFile()
                        && attr.creationTime().toInstant().
                        isAfter(LocalDate.of(2022, 3, 16).atStartOfDay().
                                toInstant(ZoneOffset.UTC))
        );

//        stream4.forEach(System.out::println);


        System.out.println("\n\nFind all binary files: ");
        Stream<Path> stream5 =
                Files.find(
                        startPath,
                        Integer.MAX_VALUE,
                        (path, attr) -> path.toString().endsWith(".class") && attr.isRegularFile()
                );

        stream5.forEach(System.out::println);
    }
}
