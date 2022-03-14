package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Set<T> {

    private SimpleArrayList<T> set = new SimpleArrayList<>(10);

    @Override
    public boolean add(T value) {
        boolean check = false;
        if (!contains(value)) {
            set.add(value);
            check = true;
        }
        return check;
    }

    @Override
    public boolean contains(T value) {
        boolean check = false;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (Objects.equals(it.next(), value)) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

}
