package ru.job4j.io.find;

import ru.job4j.io.ArgsName;

import java.util.HashMap;
import java.util.Map;

public class Validator {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key)  {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("One of the arguments is empty!");
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s:args) {
            argumentsCheck(s);
            int startKey = s.indexOf('-');
            int endKey = s.indexOf('=');
            String key = s.substring(startKey + 1, endKey);
            String value = s.substring(endKey + 1);
            if ("".equals(key) || "".equals(value)) {
                throw new IllegalArgumentException("One of the arguments is empty!");
            }
            values.put(key, value);
        }
    }
    private void argumentsCheck(String argument) {
        if (!argument.contains("=") || !argument.startsWith("-")) {
            throw new IllegalArgumentException("Wrong arguments!");
        }
    }

    public static Validator of(String[] args) {
        Validator names = new Validator();
        if (args.length == 0) {
            throw new IllegalArgumentException("Numbers of arguments is zero!");
        }
        names.parse(args);
        return names;
    }

}