package ru.job4j.foodstorage;

import java.util.List;

public class Warehouse implements StoreStrategy {
    @Override
    public boolean move(Food food) {
        if (this.getPercent(food) < 25) {
            this.LIST.add(food);
            return true;
        } else {
            return false;
        }
    }

    public List<Food> getList() {
        return LIST;
    }

}

