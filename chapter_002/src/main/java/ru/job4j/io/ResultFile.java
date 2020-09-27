package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("file.txt", true)) {
            int size = 9;
            String str;
                for (int i = 1; i <= size; i++) {
                    for (int y = 1; y <= size; y++) {
                        str = Integer.toString(i * y);
                       out.write(str.getBytes());
                    }
                }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
