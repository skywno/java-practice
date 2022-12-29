import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        Path startPath = Paths.get("");
        Stream<Path> koreanFiles = Files.find(
                startPath,
                Integer.MAX_VALUE,
                (path, attr) -> attr.isRegularFile() && path.toString().endsWith(
                        "korean.txt"),
                FileVisitOption.FOLLOW_LINKS
        );

        Path koreanFile = koreanFiles.findFirst().orElseThrow(IOException::new);

        System.out.println("File to read: " + koreanFile.toString());
        System.out.println("Default charset: " + Charset.defaultCharset() + "\n\n");

        System.out.println("Read text file via InputStream:");
        System.out.println("------------------------------------------------");
        try (InputStream is = new FileInputStream(koreanFile.toFile())) {
            int i;
            while ((i = is.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via InputStreamReader with charset:");
        System.out.println("-------------------------------------------------------");
        try (InputStreamReader isr =
                     new InputStreamReader(new FileInputStream(koreanFile.toFile()),
                             StandardCharsets.UTF_8)) {
            int i;
            while ((i = isr.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via FileReader without charset:");
        System.out.println("------------------------------------------------");
        try (FileReader fr = new FileReader(koreanFile.toFile())) {
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via FileReader with charset:");
        System.out.println("------------------------------------------------");
        try (FileReader frch = new FileReader(koreanFile.toFile(),
                StandardCharsets.UTF_8)) {
            int i;
            while ((i = frch.read()) != -1) {
                System.out.print((char) i);
            }
        }

        System.out.println("\n\nRead text file via BufferedReader with charset:");
        System.out.println("----------------------------------------------------");
        try (BufferedReader br =
                     new BufferedReader(new FileReader(koreanFile.toFile(),
                             StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println
        ("\n\n----------------------------------------------------");
        try (BufferedReader br = Files.newBufferedReader(koreanFile,
        StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        System.out.println("\n\nRead text file in memory via Files.readAllLines() with charset:");
        System.out.println("-------------------------------------------------------------------");
        List<String> lines = Files.readAllLines(koreanFile, StandardCharsets.UTF_8);
        lines.forEach(System.out::println);

        System.out.println("\n\nRead text file in memory via Files.readString() with charset:");
        System.out.println("-------------------------------------------------------------------");
        String content = Files.readString(koreanFile, StandardCharsets.UTF_8);
        System.out.println(content);

        System.out.println("\n\nRead text file via MappedByteBuffer:");
        System.out.println("-------------------------------------------------------------------");

        try (FileChannel fileChannel = FileChannel.open(koreanFile, EnumSet.of(StandardOpenOption.READ))) {
            MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            if (mbBuffer != null) {
                String bufferContent = StandardCharsets.UTF_8.decode(mbBuffer).toString();
                System.out.println(bufferContent);

                mbBuffer.clear();
            }
        }

        System.out.println("\n\nRead text file via MappedByteBuffer with buffer size:");
        System.out.println("-------------------------------------------------------------------");
        int MAP_SIZE = 1048576 ; // 1MB in bytes

        try (FileChannel fileChannel = FileChannel.open(koreanFile,
                EnumSet.of(StandardOpenOption.READ))) {

            int position = 0;
            long length = fileChannel.size();

            while (position < length) {
                System.out.println("position = " + position);
                long remaining = length - position;
                int bytestomap = (int) Math.min(MAP_SIZE, remaining);

                MappedByteBuffer mbBuffer = fileChannel.map(
                        FileChannel.MapMode.READ_ONLY, position, bytestomap);

                if (mbBuffer != null) {
                    String bufferContent =
                            StandardCharsets.UTF_8.decode(mbBuffer).toString();
                    System.out.println(bufferContent);

                    mbBuffer.clear();
                }

                position += bytestomap;

            }
        }
    }
}