package ru.job4j.collection;

import java.util.Objects;

public class HashPair<K, V> implements Pair<K, V> {
    private NodePair<K, V>[] table;
    private int size;
    private int loadTable;

    public HashPair() {
        this.table = new NodePair[16];
        this.size = 16;
    }

    static int hash(K key) {
        int hash = 1;
        hash = 31 * hash + key.hashCode();
        return hash;
    }
    private void incrementTable() {

    }

    @Override
    public boolean insert(K key, V value) {
        NodePair<K, V> nodePair
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean delete(K key) {
        return false;
    }


    private static class NodePair<K, V> {
        private NodePair<K, V> next;
        private int size;
        private int hash;
        private K key;
        private V value;

        public NodePair(K key, V value, NodePair<K, V> next) {
            this.hash = this.hashCode();
            this.key = key;
            this.value = value;
            this.next = next;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodePair<?, ?> nodePair = (NodePair<?, ?>) o;
            return key.equals(nodePair.key) &&
                    value.equals(nodePair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }
}
