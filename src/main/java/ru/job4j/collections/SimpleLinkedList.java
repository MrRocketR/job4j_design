package ru.job4j.collections;

import ru.job4j.generics.Node;

import java.util.*;

public class SimpleLinkedList<E> implements List<E> {

    private int size;
    private int modCount;
     private Node<E> first = null;
     private Node<E> last = null;


    @Override
    public void add(E value) {
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
            size++;
            modCount++;
        } else {
            l.next = newNode;
            size++;
            modCount++;
        }
         }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> outPut = first;
        for (int i = 0; i < index; i++) {
            outPut = outPut.next;
        }
        return outPut.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            SimpleLinkedList.Node<E> iteratorNode = first;
            int expectedModCount = modCount;
            int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorNode.next != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (index != 0) {
                    iteratorNode = iteratorNode.next;
                    index++;
                } else {
                    index++;
                }
                return iteratorNode.item;
            }

        };
    }

        private static class Node<E> {
            E item;
            Node<E> next;
            Node<E> prev;

            Node(Node<E> prev, E element, Node<E> next) {
                this.item = element;
                this.next = next;
                this.prev = prev;
            }
        }
}
