package ru.job4j.serialization;

public class Bed {
    private String color;

    public Bed(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bed{"
                + "color='" + color + '\''
                + '}';
    }
}
