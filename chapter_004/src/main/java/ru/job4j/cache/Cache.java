package ru.job4j.cache;

import java.util.List;

public abstract class Cache {
    private String name;

    public abstract String get(String name);
}
