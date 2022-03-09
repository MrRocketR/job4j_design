package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean r = false;
        if (!contains(value)) {
            set.add(value);
            r = true;
        }
        return r;
    }

    @Override
    public boolean contains(T value) {
        boolean r = false;
        while (set.iterator().hasNext()) {
            if (set.iterator().next() == value) {
             r = true;
             break;
            }
        }
        return r;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
