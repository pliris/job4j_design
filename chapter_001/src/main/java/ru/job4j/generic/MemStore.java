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
        T model = null;
//        return mem.stream()
//                .filter(t -> t.getId().equals(id))
//                .findFirst().orElse(null);
    while (mem.iterator().hasNext()) {
        model = mem.iterator().next();
        if (model.getId().equals(id)) {
            break;
        }
    }
    return model;
    }

    @Override
    public Iterator<T> iterator() {
        return new SimpleArrayIterator(mem.toArray());
    }
}