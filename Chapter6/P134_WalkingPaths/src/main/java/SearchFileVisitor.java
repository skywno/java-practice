import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Objects;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private final Path fileNameToSearch;
    private boolean fileFound;

    public boolean isFileFound() {
        return fileFound;
    }
    public SearchFileVisitor(Path fileNameToSearch) {
        this.fileNameToSearch = fileNameToSearch;
    }

    private boolean search(Path file) throws IOException {
        Path fileName = file.getFileName();

        if (fileName.equals(fileNameToSearch)) {
            System.out.println("Searched file was found: " +
                    fileNameToSearch + " in " + file.toRealPath().toString());
            return true;
        }
        return false;
    }

    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
            throws IOException
    {
        Objects.requireNonNull(file);
        Objects.requireNonNull(attrs);

        fileFound = search(file);
        System.out.println("Visited file: " + file);
        if (fileFound) {
            return FileVisitResult.TERMINATE;
        } else{
            return FileVisitResult.CONTINUE;
        }

    }

    public FileVisitResult visitFileFailed(Path file, IOException exc)
            throws IOException
    {
        Objects.requireNonNull(file);
        System.out.println(exc.getMessage());
        throw exc;
    }
}
