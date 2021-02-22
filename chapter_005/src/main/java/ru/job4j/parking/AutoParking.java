package ru.job4j.parking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AutoParking implements Parking {
    List<Vehicle> parking;

    public AutoParking(int pass, int truck) {
        this.parking = new ArrayList<>();
    }


    @Override
    public boolean addVehicle(Vehicle vehicle) {
        return parking.add(vehicle);
    }

    @Override
    public void deleteVehicle(int seat) {
        parking.set(seat, null);
    }

    @Override
    public List<Vehicle> getList() {
        return this.parking;
    }

}
