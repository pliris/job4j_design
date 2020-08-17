package ru.job4j.generic;

import java.util.ArrayList;
import java.util.List;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean done = false;
        int i = mem.indexOf(this.findById(id));
        if (i >= 0) {
            mem.set(i, model);
            done = true;
        }
        return done;
    }

    @Override
    public boolean delete(String id) {
        T model = this.findById(id);
        return mem.remove(model);
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
    }
}