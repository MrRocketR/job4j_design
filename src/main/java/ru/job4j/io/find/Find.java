package ru.job4j.io.find;

import ru.job4j.io.SearchFiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Find {

    static String param1;
    static String param2;
    static String param3;
    static String param4;

    private void paramChecker(String[] arr) {
        if (arr.length != 4) {
            throw new IllegalArgumentException("Wrong number of arguments!");
        }
        Validator validator = Validator.of(arr);
        param1 = validator.get("d");
        param2 = validator.get("n");
        param3 = validator.get("t");
        param4 = validator.get("o");
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        System.out.println(param4);
        if (!new File(param1).exists() && !new File(param1).isDirectory()) {
            throw new IllegalArgumentException("Wrong directory!");
        }
    }

    public static List<Path> search(String rootDir, String fileName) throws IOException {
        Searcher searcher = new Searcher(fileName);
        Path root = Paths.get(rootDir);
        Files.walkFileTree(root, searcher);
        return searcher.getFileList();
    }


    public static void main(String[] args) throws IOException {
        Find find = new Find();
        find.paramChecker(args);
        List<Path> fileList = search(param1, param2);
        System.out.println(fileList);
        Printer.printToFile(param4, fileList);
    }
}
