package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ParkControllerTest {

    @Test
    public void parkingAdd() {
        Parking truckParking = new TruckParking(8);
        Parking passcarParking = new PasscarParking(8);
        Vehicle truck2 = new Truck("Truck", "Kamaz", "636", 2);
        Vehicle truck3 = new Truck("Truck", "Kraz", "875", 3);
        Vehicle truck4 = new Truck("Truck", "Maz", "234", 3);
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
        Vehicle truck2 = new Truck("Truck", "Kamaz", "636", 2);
        Vehicle truck3 = new Truck("Truck", "Kraz", "875", 3);
        Vehicle truck4 = new Truck("Truck", "Maz", "234", 3);
        Vehicle car1 = new PassCar("Passenger", "Volvo", "345");
        Vehicle car2 = new PassCar("Passenger", "Vaz", "124");
        Vehicle car3 = new PassCar("Passenger", "Mazda", "903");
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
        Vehicle truck2 = new Truck("Truck", "Kamaz", "636", 2);
        Vehicle truck3 = new Truck("Truck", "Kraz", "875", 3);
        Vehicle truck4 = new Truck("Truck", "Maz", "234", 3);
        Vehicle car1 = new PassCar("Passenger", "Volvo", "345");
        Vehicle car2 = new PassCar("Passenger", "Vaz", "124");
        Vehicle car3 = new PassCar("Passenger", "Mazda", "903");
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