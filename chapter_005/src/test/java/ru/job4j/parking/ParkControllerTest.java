package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkControllerTest {

    @Test
    public void parkingAdd() {
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        ParkController controller = new ParkController(6, 4);
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(truck4);
        assertThat(controller.getVehicleBySeat(1), is(truck3));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void whenHaveNotSeatParkingTruckThenException() {
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        Vehicle car1 = new PassCar("Volvo");
        Vehicle car2 = new PassCar("Vaz");
        Vehicle car3 = new PassCar("Mazda");
        ParkController controller = new ParkController(3, 2);
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(truck4);
        controller.parkingVehicle(car1);
        controller.parkingVehicle(car2);
        controller.parkingVehicle(car3);
    }

    @Test
    public void whenAddAndDeleteVehicleThenGetSecondVehicleOnSeat() {
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        Vehicle car1 = new PassCar("Volvo");
        Vehicle car2 = new PassCar("Vaz");
        Vehicle car3 = new PassCar("Mazda");
        ParkController controller = new ParkController(7, 4);
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(car1);
        controller.parkingVehicle(car2);
        controller.parkingVehicle(car3);
        controller.goOutVehicle(2);
        controller.goOutVehicle(4);
        controller.parkingVehicle(truck4);
        assertNull(controller.getVehicleBySeat(2));
    }
}