package ru.job4j.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T>, Iterable<T> {

    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        if (mem.contains(id)) {
           mem.indexOf(id)
        }
        return mem.i;
    }

    @Override
    public boolean delete(String id) {
        return mem.remove(id);
    }

    @Override
    public T findById(String id) {
        T model = null;
        if (mem.contains(id)) {


        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}