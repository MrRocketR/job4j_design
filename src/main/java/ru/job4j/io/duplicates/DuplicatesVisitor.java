package ru.job4j.io.duplicates;

import ru.job4j.tree.Tree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Map<FileProperty, List<Path>> filePropertyListMap = new HashMap<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size  = file.toFile().length();
        String name = file.getFileName().toString();
        FileProperty filePropertyTemp = new FileProperty(size, name);
        if (!filePropertyListMap.containsKey(filePropertyTemp)) {
            List<Path> temp = new ArrayList<>();
            temp.add(file);
            filePropertyListMap.put(filePropertyTemp, temp);
        } else {
            filePropertyListMap.get(filePropertyTemp).add(file);
        }
        return super.visitFile(file, attrs);
    }

    public void finder() {
        for (Map.Entry<FileProperty, List<Path>> entry : filePropertyListMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getValue());
            }
        }

    }
}

