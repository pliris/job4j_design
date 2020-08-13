package ru.job4j.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void add() {
        SimpleArray<Integer>[] array = new SimpleArray<>[10];
        array.add(10);
        array.add(23);
    }

    @Test
    public void set() {
    }

    @Test
    public void remove() {
    }

    @Test
    public void get() {
    }

    @Test
    public void iterator() {
    }
}