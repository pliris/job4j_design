package ru.job4j.collection;

import java.util.Iterator;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T pop() {
        while (in != null) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public void push(T value) {
        while (out != null) {
            in.push(out.pop());
        }
        in.push(value);
    }
}