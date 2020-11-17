package ru.job4j.serialization;

public class JSonBed {
    private String color;

    public JSonBed(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bed{"
                + "color='" + color + '\''
                + '}';
    }
}
