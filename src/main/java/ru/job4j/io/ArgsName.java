package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key)  {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
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
                throw new IllegalArgumentException();
            }
            values.put(key, value);
        }
    }
    private void argumentsCheck(String argument) {
        if (!argument.contains("=") || !argument.contains("-")) {
            throw new IllegalArgumentException();
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        if (args.length > 0) {
            names.parse(args);
        } else {
            throw new IllegalArgumentException();
        }
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));

        ArgsName req = ArgsName.of(new String[] {"-request=?msg=Exit="});
        System.out.println(req.get("request"));
    }


}
