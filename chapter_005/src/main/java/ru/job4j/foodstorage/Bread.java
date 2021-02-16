package ru.job4j.foodstorage;

import java.util.Date;

public class Bread extends Food {
    String composition;

    public Bread(String name, Date expireDate, Date createDate, Double price, Integer discount, String composition) {
        super(name, expireDate, createDate, price, discount);
        this.composition = composition;
    }
}
