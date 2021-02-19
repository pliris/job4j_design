package ru.job4j.parking;

public class PasscarParking implements Parking {


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
