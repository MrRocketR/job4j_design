package ru.job4j.collections;

import ru.job4j.generics.Node;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SimpleLinkedList<E> implements List<E> {

    private int size;
    private int modCount;
    private Node<E> first = null;


    @Override
    public void add(E value) {
        if (size == 0) {
            Node newNode  = new Node(value);
            first = newNode;
            size++;
            modCount++;
        } else {
            Node newNode  = new Node(value);
            first.next = newNode;
            size++;
            modCount++;
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

        public Node(E element) {
            this.element = element;
        }
    }

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(2);
        list.add(3);
        System.out.println(list.size);
        System.out.println(list.first);



    }
}
