package ru.job4j.collections;

import ru.job4j.generics.Node;

import java.util.Iterator;

public class SimpleLinkedList<E> implements List<E> {
    @Override
    public void add(E value) {
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1, null);
        Node n2 = new Node(2, n1);
        Node n3 = new Node(3, n2);
        Node[] nodeList = new Node[3];
        nodeList[0] = n1;
        nodeList[1] = n2;
        nodeList[2] = n3;
        System.out.println(nodeList[0].getData());
    }
}
