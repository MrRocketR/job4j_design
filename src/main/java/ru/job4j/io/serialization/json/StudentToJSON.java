package ru.job4j.io.serialization.json;

import ru.job4j.io.serialization.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class StudentToJSON {
    public static void main(String[] args) {
        final Student student = new Student(true, 4,
                "Ivanov",
                new Contact(120, "4242"),
                new String[] {"Algebra", "Russian"});

        final Gson gson = new GsonBuilder().create();
        String jsonStudent = gson.toJson(student);
        System.out.println(jsonStudent);
        final Student studentMod = gson.fromJson(jsonStudent, Student.class);
        System.out.println(studentMod);
    }
}
