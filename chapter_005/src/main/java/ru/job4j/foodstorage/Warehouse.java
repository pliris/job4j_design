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

    @Override
    public int getPercent(Food food) {
            long create = food.getCreateDate().getTime();
            long expire = food.getExpireDate().getTime();
            long today = System.currentTimeMillis();
            return (int) ((int)  today - create * 100 / expire);
    }

    public List<Food> getList() {
        return LIST;
    }

}

