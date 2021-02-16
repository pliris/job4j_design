package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контролера качесвта Продуктов
 */

public class ControlQuality {
    private List<Food> foods;
    private List<StoreStrategy> stores;

    /**
     * Конструктор класса Контролера качества
     * @param foods список продуктов для контроля (проверки)
     * @param stores список возможных мест хранения продуктов
     */
    public ControlQuality(List<Food> foods, List<StoreStrategy> stores) {
        this.foods = foods;
        this.stores = stores;
    }

    /**
     * Метод распределяет проудкты в зависимости от условий
     * указанных в реализациях StoreStrategy
     */
    public void sort() {
            for (Food food : this.foods) {
                for (StoreStrategy store : this.stores) {
                    if (store.move(food)) {
                        break;
                    }
                }
            }
    }
    public List<StoreStrategy> getStores() {
        return stores;
    }

}
