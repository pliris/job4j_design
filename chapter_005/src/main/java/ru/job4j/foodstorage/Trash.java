package ru.job4j.foodstorage;

import java.util.List;

public class Trash implements StoreStrategy {
    @Override
    public boolean move(Food food) {
        int percentQuality = this.getPercent(food);
        if (percentQuality >= 100) {
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
