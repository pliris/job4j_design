package ru.job4j.collection;

import java.util.Iterator;

public class SimpleLinked<T> implements Iterable<T> {
    int size = 0;
    Node<T> first;
    Node<T> last;
    int modCount = 0;

    public SimpleLinked() {
    }

    public void add(T value) {
        Node<T> newNode;
        if (size == 0) {
            newNode = new Node<>(value, this.first, this.last);
        } else {
            newNode = new Node<>(value, this.last, this.last);
        }
        size++;
        modCount++;
    }

    public T get(int index) {

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
        return null;
    }
}
