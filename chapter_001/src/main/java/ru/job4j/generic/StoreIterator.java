package ru.job4j.generic;

import java.util.Iterator;
import java.util.List;

public class StoreIterator<T> implements Iterator<T> {
    List<T> store;

    public StoreIterator(T[] store) {
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
