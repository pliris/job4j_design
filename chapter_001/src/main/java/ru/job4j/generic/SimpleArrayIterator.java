package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayIterator<T> implements Iterator<T> {
        private T[] array;
        private int position = 0;
        private int cursor = 0;

        public SimpleArrayIterator(T[] array) {
            this.array = array;
        }

    @Override
    public boolean hasNext() {
        return position < array.length && array[position] != null;
    }

    @Override
    public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
        return array[position++];
    }
}
