package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (FileReader fReader = new FileReader(path);
             BufferedReader bReader = new BufferedReader(fReader)) {
              this.values = bReader.lines().filter(s -> !s.contains("##"))
                   .filter(s -> !s.contains(System.lineSeparator())).filter(s -> !s.equals(""))
                     .map(s -> s.split("="))
                     .collect(Collectors.toMap(s -> s[0], s -> s[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return this.values.get(key);
        //throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("./app.properties");
        config.load();
        System.out.println(config.value("jdbc.username"));
    }
}