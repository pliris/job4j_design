package ru.job4j.menu;

import java.util.LinkedList;
import java.util.List;

public class GeneralMenu implements Menu {
    List<MenuItem> list = new LinkedList<>();

    public void addRoot(MenuItem item) {
        this.list.add(item);
    }

    @Override
    public String printMenu() {
        StringBuilder sb = new StringBuilder();
        for (MenuItem item : list) {
           sb.append(item.getName()).append(System.lineSeparator());
           this.recurChild(item, sb);
        }
       return sb.toString();
    }

    private void recurChild(MenuItem item, StringBuilder sb) {
            if (item.getChild().size() != 0) {
                for (MenuItem itemChild : item.getChild()) {
                   sb.append(itemChild.getName()).append(System.lineSeparator());
                    this.recurChild(itemChild, sb);
            }
        }
    }
}
