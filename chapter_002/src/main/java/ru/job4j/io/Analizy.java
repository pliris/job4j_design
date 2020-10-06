package ru.job4j.io;

import java.io.*;
import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

public class Analizy {
    public void unavailable(String source, String target) {
        StringJoiner joiner = new StringJoiner(";", "", ";" + System.lineSeparator());
        String str;
        String first = null;
        try (FileReader fReader = new FileReader(source);
             BufferedReader bReader = new BufferedReader(fReader);
             FileOutputStream outStream = new FileOutputStream(target);
             BufferedOutputStream bOut = new BufferedOutputStream(outStream);
             PrintWriter pWriter = new PrintWriter(bOut);
             ) {
            while ((str = bReader.readLine()) != null) {
                if (first == null) {
                    if (str.contains("400") || str.contains("500")) {
                        first = str;
                    }
                } else {
                    if (!str.contains("400") && !str.contains("500")) {
                        joiner.add(first.substring(first.indexOf(" ")));
                        joiner.add(str.substring(str.indexOf(" ")));
                        first = null;
                    }
                }
            }
            pWriter.write(joiner.toString());
            pWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "C:\\projects\\job4j_design\\source.txt";
        String target = "C:\\projects\\job4j_design\\target.txt";
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);

    }
}