package ru.job4j.dip;

import java.util.HashMap;

public class NoDIP {
    class Car {
        private String name;
        private int fuel;

        public Car(String name) {
            this.name = name;
        }

        public void refuel(GasStation station, int fuel) {
        }
    }


    class GasStation {
        private int priceGasoline;
        private int priceGas;

        public int gasoline(int fuel) {
            return fuel * priceGasoline;
        }

        public int gas(int volume) {
            return volume * priceGas;
        }
    }

    class Dictionary {
        private HashMap<String, String> dict = new HashMap<>();

        public Dictionary(HashMap<String, String> map) {
            this.dict = map;
        }

        public String addWord(String word, String translate) {
            return this.dict.put(word, translate);
        }
    }


    class Jackson {
        private Song song;

        public Song sing() {
                return this.song;
        }

        public void setSong(Song song) {
            this.song = song;
        }
    }

    class Song {
        private String song = "Billie Jean is not my lover Shes just a girl who claims that I am the one"
                + "But the kid is not my son"
                + "She says I am the one, but the kid is not my son";
    }
}


