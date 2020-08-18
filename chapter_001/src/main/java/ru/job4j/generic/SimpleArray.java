package ru.job4j.generic;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private int position = 0;
    private int size;

    public SimpleArray(int size) {
        this.array = (T[]) new Object[size];
    }

    public boolean add(T model) {
        boolean rsl = false;
        if (position < array.length - 1) {
            array[position++] = model;
            this.size++;
            rsl = true;
        }
        return rsl;
    }

    public boolean set(int index, T model) {
        boolean rsl = false;
            if (index == Objects.checkIndex(index, position)) {
                array[index] = model;
                rsl = true;
            }
            return rsl;
    }

    public boolean remove(int index) {
        boolean rsl = false;
        if (index == Objects.checkIndex(index, position)) {
            System.arraycopy(array, index + 1, array, index, position);
            position--;
            rsl = true;
            this.size--;
            }

        return rsl;
    }

    public T get(int index) {
        T model = null;
        if (index == Objects.checkIndex(index, position)) {
            model = array[index];
        }
        return model;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(array, size);
    }
}
