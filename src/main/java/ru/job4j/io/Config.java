package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> list = new ArrayList<>();
        String key;
        String value;
        try (BufferedReader in = new BufferedReader(new FileReader("app.properties"))) {
            list = in.lines().collect(Collectors.toList());
            for (String s: list) {
                if (s.contains("username")) {
                    int i = s.indexOf("=");
                    key = s.substring(s.indexOf("=") + 1);
                }
                if (s.contains("password")) {
                    int i = s.indexOf("=");
                    value = s.substring(s.indexOf("=") + 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}
