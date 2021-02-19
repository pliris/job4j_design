package ru.job4j.parking;

public class Truck extends Vehicle {
    private int size;

    public Truck(String type, String name, String id, int size) {
        super(type, name, id);
        this.size = size;

    }
}
