package ru.job4j.foodstorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Интерфейс стратегии распределения продуктов по местам хранения
 */
public interface StoreStrategy {
        List<Food> LIST = new ArrayList<>();

        /**
         * Метод распределния продукта в зависимости от срока годности
         * @param food Класс продукта расширяющий класс Food
         * @return возращаем Истину, если продукт был добавлен в данное хранилище
         */
        public boolean move(Food food);

        /**
         * Метод получения срока годности продукции в процентах
         * @param food Класс продукта расширяющий класс Food
         * @return оставшийся срок годности в процентах, где 100% - окончание сркоа годности
         */
        public int getPercent(Food food);

       public List<Food> getList();

}
