package ru.job4j.io.find;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

public class Printer {

    public static void printToFile(String param4, List<Path> fileList) {
        File outFile = new File(param4);
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(outFile)
                ))) {
            for (Path listForPrint: fileList) {
                out.println(listForPrint);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}