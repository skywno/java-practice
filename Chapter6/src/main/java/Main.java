import java.io.*;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws IOException {
        Path binaryFile = Paths.get("P138_ReadWriteTextFilesEfficiently\\build" +
                "\\classes\\java\\main\\Main.class");

        int fileSize = (int) Files.readAttributes(binaryFile, BasicFileAttributes.class).size();

        System.out.println("File to read: " + binaryFile.toString());
        System.out.println("File size: " + fileSize + " bytes");
        System.out.println("Default charset: " + Charset.defaultCharset() + "\n\n");

        final byte[] buffer = new byte[fileSize];

//        System.out.println("Read binary files via InputStream and a buffer");
//        try (InputStream is = new FileInputStream(binaryFile.toString())) {
//            int i;
//            while ((i = is.read(buffer)) != -1) {
//                System.out.println("\nRead: " + i + "bytes");
//            }
//        }
//
//        System.out.println("Read binary files via BufferedInputStream");
//        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(binaryFile))) {
//            int i;
//            while ((i = bis.read(buffer)) != -1) {
//                System.out.println("\nRead: " + i + " byteus");
//            }
//        }
//
//        System.out.println("Read binary files via ByteArrayInputStream");
//        try (ByteArrayInputStream bais = new ByteArrayInputStream(buffer)) {
//            int i;
//            while ((i = bais.read(buffer)) != -1) {
//                System.out.println("\nRead: " + i + " bytes");
//            }
//        }
        System.out.println("Read binary files of floats via DataInputStream");

        System.out.println("Read binary file in memory via Files.readAllBytes()");
        byte[] bytes = Files.readAllBytes(binaryFile);
        System.out.println("\nRead " + bytes.length + " bytes");

        System.out.println("Read binary file in memory via MappedByteBuffer");
        try (FileChannel fileChannel = (FileChannel.open(binaryFile, EnumSet.of(StandardOpenOption.READ)))) {
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

            System.out.println("\nRead: " + mappedByteBuffer.limit() + " bytes");
        }


    }
}
