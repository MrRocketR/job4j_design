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
        String key = null;
        String value;
        try (BufferedReader in = new BufferedReader(new FileReader("app.properties"))) {
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.contains("#")) {
                    String[] arr = line.split("=");
                    System.out.println(arr[0] + " ____ " + arr[1]);
                    for (int i = 0; i < arr.length; i++) {
                        if (arr.length > 2) {
                            key = arr[0];
                            value = arr[1];
                            values.put(key, value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
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
        Config config = new Config("app.properties");
        config.load();

    }

}
