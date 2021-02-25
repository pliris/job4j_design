package ru.job4j.menu;

import java.util.LinkedList;
import java.util.List;

public class MenuItem implements Item, ActionItem {
    String name;
    ActionItem actionItem;
    List<MenuItem> child = new LinkedList<>();

    public MenuItem(String name, ActionItem actionItem) {
        this.name = name;
        this.actionItem = actionItem;

    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void action() {
        this.getActionItem().action();
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


    public ActionItem getActionItem() {
        return actionItem;
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
