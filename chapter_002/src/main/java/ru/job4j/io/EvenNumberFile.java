package ru.job4j.io;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class EvenNumberFile {

    public static void main(String[] args) throws FileNotFoundException {
       try {
           FileInputStream input = new FileInputStream("even.txt");
           StringBuilder sb = new StringBuilder();
           int i;
           int num;
           while ((i = input.read()) != -1) {
                sb.append((char) i);

           }
           String[] array = sb.toString().split(System.lineSeparator());
           for (String str : array) {
               num = Integer.parseInt(str);
               if (num % 2 == 0) {
                   System.out.println(Integer.parseInt(str));
               }
           }


       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}
