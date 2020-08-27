package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

        public User(String name, int children, int age, int month, int day) {
            this.name = name;
            this.children = children;
            this.birthday = new GregorianCalendar(age, month, day);
        }

        public static void main(String[] args) {
            User first = new User("AAA", 3, 1985, 04, 16);
            User second = new User("AAA", 3, 1985, 04, 16);
            Map<User, Object> map = new HashMap<>();
            map.put(first, 111);
            map.put(second, 222);
            System.out.println(map);
        }
}
