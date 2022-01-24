package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        rsl.addAll(list);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}