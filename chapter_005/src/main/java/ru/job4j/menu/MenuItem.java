package ru.job4j.menu;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MenuItem implements Item {
    String name;
    List<MenuItem> child = new LinkedList<>();
    Map<String, ActionItem> actions;

    public MenuItem(String name, Map<String, ActionItem> actions) {
        this.name = name;
        this.actions = actions;

    }

    public ActionItem choose(String name) {
        return this.actions.get(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void addItem(MenuItem item) {
        this.child.add(item);
    }

    public String getName() {
        return name;
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
