package ru.job4j.gc;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    private String name;
    private String password;
    private int age;

    public User(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }


    @Override
    protected void finalize() throws Throwable {
        System.out.println("Removed " + age + " " + name);
    }


    public static void main(String[] args) throws OutOfMemoryError, InterruptedException {
        List<User> userList = new ArrayList<>();
            for (int i = 0; i < 10000; i++) {
                    userList.add(new User("name" + i, i, "pass"));
                    System.out.println(userList.get(i).toString());
            }
        }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", password='" + password + '\''
                + ", age=" + age
                + '}';
    }
}
