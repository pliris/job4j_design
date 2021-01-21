package ru.job4j.cache;

import java.util.List;

public abstract class Cache {
    private String name;

    public abstract List<String> get(String name);
}
