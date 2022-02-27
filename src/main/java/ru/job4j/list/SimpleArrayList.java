package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;


    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (size >= container.length) {
            container = arrayCopy(container);
        }
        container[size] = value;
        size++;
        modCount++;
    }

    private T[] arrayCopy(T[] container) {
        if (size == 0) {
            container = Arrays.copyOf(container, container.length + 1);
        } else {
            container = Arrays.copyOf(container, container.length * 2);
        }
        return container;

    }
    private void check(int index) {
       Objects.checkIndex(index, container.length);
    }

    @Override
    public T set(int index, T newValue) {
        check(index);
        T value = container[index];
        container[index] = newValue;
        return value;
    }

    @Override
    public T remove(int index) {
        check(index);
        T value = container[index];
        container[index] = null;
        System.arraycopy(
                container,
                index + 1,
                container,
                index,
                container.length - index - 1);
        container[container.length - 1] = null;
        size--;
        modCount--;
        return value;
    }

    @Override
    public T get(int index) {
        check(index);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[point++];
            }

        };
    }

    public static void main(String[] args) {
        SimpleArrayList<Integer> test = new SimpleArrayList<>(0);
        test.add(5);
        test.add(6);
        test.add(7);
        System.out.println(test.iterator().hasNext());

    }
}