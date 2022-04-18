package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String param1 = argsName.get("path");
        String param2 = argsName.get("delimiter");
        String param3 = argsName.get("out");
        String param4 = argsName.get("filter");
        Scanner scanner = new Scanner(new FileReader(param1)).useDelimiter(param2);
        System.out.println(scanner.nextLine());
        System.out.println("_______");
        if (!param3.equals("stdout")) {
            File outFile = new File(param3);
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(outFile)
                    ))) {
                while (scanner.hasNext()) {
                    String next = scanner.next();
                    String next2 = scanner.nextLine();
                    System.out.println(next2);
                    System.out.println("Current word is =" + next);
                    if (param4.contains(next)) {
                        System.out.println("Here + " + next);
                        out.print(next);
                        out.print(";");
                        out.print(System.lineSeparator());
                    }
                }
            }
        }
        if (param3.equals("stdout")) {
            while (scanner.hasNext()) {
                String next = scanner.next();
                System.out.println(next);
                if (next.contains(param4)) {
                    System.out.println(next);
                }
            }
        }
        scanner.close();
    }
    }
