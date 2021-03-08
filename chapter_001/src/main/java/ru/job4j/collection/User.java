package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    public User(String name, int children, int age, int month, int day) {
            this.name = name;
            this.children = children;
            this.birthday = new GregorianCalendar(age, month, day);
        }
    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

        public static void main(String[] args) {
            User first = new User("AAA", 3, 1985, 04, 16);
            User second = new User("AAA", 3, 1985, 04, 16);
            Map<User, Object> map = new Hashtable<>();
            map.put(first, 111);
            map.put(second, 222);
            System.out.println(map);
        }
}
