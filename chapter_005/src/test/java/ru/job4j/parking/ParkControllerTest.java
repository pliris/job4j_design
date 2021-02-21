package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkControllerTest {

    @Test
    public void parkingAdd() {
        Parking truckParking = new TruckParking(8);
        Parking passcarParking = new PasscarParking(8);
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        ParkController controller = new ParkController();
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(truck4);
        assertThat(controller.getVehicleBySeat(0), is(truck2));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void whenHaveNotSeatParkingTruckThenException() {
        Parking truckParking = new TruckParking(5);
        Parking passcarParking = new PasscarParking(5);
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        Vehicle car1 = new PassCar("Volvo", 1);
        Vehicle car2 = new PassCar("Vaz", 1);
        Vehicle car3 = new PassCar("Mazda", 1);
        ParkController controller = new ParkController();
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(truck4);
        controller.parkingVehicle(car1);
        controller.parkingVehicle(car2);
        controller.parkingVehicle(car3);
    }

    @Test
    public void whenAddAndDeleteVehicleThenGetSecondVehicleOnSeat() {
        Parking truckParking = new TruckParking(5);
        Parking passcarParking = new PasscarParking(5);
        Vehicle truck2 = new Truck("Kamaz", 2);
        Vehicle truck3 = new Truck("Kraz", 3);
        Vehicle truck4 = new Truck("Maz",  3);
        Vehicle car1 = new PassCar("Volvo", 1);
        Vehicle car2 = new PassCar("Vaz", 1);
        Vehicle car3 = new PassCar("Mazda", 1);
        ParkController controller = new ParkController();
        controller.parkingVehicle(truck2);
        controller.parkingVehicle(truck3);
        controller.parkingVehicle(car1);
        controller.parkingVehicle(car2);
        controller.parkingVehicle(car3);
        controller.goOutVehicle(car1);
        controller.goOutVehicle(car2);
        controller.parkingVehicle(truck4);
        assertThat(controller.getVehicleBySeat(2), is(truck4));
    }
}