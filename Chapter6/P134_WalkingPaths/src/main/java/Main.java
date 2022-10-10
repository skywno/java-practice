import java.io.IOException;
import java.nio.file.*;
import java.util.EnumSet;

public class Main {
    public static void main(String[] args) throws IOException {
//        Path path = Paths.get(".").toAbsolutePath();
//        System.out.println("path = " + path);
//
//        PathVisitor visitor = new PathVisitor();
//
//        Files.walkFileTree(path, visitor);


        // Test SearchFileVisitor class
//        Path searchFile = Paths.get("microsoft-windows-appmanagement-migration");
//
//        SearchFileVisitor searchFileVisitor
//                = new SearchFileVisitor(searchFile);
//
//        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
//        Iterable<Path> roots = FileSystems.getDefault().getRootDirectories();
//
//        for (Path root: roots) {
//            if (!searchFileVisitor.isFileFound()) {
//                Files.walkFileTree(root, opts,
//                        5, searchFileVisitor);
//            }
//        }
//
        // Test CopyFileVisitor Class


        Path copyFrom = Paths.get("/Users/skywn/Documents/Outlook 파일");
        Path copyTo = Paths.get("/Users/skywn/Documents/copyOutlook 파일");

        CopyFileVisitor copyFileVisitor = new CopyFileVisitor(copyFrom, copyTo);

        EnumSet opts = EnumSet.of(FileVisitOption.FOLLOW_LINKS);

        Files.walkFileTree(copyFrom, opts, Integer.MAX_VALUE, copyFileVisitor);
    }
}
