package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container;
    protected int modCount = 0;
    private int position = 0;
    private int size = 10;

    public SimpleArray() {
        this.container = (T[]) new Object[10];
    }

    public SimpleArray(int size) {
        this.container = (T[]) new Object[size];
        this.size = size;
    }

    public T get(int index) {
        Objects.checkIndex(index, position);
        return container[index];
    }

    public void add(T model) {
        if (position >= size) {
            this.incrementContainer(container);
        }
        container[position++] = model;
        modCount++;
    }

    private T[] incrementContainer(T[] container) {
        this.container = Arrays.copyOf(container, size++);
        return container;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private T[] array = SimpleArray.this.container;
            private int expectedModCount = SimpleArray.this.modCount;
            private int cursor = 0;
            private int size = SimpleArray.this.position;

            @Override
            public boolean hasNext() {
                if (!checkModification(modCount)) {
                    throw new ConcurrentModificationException();
                }
                return cursor < size;
            }

            private boolean checkModification(int modCount) {
                return expectedModCount == modCount;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[cursor++];
            }
        };
    }
}
