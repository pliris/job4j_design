package ru.job4j.io;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenInput2UnavalThen2Period() throws IOException {
        String source = "C:\\projects\\job4j_design\\source.txt";
        String target = "C:\\projects\\job4j_design\\target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);
        FileReader fReader = new FileReader(target);
        BufferedReader bReader = new BufferedReader(fReader);
        StringBuilder actual = new StringBuilder();
        actual.append(bReader.readLine());
        StringBuilder exp = new StringBuilder();
        exp.append(" 10:57:01; 10:59:01; 11:01:02; 11:02:02;");
        assertEquals(exp, actual);

    }

}