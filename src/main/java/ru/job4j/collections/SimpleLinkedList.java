package ru.job4j.collections;

import ru.job4j.generics.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size;
    private int modCount;
    public ArrayList<Node> nodeList = new ArrayList<Node>();
    Node header = null;


    @Override
    public void add(E value) {
        if (size == 0) {
            Node<E> newNode = new Node<>(value, null, null);
            modCount++;
        } else {
            Node<E> newNode = new Node<>(value, header.next, header.prev);
        }


    }


    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
    private static class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> next, Node<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}
