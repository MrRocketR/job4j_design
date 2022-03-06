package ru.job4j.collections;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        return null;
    }

    public void push(T value) {
        if (in.pop() != null) {
            in.push(value);
        }
    }
}