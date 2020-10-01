package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> list = new ArrayList<>();
        try (FileReader fReader = new FileReader(file);
             BufferedReader bReader = new BufferedReader(fReader);) {
           bReader.lines().filter(s -> s.contains("404")).forEach(list::add);
       } catch (Exception e) {
           e.printStackTrace();
       }
        return list;
    }

    public static void save(List<String> log, String file) {
       try (FileOutputStream outStream = new FileOutputStream(file);
            BufferedOutputStream bufferOutStream = new BufferedOutputStream(outStream);
            PrintWriter pWriter = new PrintWriter(bufferOutStream);) {
           List<String> list = new ArrayList<>(log);
            for (String str : list) {
               pWriter.write(str + System.lineSeparator());
               pWriter.flush();
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        save(log, "404.txt");
        System.out.print(log);
    }
}