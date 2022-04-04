package ru.job4j.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    List<String> s = new ArrayList<>();
    List<String> out = new ArrayList<>();
    public List<String> filter(String file) {
        try (BufferedReader in = new BufferedReader(new FileReader("log.txt"))) {
            s = in.lines().collect(Collectors.toList());
            for (String s1: s) {
                if (s1.contains("404")) {
                    out.add(s1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("log.txt");
        System.out.println(log);

    }
}