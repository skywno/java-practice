import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.Objects;

public class PathVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc)
            throws IOException
    {
        Objects.requireNonNull(dir);
        if (exc != null)
            throw exc;

        System.out.println("Visited directory: " + dir);

        return FileVisitResult.CONTINUE;
    }
}
