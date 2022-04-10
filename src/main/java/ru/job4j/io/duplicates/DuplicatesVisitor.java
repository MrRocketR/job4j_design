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
    private Set <FileProperty> propertySet = new HashSet<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        long size  = file.toFile().length();
        String name = file.getFileName().toString();
        fileProperties.add(new FileProperty(size, name));
        return super.visitFile(file, attrs);
    }

    public void finder () {
        propertySet.addAll(fileProperties);
        for (FileProperty s : propertySet) {
            boolean firstMeet = false;
            for (int j = 0; j < fileProperties.size(); j++) {
                if (s.equals(fileProperties.get(j))) {
                    if (!firstMeet) {
                        firstMeet = true;
                    }
                        else  {
                            System.out.println(fileProperties.get(j).getName());
                        }
                    }
                }
            }
        }
    }

