package ru.job4j.io.duplicates;

import ru.job4j.io.SearchFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        Path start = Paths.get("./");
        DuplicatesFinder.search(start);
    }
    public static void search(Path root) throws IOException {
        DuplicatesVisitor visitor = new DuplicatesVisitor();
        Files.walkFileTree(root, visitor);
        visitor.finder();
    }
}
