package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class HashPair<K, V> implements Pair<K, V>, Iterable<K> {
    private NodePair<K, V>[] table;
    private int size;
    private int numbers;
    private double loadTable;
    private int modCount = 0;

    public HashPair() {
        this.table = new NodePair[16];
        this.size = 16;
        this.loadTable = 0.75;
    }

    private static int hash(Object key) {
        int hash = key.hashCode();
        return (key == null) ? 0 : hash ^ hash >>> 16;
    }

    private int bucketIndex(int hash) {
        int index;
        index = (size - 1) & hash;
        return index;
    }

    private void checkSizeTable() {
        if (numbers + 1 >= size * loadTable) {
            size = size * 2;
            NodePair<K, V>[] tempTable = new NodePair[size];
            for (int i = 0; i < table.length; i++) {
                if (table[i] != null) {
                    int index = this.bucketIndex(table[i].hash);
                    tempTable[index] = table[i];
                }
            }
            table = tempTable;
        }
    }

    @Override
    public boolean insert(K key, V value) {
        NodePair<K, V> nodePair;
        int hash = hash(key);
        int index = bucketIndex(hash(key));
        checkSizeTable();
        if (table[index] == null) {
            table[index] = new NodePair<>(key, value, null, hash);
            numbers++;
            modCount++;
            return true;
        }
        if (Objects.equals(table[index].key, key)) {
            table[index].value = value;
            numbers++;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public V get(K key) {
        int index = bucketIndex(hash(key));
        if (Objects.equals(table[index].key, key)) {
            return table[index].value;
        }
       return null;
    }

    @Override
    public boolean delete(K key) {
        int index = bucketIndex(hash(key));
        if (Objects.equals(table[index].key, key)) {
            table[index] = null;
            numbers--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private NodePair<K, V> next;
            private int cursor = 0;
            private int size = HashPair.this.size;
            private final int expectedModCount = HashPair.this.modCount;

            @Override
            public boolean hasNext() {
                if (!checkModification(modCount)) {
                    throw new ConcurrentModificationException();
                }
               while (next == null && cursor < size) {
                   next = table[cursor++];
               }
                return next != null;
            }

            private boolean checkModification(int modCount) {
                return expectedModCount == modCount;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                K key = next.key;
                next = next.next;
                return key;
            }
        };
    }

    private static class NodePair<K, V> {
        private NodePair<K, V> next;
        private int size;
        private int hash;
        private K key;
        private V value;

        public NodePair(K key, V value, NodePair<K, V> next, int hash) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            NodePair<?, ?> nodePair = (NodePair<?, ?>) o;
            return key.equals(nodePair.key)
                    && value.equals(nodePair.value);
        }

        @Override
        public int hashCode() {
            int hash = 1;
            hash = 31 * hash + key.hashCode();
            return hash;
        }
    }
}
