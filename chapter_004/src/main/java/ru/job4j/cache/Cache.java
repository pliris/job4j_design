package ru.job4j.cache;

public abstract class Cache {
    private String key;

    public abstract void setObject(String key);
}
