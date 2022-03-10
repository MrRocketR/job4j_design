package ru.job4j.set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

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
        T setValue;
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
           setValue =  it.next();
            if (setValue == value) {
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
