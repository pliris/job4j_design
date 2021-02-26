package ru.job4j.menu;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

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
        Map<String, ActionItem> map = new HashMap<>();
        map.put("Beep 1.", beep);
        map.put("Beep 1.1", beep);
        map.put("Send 1.1.1", send);
        map.put("Send 1.1.2", send);
        map.put("Send 1.2", send);
        map.put("Beep 2", beep);
        MenuItem item1 = new MenuItem("Task 1.", map);
        MenuItem item11 = new MenuItem("Task 1.1", map);
        MenuItem item111 = new MenuItem("Task 1.1.1", map);
        MenuItem item112 = new MenuItem("Task 1.1.2", map);
        MenuItem item12 = new MenuItem("Task 1.2", map);
        MenuItem item2 = new MenuItem("Task 2", map);
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
        Map<String, ActionItem> map = new HashMap<>();
        map.put("Beep 1.", beep);
        map.put("Beep 1.1", beep);
        map.put("Send 1.1.1", send);
        map.put("Send 1.1.2", send);
        map.put("Send 1.2", send);
        map.put("Beep 2", beep);
        MenuItem item1 = new MenuItem("Beep 1.", map);
        MenuItem item11 = new MenuItem("Beep 1.1", map);
        MenuItem item111 = new MenuItem("Send 1.1.1", map);
        MenuItem item112 = new MenuItem("Send 1.1.2", map);
        MenuItem item12 = new MenuItem("Send 1.2", map);
        MenuItem item2 = new MenuItem("Beep 2", map);
        item1.addItem(item11);
        item11.addItem(item111);
        item11.addItem(item112);
        item1.addItem(item12);
        menu.addRoot(item1);
        menu.addRoot(item2);
        String exp = "Send SMS..." + System.lineSeparator();
        item111.choose("Send 1.1.1").action();
        assertThat(outputStreamCaptor.toString(), is(exp));
    }

}