package ru.job4j.exam;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenAdd3UsersThen1Edit() {
        List<Analyze.User> first = Arrays.asList(new Analyze.User(1, "Nikita"),
                new Analyze.User(2, "Alexey"),
                new Analyze.User(3, "Ivan"));
        List<Analyze.User> second = Arrays.asList(new Analyze.User(1, "Petr"),
                new Analyze.User(3, "Ivan"),
                new Analyze.User(4, "Anton"),
                new Analyze.User(5,"Anna")
                );
        Analyze analyze = new Analyze();
        Analyze.Info info = analyze.diff(first, second);
        assertThat(info.changed, is(1));
        assertThat(info.deleted, is(1));
        assertThat(info.added, is(2));
    }

}