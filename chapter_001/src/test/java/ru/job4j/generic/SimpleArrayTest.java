package ru.job4j.generic;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void WhenAdd3ElementsThenGet0And2Elements() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(10);
        array.add(11);
        array.add(23);
        array.add(45);
        assertThat(array.get(0), is(11));
        assertThat(array.get(2), is(45));
    }

    @Test
    public void WhenAdd2ElementThenGetReturnFalse() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(1);
        array.add(11);
        assertThat(array.add(45), is(false));
    }

    @Test
    public void WhenSet1ElementsThenGetThisElements() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(3);
        array.add(11);
        array.add(23);
        array.add(45);
        array.set(1, 66);
        assertThat(array.get(1), is(66));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void WhenSet1ElementsOutOfIndexThenReturnFalse() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(3);
        array.add(11);
        array.add(23);
        array.add(45);
        assertThat(array.set(3, 66), is(false));
    }

    @Test
    public void WhenRemove1ElementsThenGetThisElement() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(10);
        array.add(11);
        array.add(23);
        array.add(45);
        array.remove(1);
        assertThat(array.get(1), is(45));
    }

    @Test
    public void iterator() {
        SimpleArray<Integer> array = new SimpleArray<Integer>(10);
        array.add(11);
        array.add(23);
        array.add(45);
        Iterator<Integer> it = array.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(11));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(23));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(45));
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void WhenAdd3StringThenGet0And2Elements() {
        SimpleArray<String> array = new SimpleArray<String>(10);
        array.add("a");
        array.add("b");
        array.add("c");
        assertThat(array.get(0), is("a"));
        assertThat(array.get(2), is("c"));
    }

    @Test
    public void WhenAdd2StringThenGetReturnFalse() {
        SimpleArray<String> array = new SimpleArray<String>(1);
        array.add("a");
        assertThat(array.add("a"), is(false));
    }

    @Test
    public void WhenSet1StringThenGetThisString() {
        SimpleArray<String> array = new SimpleArray<String>(3);
        array.add("a");
        array.add("b");
        array.add("c");
        array.set(1, "d");
        assertThat(array.get(1), is("d"));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void WhenSet1StringOutOfIndexThenReturnFalse() {
        SimpleArray<String> array = new SimpleArray<String>(3);
        array.add("a");
        array.add("b");
        array.add("c");
        assertThat(array.set(3, "a"), is(false));
    }

    @Test
    public void WhenRemove1StringThenGet3String() {
        SimpleArray<String> array = new SimpleArray<String>(10);
        array.add("a");
        array.add("b");
        array.add("c");
        array.remove(1);
        assertThat(array.get(1), is("c"));
    }
}