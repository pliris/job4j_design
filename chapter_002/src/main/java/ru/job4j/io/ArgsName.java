package ru.job4j.io;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ArgsName {

    private Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(key + " key not found");
        }

        return values.get(key);
    }
/**
 * Метод разбивает параметры на ключ, значение
 * @param args - массив параметров
 */
    private void parse(String[] args) {
       Arrays.stream(args)
               .map(s -> s.substring(1))
               .map(s -> s.split("="))
               .forEach(s -> {
                   if (s.length != 2) {
                       throw new IllegalArgumentException("Некорректная разбивка на ключ, значение");
                   }
                   this.values.put(s[0], s[1]);
               });
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}