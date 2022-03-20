package ru.job4j.map;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        expand();
        boolean r = false;
        int hashCode = key.hashCode();
        int hash = hash(hashCode);
        int index = indexFor(hash);
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            r = true;
            count++;
            modCount++;
        }
        return r;
    }

    private int hash(int hashCode) {
        int hash = 0;
        return (hashCode == 0) ? 0 : (hashCode ^ (hash >>> 16));
    }

    private int indexFor(int hash) {
        int index = (capacity - 1) & hash;
        return index;
    }

    private void expand() {
        if (count >= capacity * LOAD_FACTOR) {
            capacity = capacity * 2;
            reHash();
        }
    }
    private void reHash() {
        MapEntry<K, V>[] temp = new MapEntry[capacity];
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] != null) {
                K key = table[i].key;
                int hashCode = key.hashCode();
                int hash = hash(hashCode);
                int index = indexFor(hash);
                if (temp[index] == null) {
                    table[index] = table[i];
                }
            }
        }
        table = temp;
    }

    @Override
    public V get(K key) {
        V r = null;
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] != null && table[i].key.equals(key)) {
                r = table[i].value;
                break;
            }
        }
        return r;
    }

    @Override
    public boolean remove(K key) {
        boolean r = false;
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] != null && table[i].key.equals(key)) {
                table[i] = null;
                r = true;
                modCount++;
                count--;
                break;
            }
        }
        return r;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            int expectedModCount = modCount;
            private int index = 0;
            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (index < table.length && table[index] == null) {
                    index++;
                }
                return index < table.length;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };

    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}