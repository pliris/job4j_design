package ru.job4j.generic;

public class User extends Base {
    String id;

    protected User(String id) {
        super(id);
    }
    public String getId() {
        return id;
    }
}
