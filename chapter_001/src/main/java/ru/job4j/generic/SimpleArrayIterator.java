package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
        private T[] array;
        private int position = 0;
        private int size;

        public SimpleArrayIterator(T[] array, int size) {
            this.array = array;
            this.size = size;
        }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
        return array[position++];
    }
}
