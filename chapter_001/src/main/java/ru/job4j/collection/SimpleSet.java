package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray array = new SimpleArray();


    public void add(T model) {
        for (T t : array) {

        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
