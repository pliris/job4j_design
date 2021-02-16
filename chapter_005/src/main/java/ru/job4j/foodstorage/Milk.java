package ru.job4j.foodstorage;

import java.util.Date;

public class Milk extends Food {
    Double volume;

    public Milk(String name, Date expireDate, Date createDate, Double price, Integer discount, Double volume) {
        super(name, expireDate, createDate, price, discount);
        this.volume = volume;
    }
}
