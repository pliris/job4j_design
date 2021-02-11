package ru.job4j.ood.ocp;

public class Animals {

    private class Dog {
        private void sound() {
            System.out.println("Гав - гав");
        }

    }

    private class Cat {
        private void sound() {
            System.out.println("Мяу - мяу");
        }
    }
}
