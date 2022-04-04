package ru.job4j.io;

import java.util.regex.Matcher;

public class Test {
    public static void main(String[] args) {
        String s = "hibernate.connection.username=postgres";
        int i = s.indexOf("=");
        System.out.println(i);
        String o = s.substring(i + 1);
        System.out.println(o);
    }
}
