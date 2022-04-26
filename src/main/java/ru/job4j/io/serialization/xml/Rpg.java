package ru.job4j.io.serialization.xml;

public class Rpg {
    String classname;
    int level;

    public Rpg(String classname, int level) {
        this.classname = classname;
        this.level = level;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
