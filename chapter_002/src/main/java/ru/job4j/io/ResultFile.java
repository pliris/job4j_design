package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("file.txt", true)) {
            int size = 9;
            StringBuilder strB = new StringBuilder();
                for (int i = 1; i <= size; i++) {
                    for (int y = 1; y <= size; y++) {
                        strB.append(i + " * " + y + " =" + i * y + System.lineSeparator());
                    }
                }
            out.write(strB.toString().getBytes());
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
