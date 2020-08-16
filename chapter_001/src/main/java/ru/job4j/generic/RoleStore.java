package ru.job4j.generic;

public class RoleStore implements Store<Role> {

    private final Store<Role> store = new MemStore<Role>();

    @Override
    public void add(Role model) {
        store.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return store.delete(id);
    }

    @Override
    public Role findById(String id) {
        return null;
    }
}
