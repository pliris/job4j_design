package ru.job4j.parking;

import java.util.ArrayList;
import java.util.List;

public interface Parking {
    List<Vehicle> VEHICLES = new ArrayList<>();

    /**
     * Добавляем автомобиль на парковку
     * @param vehicle автомобиль для парковки
     * @return Истина, если автомобиль припаркован
     */
    public boolean addVehicle(Vehicle vehicle);

    /**
     * Удаляем автомобиль с парковки
     * @param vehicle автомобиль для удаления с парковки
     */
    public void deleteVehicle(Vehicle vehicle);

    /**
     * Найти свободные места для парковки
     * @param size размер грузового автомобиля
     * @return индекс в массиве начиная с которого размещаем автомобиль
     */
    public int findNearbySeat(int size);
}
