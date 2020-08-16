package ru.job4j.generic;

public class Role extends Base {
    String id;

    protected Role(String id) {
        super(id);
    }
    public String getId() {
        return id;
    }
}
