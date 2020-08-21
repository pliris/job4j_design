package ru.job4j.collection;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class SimpleLinkedTest {

    @Test
    public void whenAdd2IntThenGet1Int() {
        SimpleLinked<Integer> linked = new SimpleLinked();
        linked.add(1);
        linked.add(2);
        assertThat(linked.get(1), is(2));

    }

    @Test
    public void whenAdd3StringThenIteratorReturn2TrueAnd3String() {
        SimpleLinked<String> linked = new SimpleLinked<>();
        linked.add("aaa");
        linked.add("bbb");
        linked.add("ccc");
        Iterator<String> it = linked.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("aaa"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("bbb"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("ccc"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNotAdd3StringThenNoSuchElements() {
        SimpleLinked<String> linked = new SimpleLinked<>();
        Iterator<String> it = linked.iterator();
        it.next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinked<String> linked = new SimpleLinked<>();
        linked.add("aaa");
        Iterator<String> it = linked.iterator();
        linked.add("bbb");
        it.hasNext();
    }

}