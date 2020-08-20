package ru.job4j.generic;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public final class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        boolean done = false;
        int index = this.findIndexById(id);
        if (index >= 0) {
            mem.set(index, model);
            done = true;
        }
        return done;
    }

    @Override
    public boolean delete(String id) {
        int index = this.findIndexById(id);
        if (index != -1) {
            mem.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public T findById(String id) {
        return mem.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst().orElse(null);
    }

    private int findIndexById(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            T t = mem.get(i);
            if (t.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}