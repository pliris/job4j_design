package ru.job4j.ood.srp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InPutAndOutPut {
    public List<String> readText(File file) {
        List<String> list = new ArrayList<>();
       try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
           list = buffer.lines().collect(Collectors.toList());
       } catch (Exception e) {
           e.printStackTrace();
       }
       return list;
    }

    public void writeText(File file, List<String> list) {
        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(file))) {
            for (String s : list) {
                buffer.write(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
