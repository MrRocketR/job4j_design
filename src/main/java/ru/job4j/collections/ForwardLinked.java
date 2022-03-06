package ru.job4j.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public T deleteFirst() {
        T value;
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> temp = head.next;
            head.next = null;
            value = head.value;
            head.value = null;
            head = null;
            head = temp;
        }

        return value;
    }
    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, null);
        node.next = head;
        head = node;
    }


    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ForwardLinked fl = new ForwardLinked();
        fl.add(2);
        fl.add(14);
        System.out.println(fl.head.value);
        System.out.println(fl.deleteFirst());
    }
}


