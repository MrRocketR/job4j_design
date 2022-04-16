package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    static String param1;
    static String param2;
    static String param3;

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : sources) {
                if (!file.toString().contains(param2)) {
                    zip.putNextEntry(new ZipEntry(file.getPath()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void argumentChecker(String[] arr) {
        ArgsName argsName = ArgsName.of(arr);
        param1 = argsName.get("d");
        param2 = argsName.get("e");
        param3 = argsName.get("o");
    }



    public static void main(String[] args) {
        Zip zip = new Zip();
        zip.argumentChecker(args);
        System.out.println(param1);
        System.out.println(param2);
        System.out.println(param3);
        File file = new File(param1);
        List<File> sources = new ArrayList<>(Arrays.asList((Objects.requireNonNull(file.listFiles()))));
        zip.packFiles(sources,  new File(param3));
    }

}
