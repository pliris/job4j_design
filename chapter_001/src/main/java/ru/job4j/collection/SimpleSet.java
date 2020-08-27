package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<T> implements Iterable<T> {
    SimpleArray<T> array = new SimpleArray();
    private int size = 0;


    public void add(T model) {
        boolean equal = false;
        for (T t : array) {
            if (t.equals(model)) {
                equal = true;
            }
        }
        if (!equal) {
            array.add(model);
            size++;
        }
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            private SimpleArray container = SimpleSet.this.array;
            private int cursor = 0;
            private int size = SimpleSet.this.size;

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array.get(cursor++);
            }
        };
    }
}

