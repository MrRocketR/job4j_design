package ru.job4j.io.serialization.json;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.io.serialization.Contact;

public class Main {
    public static void main(String[] args) {
        final Person person = new Person(false, 30, new Contact(120, "+7(924)111-111-11-11"),
                new String[] {"Worker", "Married"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"sex\":false,"
                        + "\"age\":35,"
                        + "\"contact\""
                        + "{"
                        + "\"zipCode\" :120,"
                        + "\"phone\":\"+7(924)111-111-11-11\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Student\",\"Free\"]"
                        + "}";
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
