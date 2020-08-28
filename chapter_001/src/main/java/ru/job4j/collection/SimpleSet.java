package ru.job4j.collection;

import ru.job4j.generic.SimpleArrayIterator;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray<T> array = new SimpleArray();
    private int size = 0;


    public void add(T model) {
        if (!contains(model)) {
            array.add(model);
            size++;
        }
    }

    private boolean contains(T model) {
        boolean equal = false;
        for (T t : array) {
            if (Objects.equals(model, t)) {
                equal = true;
                break;
            }
        }
        return equal;
    }

    @Override
    public Iterator<T> iterator() {
        return this.array.iterator();
    }
}

