package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class HashPairTest {

    @Test
    public void insert3IntThenGet1() {
        HashPair<Integer, String> hashPair = new HashPair<>();
        hashPair.insert(1, "First");
        hashPair.insert(2, "Second");
        hashPair.insert(3, "Third");
        assertThat(hashPair.get(3), is("Third"));
    }

    @Test
    public void insert2IntDelete1ThenTrue() {
        HashPair<Integer, String> hashPair = new HashPair<>();
        hashPair.insert(1, "First");
        hashPair.insert(2, "Second");
        assertThat(hashPair.delete(2), is(true));
    }

    @Test
    public void insert2IntAndInsert1ThenFalse() {
        HashPair<Integer, String> hashPair = new HashPair<>();
        hashPair.insert(1,"First");
        hashPair.insert(2,"Second");
        assertThat(hashPair.insert(1, "First"), is(false));
    }

    @Test
    public void insert3IntThenIterator3IntAndTrueAnd1False() {
        HashPair<Integer, String> hashPair = new HashPair<>();
        hashPair.insert(1,"First");
        hashPair.insert(2,"Second");
        hashPair.insert(3,"Third");
        Iterator<Integer> it = hashPair.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(false));
    }





}