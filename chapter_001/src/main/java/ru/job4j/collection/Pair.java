package ru.job4j.collection;

public interface Pair<K, V> {
    boolean insert(K key, V value);
    V get(K key);
    boolean delete(K key);
}
