import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class CopyFileVisitor implements FileVisitor<Path> {

    private final Path copyFrom;
    private final Path copyTo;

    public CopyFileVisitor(Path copyFrom, Path copyTo) {
        this.copyFrom = copyFrom;
        this.copyTo = copyTo;
    }

    private static void copySubTree(Path copyFrom, Path copyTo) throws IOException {
        Files.copy(copyFrom, copyTo, REPLACE_EXISTING);
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Path newDir = copyTo.resolve(copyFrom.relativize(dir));

        try {
            Files.copy(dir, newDir, REPLACE_EXISTING, COPY_ATTRIBUTES);
        } catch (IOException e) {
            System.err.println("Unable to create "
                    + newDir + " [" + e + "]");

            return FileVisitResult.SKIP_SUBTREE;
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        try {
            copySubTree(file, copyTo.resolve(
                    copyFrom.relativize(file)));
        } catch (IOException e) {
            System.err.println("Unable to copy "
                    + copyFrom + " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException ioe) throws IOException {

        if (ioe instanceof FileSystemLoopException) {
            System.err.println("Cycle was detected: " + file);
        } else {
            System.err.println("Error occured, unable to copy:"
                    + file + " [" + ioe + "]");
        }

        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {

        Path newDir = copyTo.resolve(copyFrom.relativize(dir));

        try {
            FileTime time = Files.getLastModifiedTime(dir);
            Files.setLastModifiedTime(newDir, time);
        } catch (IOException e) {
            System.err.println("Unable to preserve the time attribute to: " + newDir +
                    " [" + e + "]");
        }

        return FileVisitResult.CONTINUE;
    }
}
