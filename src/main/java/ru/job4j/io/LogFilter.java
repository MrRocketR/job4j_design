package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    List<String> out = new ArrayList<>();
    public List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] arr = line.split("\\s");
                if ("404".equals(arr[8])) {
                    out.add(line);
                }
            }

        } catch (IOException io) {
            io.printStackTrace();
        }
        return out;
    }



    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        for (String test: log) {
            System.out.println(test);
        }


    }


}