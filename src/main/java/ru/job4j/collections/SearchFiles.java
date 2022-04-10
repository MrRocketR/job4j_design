package ru.job4j.collections;



import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SearchFiles implements FileVisitor<Path> {
    private Predicate<Path> predicate;
    ArrayList<Path> pathList = new ArrayList<>();

    public SearchFiles(Predicate<Path> condition) {
        this.predicate = condition;
    }


    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Searching in dir  " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        pathList.add(file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        System.out.println("Error opening file");
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Next dir  " + dir);
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getPaths() {
        return pathList.stream().filter(predicate).collect(Collectors.toList());
    }
}
