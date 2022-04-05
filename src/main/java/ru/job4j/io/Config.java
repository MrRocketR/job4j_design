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
                StringBuilder stringBuilder = new StringBuilder();
                String[] arr = line.split("\\.");
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i].contains("=")) {
                        int index = arr[i].indexOf("=");
                        key = arr[i].substring(0, index);
                        value = arr[i].substring(index + 1);
                        stringBuilder.append(value);
                        i++;
                        while (i < arr.length) {
                            stringBuilder.append(".");
                            stringBuilder.append(arr[i]);
                            i++;
                        }
                    }
                }
                value = stringBuilder.toString();
                values.put(key, value);
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
