package ru.job4j.io;

import java.util.regex.Matcher;

public class Test {
    public static void main(String[] args) {
        String key = null, value;
        String s = "hibernate.connection.username=postgres";
        String[] arr = s.split("\\.");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("=")) {
                int k = arr[i].indexOf("=");
                key = arr[i].substring(0, k);
            }
        }
        System.out.println(key);
    }
}
