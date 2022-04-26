package ru.job4j.io.serialization.xml;

import java.util.Arrays;

public class Character {
    boolean saved;
    int seed;
    String name;
    String[] items;
    Rpg createdClass;

    public Character(boolean saved, int seed, String name, String[] items, Rpg createdClass) {
        this.saved = saved;
        this.seed = seed;
        this.name = name;
        this.items = items;
        this.createdClass = createdClass;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public Rpg getCreatedClass() {
        return createdClass;
    }

    public void setCreate(Rpg createdClass) {
        this.createdClass = createdClass;
    }

    @Override
    public String toString() {
        return "Character{" +  "saved="
                + saved + ", seed="
                + seed + ", name='"
                + name + '\'' + ", items="
                + Arrays.toString(items) + ", create="
                + createdClass + '}';
    }
}
