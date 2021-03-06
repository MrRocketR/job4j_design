package ru.job4j.io.find;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Searcher implements FileVisitor<Path> {
    private List<Path> fileList = new ArrayList<>();
    private String name;

    public Searcher(String name) {
        this.name = name;
    }
    private Pattern pattern = Pattern.compile(name);
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        System.out.println("Searching in dir  " + dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        System.out.println("Current file is " +  file.getFileName());
        Matcher matcher = pattern.matcher(file.getFileName().toString());
        if (matcher.matches()) {
            fileList.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path dir, IOException exc) throws IOException {
        System.out.println("Error opening file");
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        System.out.println("Next dir  " + dir);
        return FileVisitResult.CONTINUE;
    }

    public List<Path> getFileList() {
        return fileList;
    }
}
