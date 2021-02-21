package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public class PasscarParking implements Parking {
    List<Vehicle> list = new ArrayList<>();

    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return false;
    }

    @Override
    public void deleteVehicle(Vehicle vehicle) {

    }

    @Override
    public int findNearbySeat(int size) {
        return 0;
    }
}
