package ru.job4j.menu;

public class SendAction implements ActionItem {
    @Override
    public void action() {
        System.out.println("Send SMS...");
    }
}
