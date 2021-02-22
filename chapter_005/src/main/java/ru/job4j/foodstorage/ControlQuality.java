package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контролера качесвта Продуктов
 */

public class ControlQuality {
    private List<StoreStrategy> stores;

    /**
     * Конструктор класса Контролера качества
     * @param stores список возможных мест хранения продуктов
     */
    public ControlQuality(List<StoreStrategy> stores) {
        this.stores = stores;
    }

    /**
     * Метод распределяет проудкты в зависимости от условий
     * указанных в реализациях StoreStrategy
     */
    public void resort() {
        for (Food food : this.getAllFoods()) {
            this.distribute(food);
        }
    }

    private List<Food> getAllFoods() {
        List<Food> listFoods = new ArrayList<>();
        for (StoreStrategy store : this.stores) {
            listFoods.addAll(store.getList());
            store.getList().clear();
        }
        return listFoods;
    }


    public void distribute(Food food) {
        for (StoreStrategy store : this.stores) {
            if (store.move(food)) {
                break;
            }
        }
    }
    public List<StoreStrategy> getStores() {
        return stores;
    }

}
