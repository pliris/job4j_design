package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenCreate2UserThenPrint() {
        User first = new User("AAA", 3, 1985, 04, 16);
        User second = new User("AAA", 3, 1985, 04, 16);
        Map<User, Object> map = new HashMap<>();
        map.put(first, 111);
        map.put(second, 222);
        System.out.println(map);




    }

}