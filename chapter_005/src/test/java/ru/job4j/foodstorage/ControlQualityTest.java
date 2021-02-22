package ru.job4j.foodstorage;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ControlQualityTest {
    @Test
    public void move() {
        List<Food> foods = Arrays.asList(
                new Bread("Бородинский",
                        new Date(2021, 2, 12),
                        new Date(2021, 2, 1), 45.0, 0, "Ржаной"),
                new Bread("Пшено",
                        new Date(2021, 2, 30),
                        new Date(2021, 2, 18), 49.0, 0, "Ржаной"),
                new Milk("Холмогорское",
                        new Date(2021, 3, 1),
                        new Date(2021, 2, 18), 32.0, 0, 3.2),
                new Milk("Простоквашино",
                        new Date(2021, 2, 26),
                        new Date(2021, 1, 1), 32.0, 0, 3.2));
        List<StoreStrategy> store = Arrays.asList(new Shop(), new Trash(), new Warehouse());
        ControlQuality controlQuality = new ControlQuality(store);
        for (Food food : foods) {
            controlQuality.distribute(food);
        }
        controlQuality.resort();
        Food exp = new Bread("Бородинский",
                new Date(2021, 2, 12),
                new Date(2021, 2, 1), 45.0, 0, "Ржаной");
        assertThat(controlQuality.getStores().get(1).getList().get(0).toString(), is(exp.toString()));

    }
}