package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public interface Parking {
    /**
     * Добавляем автомобиль на парковку
     * @param vehicle автомобиль для парковки
     * @return Истина, если автомобиль припаркован
     */
    public boolean addVehicle(Vehicle vehicle);

    /**
     * Удаляем автомобиль с парковки
     * @param seat автомобиль для удаления с парковки
     */
    public void deleteVehicle(int seat);


    public List<Vehicle> getList();
}
