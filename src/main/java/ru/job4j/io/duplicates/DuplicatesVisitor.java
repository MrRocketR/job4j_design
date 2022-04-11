package ru.job4j.io.duplicates;

import ru.job4j.tree.Tree;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private  List<FileProperty> fileProperties = new ArrayList<>();
    private Stack<FileProperty> stack = new Stack<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size  = file.toFile().length();
        String name = file.getFileName().toString();
        stack.push(new FileProperty(size, name, file));
        return super.visitFile(file, attrs);
    }

    public void finder() {
        while (!stack.isEmpty()) {
            FileProperty temp = stack.pop();
            if (stack.contains(temp) || fileProperties.contains(temp)) {
               fileProperties.add(temp);
            }
        }
        for (FileProperty fl:fileProperties) {
            System.out.println(fl.getPath());
        }
    }
}

