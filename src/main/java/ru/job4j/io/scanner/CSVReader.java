package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String param1 = argsName.get("path");
        String param2 = argsName.get("delimiter");
        String param3 = argsName.get("out");
        String param4 = argsName.get("filter");
        Scanner scanner = new Scanner(new FileReader(param1));
        String[] firstColumn = scanner.nextLine().split(param2);
        ArrayList<Integer> usefullColumns = new ArrayList<>();
        for (int i = 0; i < firstColumn.length; i++) {
            if (param4.contains(firstColumn[i])) {
                usefullColumns.add(i);
            }
        }
        scanner.close();
        Scanner scanner2 = new Scanner(new FileReader(param1));
        if ("stdout".equals(param3)) {
            while (scanner2.hasNextLine()) {
                String[] column = scanner.nextLine().split(param2);
                for (int i = 0; i < column.length; i++) {
                    if (usefullColumns.equals(i)) {
                        System.out.print(column[i]);
                        System.out.print(";");
                    }
                }
                System.out.println();
            }
            scanner2.close();
        }
        if (!"stdout".equals(param3)) {
            File outFile = new File(param3);
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(outFile)
                    ))) {
                while (scanner2.hasNextLine()) {
                    String[] column = scanner2.nextLine().split(param2);
                    for (int i = 0; i < column.length; i++) {
                        if (usefullColumns.contains(i)) {
                            out.print(column[i]);
                            out.print(";");
                        }
                    }
                    out.println();
                    System.out.println();
                }
            }
            scanner2.close();
        }
    }
}
