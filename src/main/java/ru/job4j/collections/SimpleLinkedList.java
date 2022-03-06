package ru.job4j.collections;



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
            Node<E> iteratorNode = new Node<>(null, null, first);
            final int expectedModCount = modCount;
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
                iteratorNode = iteratorNode.next;
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

    public static void main(String[] args) {
        SimpleLinkedList<Integer> list = new SimpleLinkedList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(10);
        Iterator<Integer> iterator = list.iterator();
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
    }
}
