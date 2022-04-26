package ru.job4j.io.serialization.json;

import org.json.JSONObject;

public class StudentsJSONJava {
    public static void main(String[] args) {
        final Student student = new Student(true, 4,
                "Ivanov",
                new Contact("4242"),
                new String[] {"Algebra", "Russian"});
        JSONObject jsonObject = new JSONObject(student);
        System.out.println(jsonObject);
    }
}
