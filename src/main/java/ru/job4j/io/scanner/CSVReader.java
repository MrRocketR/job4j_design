package ru.job4j.io.scanner;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.util.Scanner;


public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String param1 = argsName.get("path");
        String param2 = argsName.get("delimiter");
        String param3 = argsName.get("out");
        String param4 = argsName.get("filter");
        Scanner scanner = new Scanner(new FileReader(param1));
        scanner.useDelimiter(param2);
        int columnCounter = -1;
        while (scanner.hasNext()) {
            String column = scanner.next();
            if (param4.contains(column)) {
                columnCounter++;
            }
        }
        scanner.close();
        if (!param3.equals("stdout")) {
            File outFile = new File(param3);
            System.out.println(outFile.getName());
            System.out.println(outFile.getAbsolutePath());
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(outFile)
                    ))) {
                Scanner scanner2 = new Scanner(new FileReader(param1)).useDelimiter(";");
                while (scanner2.hasNextLine()) {
                    String line = scanner2.nextLine();
                    String[] arr = line.split(";");
                    for (int i = 0; i <= columnCounter; i++) {
                        System.out.println(arr[i]);
                        out.print(arr[i]);
                        out.print(";");
                    }
                    out.print(System.lineSeparator());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (param3.equals("stdout")) {
            Scanner scanner2 = new Scanner(new FileReader(param1)).useDelimiter(";");
            while (scanner2.hasNextLine()) {
                String line = scanner2.nextLine();
                String[] arr = line.split(";");
                for (int i = 0; i <= columnCounter; i++) {
                    System.out.print(arr[i]);
                    System.out.print(";");
                }
                System.out.print(System.lineSeparator());
                }
            scanner.close();
            }
        }

    }
