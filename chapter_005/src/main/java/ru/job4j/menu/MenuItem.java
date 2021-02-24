package ru.job4j.menu;

import java.util.LinkedList;
import java.util.List;

public class MenuItem implements Item, ActionItem {
    String name;
    List<MenuItem> child = new LinkedList<>();

    public MenuItem(String name) {
        this.name = name;

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void action() {
        System.out.println(this.name);
    }

//    @Override
    public void addItem(MenuItem item) {
        this.child.add(item);
    }

    public List<MenuItem> getChild() {
        return child;
    }

    @Override
    public String toString() {
        return "MenuItem{"
                + "name='"
                + name
                + '\''
                + '}';
    }
}
