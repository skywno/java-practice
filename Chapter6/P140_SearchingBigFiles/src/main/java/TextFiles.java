import java.io.BufferedReader;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.regex.Pattern;

public class TextFiles {
    private static final long MAP_SIZE = 5242880; // 5 MB in bytes

    private TextFiles() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static int countOccurrencesV1(Path path, String text, Charset ch) throws IOException{

        Objects.requireNonNull(path,"path cannot be null");
        Objects.requireNonNull(text,"text cannot be null");
        ch = Objects.requireNonNullElse(ch, StandardCharsets.UTF_8);

        if (text.isBlank()){
            return 0;
        }

        int count = 0;
        try (BufferedReader br = Files.newBufferedReader(path, ch)) {
            String line;
            while (( line = br.readLine()) != null) {
                count += countStringInString(line, text);
            }
        }

        return count;
    }

    private static int countStringInString(String string, String toFind) {
        return string.split(Pattern.quote(toFind), -1).length - 1;
    }

    public static int countOccurrencesV2(Path path, String text, Charset ch) throws IOException {
        Objects.requireNonNull(path,"path cannot be null");
        Objects.requireNonNull(text,"text cannot be null");
        ch = Objects.requireNonNullElse(ch, StandardCharsets.UTF_8);

        if (text.isBlank()) {
            return 0;
        }

        return Files.readAllLines(path, ch).parallelStream()
                .mapToInt((p) -> countStringInString(p, text))
                .sum();
    }
    public static int countOccurrencesV3(Path path, String text, Charset ch) throws IOException {
        Objects.requireNonNull(path,"path cannot be null");
        Objects.requireNonNull(text,"text cannot be null");
        ch = Objects.requireNonNullElse(ch, StandardCharsets.UTF_8);

        if (text.isBlank()) {
            return 0;
        }

        return Files.lines(path, ch).parallel()
                .mapToInt( p -> countStringInString(p, text))
                .sum();

    }

    public static int countOccurrencesV5(Path path, String text) throws IOException {
        Objects.requireNonNull(path,"path cannot be null");
        Objects.requireNonNull(text,"text cannot be null");

        if (text.isBlank()) {
            return 0;
        }

        final byte[] textToFind = text.getBytes(StandardCharsets.UTF_8);

        int count = 0;
        try (FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ)) {
            long position = 0;
            long length = fileChannel.size();

            while(position < length) {
                long remaining = length - position;
                long bytesToMap = (long) Math.min(MAP_SIZE, remaining);
                MappedByteBuffer mbBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, position, bytesToMap);

                long limit = mbBuffer.limit();
                long lastSpace = -1;
                long firstChar = -1;

                while (mbBuffer.hasRemaining())  {

                    boolean isFirstChar = false;

                    while (firstChar != 0 && mbBuffer.hasRemaining()) {

                        byte currentByte = mbBuffer.get();

                        if (Character.isWhitespace((char) currentByte)) {
                            lastSpace = mbBuffer.position();
                        }

                        if (textToFind[0] == currentByte) {
                            isFirstChar = true;
                            break;
                        }
                    }

                    if (isFirstChar) {
                        boolean isRestOfChars = true;

                        int j;
                        for (j=1; j< textToFind.length; j++){
                            if (!mbBuffer.hasRemaining() || textToFind[j] != mbBuffer.get()) {
                                isRestOfChars = false;
                                break;
                            }
                        }

                        if (isRestOfChars) {
                            count++;
                            lastSpace = -1;
                        }

                        firstChar = -1;
                    }
                }

                if (lastSpace > -1) {
                    position = position - (limit - lastSpace);
                }

                position += bytesToMap;
            }
        }
        return count;
    }
}
