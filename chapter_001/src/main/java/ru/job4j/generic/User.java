package ru.job4j.generic;

public class User extends Base {


    protected User(String id) {
        super(id);
    }
    public String getId() {
        return super.getId();
    }
}
