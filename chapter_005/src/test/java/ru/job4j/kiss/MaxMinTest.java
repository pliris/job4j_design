package ru.job4j.kiss;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void checkMaxInt() {
        List<Integer> list = Arrays.asList(1, 6, 4, 9, 2);
        Comparator comparator = new MyComparator();
        MaxMin max = new MaxMin();
        assertThat(max.max(list, comparator), is(9));
    }


    @Test
    public void checkMinInt() {
        List<Integer> list = Arrays.asList(1, 6, 4, 9, 0, 1);
        Comparator comparator = new MyComparator();
        MaxMin max = new MaxMin();
        assertThat(max.min(list, comparator), is(0));
    }

    @Test
    public void checkMaxString() {
        List<String> list = Arrays.asList("FDG", "DER", "ABC");
        Comparator comparator = new MyCompString();
        MaxMin max = new MaxMin();
        assertThat(max.max(list, comparator), is("FDG"));
    }

    @Test
    public void checkMinString() {
        List<String> list = Arrays.asList("FDG", "DER", "ABC");
        Comparator comparator = new MyCompString();
        MaxMin max = new MaxMin();
        assertThat(max.min(list, comparator), is("ABC"));

    }
}