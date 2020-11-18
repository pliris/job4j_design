package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Apartment {
    private long price;
    private boolean balcony;
    private String address;
    private int[] squareRooms;
    private Bed bed;


    @Override
    public String toString() {
        return "Apartment{"
                + "price=" + price
                + ", balcony=" + balcony
                + ", address='" + address + '\''
                + ", squareRooms=" + Arrays.toString(squareRooms)
                + ", bed=" + bed
                + '}';
    }

    public Apartment(long price, boolean balcony, String address, int[] squareRooms, Bed bed) {
        this.price = price;
        this.balcony = balcony;
        this.address = address;
        this.squareRooms = squareRooms;
        this.bed = bed;
    }

    public static void main(String[] args) {
        Apartment apartToJson = new Apartment(3450000, true,
                "Arkhangelsk, Northern Dvina 118, 92", new int[]{12, 20, 8}, new Bed("white"));
        Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(apartToJson));

        String stringJson =
                "{\"price\":3450000,\"balcony\":true,\"address\":\"Arkhangelsk\",\"square rooms\":[12, 20, 8],\"bed\":{\"color\":\"white\"}}";
        Apartment jsonToApart = gson.fromJson(stringJson, Apartment.class);
        System.out.println(jsonToApart);

    }

}
