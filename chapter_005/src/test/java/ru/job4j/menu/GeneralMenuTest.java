package ru.job4j.menu;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneralMenuTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void restoreStreams() {
        System.setOut(standardOut);
    }

    @Test
    public void menu() {
        GeneralMenu menu = new GeneralMenu();
        ActionItem beep = new BeepAction();
        ActionItem send = new SendAction();
        MenuItem item1 = new MenuItem("Task 1.", beep);
        MenuItem item11 = new MenuItem("Task 1.1", beep);
        MenuItem item111 = new MenuItem("Task 1.1.1", send);
        MenuItem item112 = new MenuItem("Task 1.1.2", send);
        MenuItem item12 = new MenuItem("Task 1.2", send);
        MenuItem item2 = new MenuItem("Task 2", beep);
        item1.addItem(item11);
        item11.addItem(item111);
        item11.addItem(item112);
        item1.addItem(item12);
        menu.addRoot(item1);
        menu.addRoot(item2);
        StringBuilder sb = new StringBuilder();
        sb.append("Task 1." + System.lineSeparator())
                .append("Task 1.1" + System.lineSeparator())
                .append("Task 1.1.1" + System.lineSeparator())
                .append("Task 1.1.2" + System.lineSeparator())
                .append("Task 1.2" + System.lineSeparator())
                .append("Task 2" + System.lineSeparator());
        System.out.print(menu.printMenu());
        assertThat(outputStreamCaptor.toString(), is(sb.toString()));
    }

    @Test
    public void action() {
        GeneralMenu menu = new GeneralMenu();
        ActionItem beep = new BeepAction();
        ActionItem send = new SendAction();
        MenuItem item1 = new MenuItem("Task 1.", beep);
        MenuItem item11 = new MenuItem("Task 1.1", beep);
        MenuItem item111 = new MenuItem("Task 1.1.1", send);
        MenuItem item112 = new MenuItem("Task 1.1.2", send);
        MenuItem item12 = new MenuItem("Task 1.2", send);
        MenuItem item2 = new MenuItem("Task 2", beep);
        item1.addItem(item11);
        item11.addItem(item111);
        item11.addItem(item112);
        item1.addItem(item12);
        menu.addRoot(item1);
        menu.addRoot(item2);
        String exp = "Send SMS..." + System.lineSeparator();
        item111.action();
        assertThat(outputStreamCaptor.toString(), is(exp));
    }

}