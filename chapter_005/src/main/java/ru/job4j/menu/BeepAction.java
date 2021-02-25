package ru.job4j.menu;

public class BeepAction implements ActionItem {
    @Override
    public void action() {
        System.out.println("Beep!!!");
    }
}
