package ru.job4j.io.serialization.xml;

public class XmlExample {
    public static void main(String[] args) {
        final Character warlock = new Character(true, 225,
                "Loki", new String[] {"Staff", "Book"},
                new Rpg("warlock", 42));
    }
}
