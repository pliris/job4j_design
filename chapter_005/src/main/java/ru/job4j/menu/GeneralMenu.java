package ru.job4j.menu;

import java.util.LinkedList;
import java.util.List;

public class GeneralMenu implements Menu {
    List<MenuItem> list = new LinkedList<>();

    public void addRoot(MenuItem item) {
        this.list.add(item);
    }

    @Override
    public void printMenu() {
        for (MenuItem item : list) {
            item.action();
            this.recurChild(item);

        }
    }

    private void recurChild(MenuItem item) {
            if (item.getChild().size() != 0) {
                for (MenuItem itemChild : item.getChild()) {
                    itemChild.action();
                    recurChild(itemChild);
            }
        }
    }
}
