package ru.job4j.generic;

import java.util.Iterator;

public class IteratorMemStore<T> implements Iterator<T> {
    T[] store;
    int position = 0;

    public IteratorMemStore(T[] store) {
        this.store = store;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
}
