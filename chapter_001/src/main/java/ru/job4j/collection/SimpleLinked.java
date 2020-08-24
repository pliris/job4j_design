package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinked<T> implements Iterable<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;
    private int modCount = 0;

    public SimpleLinked() {
    }

    public void add(T value) {
        Node<T> newNode;
        if (size == 0) {
            newNode = new Node<T>(value, null, null);
            this.first = newNode;
        } else {
            newNode = new Node<>(value, this.last, null);
            this.last.next = newNode;
        }
        this.last = newNode;
        size++;
        modCount++;
    }

    public T get(int index) {
        Node<T> n = this.first;
        Objects.checkIndex(index, size);
        for (int i = 0; i < index; i++) {
             n = n.next;
        }
        return n.item;
    }

    private static class Node<T> {
     T item;
     Node<T> back;
     Node<T> next;

       public Node(T item, Node<T> back, Node<T> next) {
        this.item = item;
        this.back = back;
        this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private final int expectedModCount = SimpleLinked.this.modCount;
            private Node<T> n = SimpleLinked.this.first;
            private final int size = SimpleLinked.this.size;
            private int cursor = 0;

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
                T model = n.item;
                n = n.next;
                cursor++;
                return model;
            }
        };
    }
}
