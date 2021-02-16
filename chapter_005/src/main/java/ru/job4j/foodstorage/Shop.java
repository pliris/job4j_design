package ru.job4j.foodstorage;

import java.util.List;

public class Shop implements StoreStrategy {
    @Override
    public boolean move(Food food) {
        int percentQuality = this.getPercent(food);
        if (percentQuality > 25 && percentQuality < 75) {
            this.LIST.add(food);
            return true;
        } else if (percentQuality > 75 && percentQuality < 100) {
            food.setDiscount(15);
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
