package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "createdClass")
public class Rpg {
    @XmlAttribute
    private String classname;
    @XmlAttribute
    private int level;

    public Rpg() {

    }

    public Rpg(String classname, int level) {
        this.classname = classname;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Rpg{" + "classname='"
                + classname + '\''
                + ", level="
                + level + '}';
    }
}
